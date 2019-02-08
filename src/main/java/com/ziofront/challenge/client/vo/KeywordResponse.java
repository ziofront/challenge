package com.ziofront.challenge.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class KeywordResponse {

    private Meta meta;
    private List<Document> documents;


}
