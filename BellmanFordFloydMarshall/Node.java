package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {
    Integer ID;
    List<Arc> outgoingArcs = new ArrayList<>();

    public Node(Integer ID){
        this.ID = ID;
    }

    public void setOutgoingArc(Arc arc){
        if(!outgoingArcs.contains(arc))
            outgoingArcs.add(arc);
    }

    public Integer getID() {
        return ID;
    }
}
