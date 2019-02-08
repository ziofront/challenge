package com.ziofront.challenge.service.impl;

import com.ziofront.challenge.service.PlaceService;
import com.ziofront.challenge.web.model.Place;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KakaoPlaceService implements PlaceService {

    @Override
    public List<Place> findByKeyword(String keyword) {


        // TODO 일단은 임시 하드 코딩

        List<Place> list = new ArrayList<Place>();

        list.add(Place.builder().id("1").name("서울시").x("74895652").y("77885566").url("http://abc.com").build());
        list.add(Place.builder().id("2").name("수원시").x("78320000").y("12358333").url("http://www.hello.com").build());
        list.add(Place.builder().id("4").name("부산시").x("21463883").y("12028894").url("http://www.world.com").build());
        list.add(Place.builder().id("3").name("용인시").x("45248935").y("65465909").url("http://kakao.co.kr").build());
        list.add(Place.builder().id("5").name("해남군").x("68753355").y("09090786").url("http://popo.net").build());


        return list;
    }
}
