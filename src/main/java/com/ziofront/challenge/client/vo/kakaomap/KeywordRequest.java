package com.ziofront.challenge.client.vo.kakaomap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KeywordRequest {

    private String query;
    private String category_group_code;
    private String x;
    private String y;
    private int radius;
    private String rect;
    private int page;
    private int size;

}
