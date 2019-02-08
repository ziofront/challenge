package com.ziofront.challenge.client;

import com.ziofront.challenge.client.impl.KakaoMapClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class TestFeignClient {

    private static final Logger LOG = LoggerFactory.getLogger(TestFeignClient.class);

    KakaoMapClient client;

    @Before
    public void init() {
        client =  Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(BookClient.class))
                .logLevel(feign.Logger.Level.FULL)
                .target(KakaoMapClient.class, "https://dapi.kakao.com/v2/local/search/keyword.json");
    }

    public void testRest() {
        LOG.debug("hello world");

//        client.findKeyword("카카오프렌즈", "37.514322572335935&", "127.06283102249932", "20000");

//        "카카오프렌즈", "37.514322572335935&", "127.06283102249932", "20000"



//        curl -v -X GET "https://dapi.kakao.com/v2/local/search/keyword.json?y=37.514322572335935&x=&radius=20000" \
//        --data-urlencode "query=카카오프렌즈" \
//        -H "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
//        bookClient
//
//        KakaoMapClient client = Feign.builder().target(KakaoMapClient.class, "https://dapi.kakao.com/v2/local/search/keyword.json");
//        client.findKeyword();

//        curl -v -X GET "https://dapi.kakao.com/v2/local/search/keyword.json?y=37.514322572335935&x=&radius=20000" \
//        --data-urlencode "query=카카오프렌즈" \
//        -H "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
    }


}
