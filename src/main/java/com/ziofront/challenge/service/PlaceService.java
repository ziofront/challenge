package com.ziofront.challenge.service;

import com.ziofront.challenge.web.model.response.Place;

import java.io.IOException;
import java.util.List;

public interface PlaceService {

    public List<Place> findByKeyword(String keyword) throws IOException;

    public List<Place> findByKeyword(String keyword, int page);

}
