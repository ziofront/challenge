package com.ziofront.challenge.web.controller;

import com.ziofront.challenge.service.PlaceService;
import com.ziofront.challenge.web.model.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api/place")
public class PlaceController {

    private static Logger LOG = LoggerFactory.getLogger(PlaceController.class);

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/find/{keyword}", method = RequestMethod.GET)
    public List<Place> find(@RequestParam(value = "keyword", defaultValue = "None") String keyword) {

        LOG.debug("keyword={}", keyword);

        List<Place> resultList = placeService.findByKeyword(keyword);

        LOG.debug("resultList={}", resultList);

        return resultList;
    }

}
