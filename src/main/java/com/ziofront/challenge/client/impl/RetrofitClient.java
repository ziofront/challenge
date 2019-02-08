package com.ziofront.challenge.client.impl;

import com.ziofront.challenge.client.vo.KeywordResponse;
import com.ziofront.challenge.client.vo.KakaoMapRequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface RetrofitClient {


    @Headers({
            "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
            ,"Content-Type: application/json;charset=UTF-8"
    })
    @GET("v2/local/search/keyword.json")
    public Call<KeywordResponse> findKeyword(@QueryMap Map<String, String> queryMap, @Body String query);



    @Headers({
            "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
    })
    @GET("v2/local/search/keyword.json")
    public Call<KeywordResponse> findKeyword2(@QueryMap Map<String, String> queryMap);



    @Headers({
            "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
    })
    @POST("v2/local/search/keyword.json")
    public Call<KeywordResponse> findKeyword3(@QueryMap Map<String, String> queryMap, @Query("query") String query);

}
