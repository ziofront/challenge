package com.ziofront.challenge.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private String isbn;
    private String author;
    private String title;
    private String synopsis;
    private String language;



}