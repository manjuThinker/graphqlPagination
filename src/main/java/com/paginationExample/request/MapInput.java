package com.paginationExample.request;

import java.util.List;

public class MapInput {
    private String key;
    private List<String> value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MapInput{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
