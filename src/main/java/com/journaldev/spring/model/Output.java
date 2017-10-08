package com.journaldev.spring.model;

import java.util.List;

public class Output {

    private List<String> log_messages;

    private List<String> text;

    private List<String> nodes_visited;

    public void setLog_messages(List<String> log_messages){
        this.log_messages = log_messages;
    }
    public List<String> getLog_messages(){
        return this.log_messages;
    }
    public void setText(List<String> text){
        this.text = text;
    }
    public List<String> getText(){
        return this.text;
    }
    public void setNodes_visited(List<String> nodes_visited){
        this.nodes_visited = nodes_visited;
    }
    public List<String> getNodes_visited(){
        return this.nodes_visited;
    }

}
