package com.paginationExample.request;

public class BookInput {
    private String title;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookInput{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
