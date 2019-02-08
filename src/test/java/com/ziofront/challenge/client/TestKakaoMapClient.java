package com.ziofront.challenge.client;

import com.ziofront.challenge.client.vo.KeywordResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestKakaoMapClient {

    private static Logger LOG = LoggerFactory.getLogger(TestKakaoMapClient.class);


    @Test
    public void test1FindPlaceByKeyword() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com/").addConverterFactory(GsonConverterFactory.create())
                .build();

        KakaoMapClient service = retrofit.create(KakaoMapClient.class);

        Map queryMap = new HashMap<String, String>();
        queryMap.put("query", "카카오프렌즈");
//        queryMap.put("y", "37.514322572335935");
//        queryMap.put("x", "127.06283102249932");
//        queryMap.put("radius", "20000");
        Call<KeywordResponse> response = service.findPlaceByKeyword(queryMap);

        LOG.debug("response.request().headers()={}", response.request().headers());
        LOG.debug("response={}", response.request());
        LOG.debug("response.isExecuted()={}", response.isExecuted());

        Response<KeywordResponse> response2 = response.execute();

        LOG.debug("response.isExecuted()={}", response.isExecuted());
        LOG.debug("response2.isSuccessful()={}", response2.isSuccessful());
        LOG.debug("response2.body()={}", response2.body());
        LOG.debug("response2.errorBody()={}", response2.errorBody());
        LOG.debug("response2.code()={}", response2.code());
        LOG.debug("response2.raw()={}", response2.raw());


        assertEquals(200, response2.code());


    }

}
