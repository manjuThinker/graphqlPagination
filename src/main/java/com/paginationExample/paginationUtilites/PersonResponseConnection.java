package com.paginationExample.paginationUtilites;

import java.util.List;

public class PersonResponseConnection {
    private List<PersonResponseEdge> edges;
    private PageInfo pageInfo;


    public List<PersonResponseEdge> getEdges() {
        return edges;
    }

    public void setEdges(List<PersonResponseEdge> edges) {
        this.edges = edges;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}