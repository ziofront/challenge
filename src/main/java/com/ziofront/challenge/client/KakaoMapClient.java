package com.ziofront.challenge.client;

import com.ziofront.challenge.client.vo.KeywordResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

import java.util.Map;


public interface KakaoMapClient {

    @Headers({
            "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
    })
    @GET("v2/local/search/keyword.json")
    public Call<KeywordResponse> findPlaceByKeyword(@QueryMap Map<String, String> queryMap);

}
