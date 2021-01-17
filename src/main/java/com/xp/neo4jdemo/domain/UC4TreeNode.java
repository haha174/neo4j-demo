package com.xp.neo4jdemo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "uc4node")
public class UC4TreeNode implements Serializable {

    @Id
    private String id;

    private String name;

    private String process;

    private String title;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProcess() {
        return process;
    }

    public String getTitle() {
        return title;
    }
}
