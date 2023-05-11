package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args){
	// write your code here
        System.out.println("PATHS START");
        List<Node> nodes = initialize();
        Long[][] paths = getPaths(nodes);
        Long[][] paths3 = getPaths(nodes);
        for(Long[] i : paths){
            for(Long k : i){
                System.out.print(k + " ");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
        bellmanFord(paths);
        for(Long[] i : paths){
            for(Long k : i){
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        System.out.println("PATHS 3 START");
        for(Long[] i : paths3){
            for(Long k : i){
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        FloydWarshall(paths3);
        for(Long[] i : paths3){
            for(Long k : i){
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();


        System.out.println("PATHS 2 START");
        List<Node> nodes2 = initialize2();
        Long[][] paths2 = getPaths(nodes2);
        Long[][] paths4 = getPaths(nodes2);
        for(Long[] i : paths2){
            for(Long k : i){
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        bellmanFord(paths2);
        for(Long[] i : paths2){
            for(Long k : i){
                System.out.print(k + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println("PATHS 4 START");
        for(Long[] i : paths4){
            for(Long k : i){
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        FloydWarshall(paths4);
        for(Long[] i : paths4){
            for(Long k : i){
                System.out.print(k + " ");
            }
            System.out.println();
        }
        Long[][] a={{1L,2L,3L},{4L,5L,6L}};
        Long[][] b={{7L,8L}, {9L,10L}, {11L,12L}};
        /* Long[][] result = matrixMultiplication(a, b);
        for(Long[] i : result){
            for(Long j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

         */
    }


    public static List<Node> initialize(){
        Node V0 = new Node(0);
        Node V1 = new Node (1);
        Node V2 = new Node (2);
        Node V3 = new Node (3);
        Node V4 = new Node (4);
        Node V5 = new Node (5);
        ArrayList<Node> nodes = new ArrayList<>(List.of(V0, V1, V2, V3, V4, V5));
        V0.setOutgoingArc(new Arc(15, V1));
        V0.setOutgoingArc(new Arc(1, V2));
        V0.setOutgoingArc(new Arc(9, V5));
        V1.setOutgoingArc(new Arc(3, V3));
        V1.setOutgoingArc(new Arc(4, V4));
        V2.setOutgoingArc(new Arc(5, V3));
        V3.setOutgoingArc(new Arc(2, V5));
        V4.setOutgoingArc(new Arc(7, V0));
        V5.setOutgoingArc(new Arc(2, V1));
        return nodes;
    }

    public static List<Node> initialize2(){
        Node V0 = new Node(0);
        Node V1 = new Node (1);
        Node V2 = new Node (2);
        Node V3 = new Node (3);
        Node V4 = new Node (4);
        Node V5 = new Node (5);
        Node V6 = new Node(6);
        Node V7 = new Node(7);
        ArrayList<Node> nodes = new ArrayList<>(List.of(V0, V1, V2, V3, V4, V5, V6, V7));
        V0.setOutgoingArc(new Arc(15, V1));
        V0.setOutgoingArc(new Arc(1, V2));
        V0.setOutgoingArc(new Arc(9, V5));
        V1.setOutgoingArc(new Arc(3, V3));
        V1.setOutgoingArc(new Arc(9, V4));
        V2.setOutgoingArc(new Arc(-5, V3));
        V3.setOutgoingArc(new Arc(2, V5));
        V4.setOutgoingArc(new Arc(-7, V0));
        V5.setOutgoingArc(new Arc(2, V1));
        V6.setOutgoingArc(new Arc(5, V7));
        V7.setOutgoingArc(new Arc(10, V6));
        return nodes;
    }

    public static Long[][] getPaths(List<Node> nodes){
        Long[][] paths = new Long[nodes.size()][nodes.size()];
        for(int i=0; i < nodes.size(); i++){
            paths[i][i] = 0L;
            Iterator<Arc> arcs = nodes.get(i).outgoingArcs.iterator();
            for(int j = 0; j < nodes.size(); j++){
                if(arcs.hasNext()){
                    Arc current = arcs.next();
                    paths[i][current.destination.getID()] = (long) current.length;
                }
                if(paths[i][j] == null){
                    paths[i][j] = (long) Integer.MAX_VALUE;
                }
            }
        }
        return paths;
    }

    public static void bellmanFord(Long[][] paths){
        for(int i = 0; i < paths.length-1; i++){
            for(int j = 0; j < paths.length; j++){
                if(paths[j][j] != null && paths[j][j] < 0)
                    paths[j][j] = null;
                for(int k=0; k < paths.length; k++){
                    for(int l = 0; l < paths.length; l++){
                        if(paths[j][j] == null){
                            if(paths[k][l] != null && paths[k][l] != Integer.MAX_VALUE){
                                paths[k][l] = null;
                            }
                        }
                        if(paths[j][l] == null || paths[j][k] == null || paths[l][k] == null)
                            continue;
                        if(paths[j][l] + paths[l][k] < paths[j][k]){
                            paths[j][k] = paths[j][l] + paths[l][k];
                        }
                    }
                }
            }
        }
    }


    public static void FloydWarshall(Long[][] paths){
        for(int i = 0; i < paths.length; i++){
            for(int j = 0; j < paths.length; j++){
                for(int k = 0; k < paths.length; k++){
                    if(paths[j][i] + paths[i][k] < paths[j][k])
                        paths[j][k] = paths[j][i] + paths[i][k];
                }
            }
        }
    }


/*
    public static Long[][] matrixMultiplication(Long[][] matrix1, Long[][] matrix2){
        Long[][] result = new Long[matrix1.length][matrix2[0].length];
        for(int x = 0; x < matrix1.length; x++){
            for(int i = 0; i < matrix1.length; i++){
                for(int j = 0; j < matrix2.length; j++){
                    result[x][i] += matrix1[x][j] * matrix2[j][i];
                }
            }
        }
        return result;
    }

 */
/*
    public static Long[][] bellmanFordAccelerated(Long[][] paths){
        for(int i = 1; i < paths.length; i++){
            paths = matrixMultiplication(paths, paths);
        }
        return paths;
    }

 */
}
