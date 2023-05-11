package com.company;

import java.util.*;

public class Node {
    private String name;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String str){
        this.name = str;
    }

    public void addDestination(Node destination, Integer distance){
        adjacentNodes.put(destination, distance);
    }

    public void setDistance(Integer distance){
        this.distance = distance;
    }

    public Integer getDistance(){
        return this.distance;
    }

    public List<Node> getShortestPath(){
        return shortestPath;
    }

    public void setShortestPath(List<Node> path){
        shortestPath = path;
    }

    public static Graph calculateTheShortestPaths(Graph graph, Node source){
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while(unsettledNodes.size() != 0){
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for(Map.Entry<Node, Integer> adjacencyPair : currentNode.adjacentNodes.entrySet()){
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if(!settledNodes.contains(adjacentNode)){
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode){
        Integer sourceDistance = sourceNode.getDistance();
        if(sourceNode.getDistance() + edgeWeight < evaluationNode.getDistance()){
            evaluationNode.setDistance(sourceDistance + edgeWeight);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node getLowestDistanceNode(Set<Node> nodes){
        Node min = new Node("a");
        min.setDistance(Integer.MAX_VALUE);
        for(Node p : nodes){
            if(p.getDistance() < min.getDistance()){
                min = p;
            }
        }
        return min;
    }


}
