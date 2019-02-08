package com.ziofront.challenge.client.vo;

import java.util.List;

import lombok.Data;

@Data
public class SameName {

    List<String> region;
    String keyword;
    String selected_region;
}