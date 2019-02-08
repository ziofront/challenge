package com.ziofront.challenge.client.impl;

import com.ziofront.challenge.client.vo.KeywordResponse;
import feign.Body;
        import feign.Headers;
        import feign.Param;
        import feign.RequestLine;

@Headers("Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb")
public interface KakaoMapClient {

    @RequestLine("GET")
    public KeywordResponse findKeyword(@Param("query") String query, @Param("x") String x, @Param("y")  String y, @Param("radius") String radius)  ;
}
