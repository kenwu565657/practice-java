package com.practice.java.group;

public class Link {
    private String fromId;
    private String toId;

    public Link(String fromId, String toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public String getToId() {
        return toId;
    }
}
