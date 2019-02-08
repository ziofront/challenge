package com.ziofront.challenge.service;

import com.ziofront.challenge.web.model.Place;

import java.util.List;

public interface PlaceService {

    public List<Place> findByKeyword(String keyword);

}
