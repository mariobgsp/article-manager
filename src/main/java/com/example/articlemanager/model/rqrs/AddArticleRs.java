package com.example.articlemanager.model.rqrs;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AddArticleRs {

    private int id;
    private String title;
    private String body;
    private String author;

}
