package com.ziofront.challenge.web.controller;

import com.ziofront.challenge.service.PlaceService;
import com.ziofront.challenge.web.model.response.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/place")
public class PlaceController {

    private static Logger LOG = LoggerFactory.getLogger(PlaceController.class);

    @Autowired
    private PlaceService placeService;

    @GetMapping("/find/{keyword}")
    public List<Place> find(@RequestParam(value = "keyword", defaultValue = "None") String keyword) throws Exception {

        LOG.debug("keyword={}", keyword);

        List<Place> resultList = placeService.findByKeyword(keyword);

        LOG.debug("resultList={}", resultList);

        return resultList;
    }

    @GetMapping("/find2")
    public List<Place> find2(@RequestParam(value = "keyword", defaultValue = "None") String keyword
            , @RequestParam(value = "page", defaultValue = "1") int page) throws Exception {

        LOG.debug("keyword={}, page={}", keyword, page);

        List<Place> resultList = placeService.findByKeyword(keyword);

        LOG.debug("resultList={}", resultList);

        return resultList;
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {

        return e.getMessage();
    }

}
