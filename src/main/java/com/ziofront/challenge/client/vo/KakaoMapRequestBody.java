package com.ziofront.challenge.client.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KakaoMapRequestBody {

    private String query;

    private String x;

    private String y;

    private String radius;

}
