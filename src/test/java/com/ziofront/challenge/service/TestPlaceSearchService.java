package com.ziofront.challenge.service;

import com.google.gson.GsonBuilder;
import com.ziofront.challenge.service.impl.KakaoPlaceService;
import com.ziofront.challenge.vo.Place;
import com.ziofront.challenge.vo.external.kakaomap.KeywordResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPlaceSearchService {


    private static Logger LOG = LoggerFactory.getLogger(TestPlaceSearchService.class);

    @Autowired
    PlaceFindService placeSearchService;

    @Test
    public void test1FindByKeyword() throws Exception {

        Pageable p = Pageable.unpaged();

        Place place = placeSearchService.findByKeyword("하나은행", p);

        LOG.debug("place={}", new GsonBuilder().setPrettyPrinting().create().toJson(place));

        assertTrue(place.getPlaceList() != null);

    }

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

        KakaoPlaceService.KakaoMapClient service = retrofit.create(KakaoPlaceService.KakaoMapClient.class);
        Response<KeywordResponse> response = service.findPlaceByKeyword(queryMap).execute();

        assertEquals(200, response.code());

        LOG.debug("response.isSuccessful()={}", response.isSuccessful());
        LOG.debug("response.body()={}", new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
        LOG.debug("response.errorBody()={}", response.errorBody());
        LOG.debug("response.code()={}", response.code());
        LOG.debug("response.raw()={}", response.raw());



    }


}
