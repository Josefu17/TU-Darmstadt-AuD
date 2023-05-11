package com.company;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node a){
        nodes.add(a);
    }

}
