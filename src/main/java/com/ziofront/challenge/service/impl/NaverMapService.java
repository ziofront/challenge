package com.ziofront.challenge.service.impl;

import com.ziofront.challenge.service.PlaceFindService;
import com.ziofront.challenge.vo.Place;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 해당 프로그램은 데모용 입니다.
 */
@Service("NaverMap")
public class NaverMapService implements PlaceFindService {

    @Override
    public Place findByKeyword(String keyword, Pageable pageable) throws IOException {

        List<Place.Item> placeList = new ArrayList<>();

        IntStream.rangeClosed(1, 15).forEach(i -> placeList.add(
                Place.Item.builder()
                        .name("장소" + padLeftSpaces(String.valueOf(i), 4))
                        .categoryName("카테고리" + padLeftSpaces(String.valueOf(i), 4))
                        .phone("02-1111-" + padLeftSpaces(String.valueOf(i), 4))
                        .address1("서울시 어쩌구 저쩌동 " + padLeftSpaces(String.valueOf(i), 4))
                        .mapUrl("http://naver.com/" + padLeftSpaces(String.valueOf(i), 4)).build())
        );

        return Place.builder().totalCount(44).pageableCount(10).placeList(placeList).build();
    }

    public static String padLeftSpaces(String str, int n) {
        return String.format("%1$" + n + "s", str).replace(' ', '0');
    }
}
