package com.ziofront.challenge.client;

import com.ziofront.challenge.client.impl.RetrofitClient;
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

public class TestRetrofitClient {

    private static Logger LOG = LoggerFactory.getLogger(TestRetrofitClient.class);


    @Test
    public void test1() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com/").addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitClient service = retrofit.create(RetrofitClient.class);

        Map queryMap = new HashMap<String, String>();
        queryMap.put("query", "카카오프렌즈");
        queryMap.put("x", "37.514322572335935&");
        queryMap.put("y", "127.06283102249932");
        queryMap.put("radius", "20000");
        Call<KeywordResponse> response = service.findKeyword2(queryMap);

        LOG.debug("response={}", response.request());
        LOG.debug("response.isExecuted()={}", response.isExecuted());
        Response<KeywordResponse> response2 = response.execute();
        LOG.debug("response.isExecuted()={}", response.isExecuted());

        LOG.debug("response2.isSuccessful()={}", response2.isSuccessful());
        LOG.debug("response2.body()={}", response2.body());
        LOG.debug("response2.errorBody()={}", response2.errorBody());

//        KeywordResponse response = service.findKeyword(KakaoMapRequestBody.builder().query("카카오프렌즈").x("37.514322572335935&").y("127.06283102249932").radius("20000").build());
    }

}
