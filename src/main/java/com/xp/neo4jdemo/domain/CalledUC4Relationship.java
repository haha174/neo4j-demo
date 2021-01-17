package com.xp.neo4jdemo.domain;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "UC4RELA")
public class CalledUC4Relationship {

    @Id
    private String id;

    @StartNode
    private UC4TreeNode startNode;

    @EndNode
    private UC4TreeNode endNode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UC4TreeNode getStartNode() {
        return startNode;
    }

    public void setStartNode(UC4TreeNode startNode) {
        this.startNode = startNode;
    }

    public UC4TreeNode getEndNode() {
        return endNode;
    }

    public void setEndNode(UC4TreeNode endNode) {
        this.endNode = endNode;
    }
}
