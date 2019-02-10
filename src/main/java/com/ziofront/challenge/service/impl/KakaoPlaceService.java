package com.ziofront.challenge.service.impl;

import com.ziofront.challenge.vo.external.kakaomap.KeywordResponse;
import com.ziofront.challenge.service.PlaceFindService;
import com.ziofront.challenge.vo.Place;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KakaoPlaceService implements PlaceFindService {

    public static interface KakaoMapClient {

        @Headers({
                "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
        })
        @GET("v2/local/search/keyword.json")
        public Call<KeywordResponse> findPlaceByKeyword(@QueryMap Map<String, String> queryMap);


        @Headers({
                "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
        })
        @GET("v2/local/search/keyword.json")
        public Call<KeywordResponse> findPlaceByKeyword(@Query("query") String keyword);
    }

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
