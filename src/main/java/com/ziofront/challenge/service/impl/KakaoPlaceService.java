package com.ziofront.challenge.service.impl;

import com.ziofront.challenge.client.KakaoMapClient;
import com.ziofront.challenge.client.vo.kakaomap.KeywordResponse;
import com.ziofront.challenge.service.PlaceFindService;
import com.ziofront.challenge.vo.Place;
import org.springframework.data.domain.Pageable;
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
public class KakaoPlaceService implements PlaceFindService {

    @Override
    public Place findByKeyword(String keyword, Pageable pageable) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com/").addConverterFactory(GsonConverterFactory.create())
                .build();

        Map queryMap = new HashMap<String, String>();
        queryMap.put("query", keyword);
        queryMap.put("page", pageable.getPageNumber());
        queryMap.put("size", pageable.getPageSize());

        KakaoMapClient service = retrofit.create(KakaoMapClient.class);
        Response<KeywordResponse> response = service.findPlaceByKeyword(queryMap).execute();

        List<Place.Item> list = new ArrayList<Place.Item>();
        response.body().getDocuments().forEach(it -> list.add(Place.Item.builder().id(it.getId()).name(it.getPlaceName()).x(it.getX()).y(it.getY()).url(it.getPlaceUrl()).build()));

        Place place = Place.builder().totalCount(response.body().getMeta().getTotalCount()).pageableCount(response.body().getMeta().getPageableCount()).placeList(list).build();

        return place;
    }
}
