package com.ziofront.challenge.client;

import com.google.gson.GsonBuilder;
import com.ziofront.challenge.client.vo.kakaomap.KeywordResponse;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestKakaoMapClient {

    private static Logger LOG = LoggerFactory.getLogger(TestKakaoMapClient.class);

    private Retrofit retrofit;

    @Before
    public void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com/").addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Test
    public void test1_FindPlaceByKeyword() throws IOException {

        Map queryMap = new HashMap<String, String>();
        queryMap.put("query", "카카오프렌즈");
//        queryMap.put("y", "37.514322572335935");
//        queryMap.put("x", "127.06283102249932");
//        queryMap.put("radius", "20000");

        KakaoMapClient service = retrofit.create(KakaoMapClient.class);
        Response<KeywordResponse> response = service.findPlaceByKeyword(queryMap).execute();

        assertEquals(200, response.code());

        LOG.debug("response.isSuccessful()={}", response.isSuccessful());
        LOG.debug("response.body()={}", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
        LOG.debug("response.errorBody()={}", response.errorBody());
        LOG.debug("response.code()={}", response.code());
        LOG.debug("response.raw()={}", response.raw());



    }

//
//    @Test
//    public void test2_FindPlaceByKeyword() throws IOException {
//
//        KakaoMapClient service = retrofit.create(KakaoMapClient.class);
//
//        Response<KeywordResponse> response = service.findPlaceByKeyword("카카오프렌즈").execute();
//
//        LOG.debug("response.isSuccessful()={}", response.isSuccessful());
//        LOG.debug("response.body()={}", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
//        LOG.debug("response.errorBody()={}", response.errorBody());
//        LOG.debug("response.code()={}", response.code());
//        LOG.debug("response.raw()={}", response.raw());
//
//        assertEquals(200, response.code());
//
//
//    }

}
