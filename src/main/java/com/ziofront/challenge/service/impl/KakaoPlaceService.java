package com.ziofront.challenge.service.impl;

import com.ziofront.challenge.service.PlaceFindService;
import com.ziofront.challenge.vo.Place;
import com.ziofront.challenge.vo.external.kakaomap.KeywordResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KakaoPlaceService implements PlaceFindService {

    private static Logger LOG = LoggerFactory.getLogger(KakaoPlaceService.class);

    public static interface KakaoMapClient {

        @Headers({
                "Authorization: KakaoAK 7be88bfe34edc3201b0c8cfe53b68fdb"
        })
        @GET("keyword.json")
        public Call<KeywordResponse> findPlaceByKeyword(@QueryMap Map<String, String> queryMap);

    }

    @Override
    public Place findByKeyword(String keyword, Pageable pageable) throws IOException {

        LOG.debug("pageable={}",pageable);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com/v2/local/search/").addConverterFactory(GsonConverterFactory.create())
                .build();

        Map queryMap = new HashMap<String, String>();
        queryMap.put("query", keyword);
        queryMap.put("page", pageable.getPageNumber());
        queryMap.put("size", pageable.getPageSize());

        KakaoMapClient service = retrofit.create(KakaoMapClient.class);

        Response<KeywordResponse> response = service.findPlaceByKeyword(queryMap).execute();

        LOG.info("response.body()={}", response.body());
        LOG.debug("response.message()={}",response.message());
        LOG.debug("response.raw()=", response.raw());

        List<Place.Item> list = new ArrayList<Place.Item>();
        response.body().getDocuments().forEach(it -> list.add(Place.Item
                .builder()
                .id(it.getId())
                .name(it.getPlaceName())
                .x(it.getX())
                .y(it.getY())
                .url(it.getPlaceUrl())
                .phone(it.getPhone())
                .address1(it.getAddressName())
                .address2(it.getRoadAddressName())
                .categoryName(it.getCategoryName())
                .build()));

        LOG.info("response.body().getMeta().getTotalCount()={}", response.body().getMeta().getTotalCount());

        Place place = Place.builder().totalCount(response.body().getMeta().getTotalCount()).pageableCount(response.body().getMeta().getPageableCount()).placeList(list).build();

        return place;
    }
}
