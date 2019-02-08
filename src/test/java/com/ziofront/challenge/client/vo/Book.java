package com.ziofront.challenge.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Book {

    private String isbn;
    private String author;
    private String title;
    private String synopsis;
    private String language;



}