package com.ziofront.challenge.client.vo;

import lombok.Data;

import java.util.List;

@Data
public class SameName {

    List<String> region;
    String keyword;
    String selected_region;
}