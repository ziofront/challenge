package com.ziofront.challenge.web.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Place {

    private String id;
    private String name;
    private String x;
    private String y;
    private String url;

}
