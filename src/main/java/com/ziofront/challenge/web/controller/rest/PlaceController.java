package com.ziofront.challenge.web.controller.rest;

import com.ziofront.challenge.service.PlaceService;
import com.ziofront.challenge.vo.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/place")
public class PlaceController {

    private static Logger LOG = LoggerFactory.getLogger(PlaceController.class);

    @Autowired
    private PlaceService placeService;

    @GetMapping("/find")
    public Place find(@RequestParam(value = "keyword", defaultValue = "None") String keyword
            , Pageable pageable) throws Exception {

        LOG.debug("keyword={}, pageable={}", keyword, pageable);

        Place place = placeService.findByKeyword(keyword, pageable);

        List<Place.Item> resultList = place.getPlaceList();

        LOG.debug("resultList={}", resultList);

        return place;
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {

        return e.getMessage();
    }

}
