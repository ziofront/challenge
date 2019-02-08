package com.ziofront.challenge.service.impl;

import com.ziofront.challenge.client.KakaoMapClient;
import com.ziofront.challenge.client.vo.kakaomap.KeywordResponse;
import com.ziofront.challenge.service.PlaceService;
import com.ziofront.challenge.web.model.response.Place;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KakaoPlaceService implements PlaceService {

    @Override
    public List<Place> findByKeyword(String keyword) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dapi.kakao.ceom/").addConverterFactory(GsonConverterFactory.create())
                .build();

        Map queryMap = new HashMap<String, String>();
        queryMap.put("query", keyword);
//        queryMap.put("y", "37.514322572335935");
//        queryMap.put("x", "127.06283102249932");
//        queryMap.put("radius", "20000");

        KakaoMapClient service = retrofit.create(KakaoMapClient.class);
        Response<KeywordResponse> response = service.findPlaceByKeyword(queryMap).execute();

//        response.body().getDocuments()

        // TODO 일단은 임시 하드 코딩

        List<Place> list = new ArrayList<Place>();

        list.add(Place.builder().id("1").name("서울시").x("74895652").y("77885566").url("http://abc.com").build());
        list.add(Place.builder().id("2").name("수원시").x("78320000").y("12358333").url("http://www.hello.com").build());
        list.add(Place.builder().id("4").name("부산시").x("21463883").y("12028894").url("http://www.world.com").build());
        list.add(Place.builder().id("3").name("용인시").x("45248935").y("65465909").url("http://kakao.co.kr").build());
        list.add(Place.builder().id("5").name("해남군").x("68753355").y("09090786").url("http://popo.net").build());


        return list;
    }

    @Override
    public List<Place> findByKeyword(String keyword, int page) {



        return null;
    }
}
