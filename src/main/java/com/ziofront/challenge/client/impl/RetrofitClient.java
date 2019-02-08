package com.ziofront.challenge.client.impl;

import com.ziofront.challenge.client.vo.KeywordResponse;
import com.ziofront.challenge.client.vo.KakaoMapRequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface RetrofitClient {


//    @Headers({
//            "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
//    })
//    @GET("v2/local/search/keyword.json")
//    public KeywordResponse findKeyword(@Body KakaoMapRequestBody requestBody);

    @Headers({
            "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
    })
    @GET("v2/local/search/keyword.json")
    public Call<KeywordResponse> findKeyword2(@QueryMap Map<String, String> queryMap);

}
