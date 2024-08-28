package com.paginationExample.paginationUtilites;

import com.paginationExample.dto.PersonResponse;

public class PersonResponseEdge {
    private PersonResponse node;
    private String cursor;

    public PersonResponse getNode() {
        return node;
    }

    public void setNode(PersonResponse node) {
        this.node = node;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}