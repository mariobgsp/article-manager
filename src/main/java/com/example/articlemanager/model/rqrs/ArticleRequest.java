package com.example.articlemanager.model.rqrs;

public class ArticleRequest {

    private String title;
    private String body;
    private String author;

    public ArticleRequest() {
    }

    public ArticleRequest(String title, String body, String author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }
}
