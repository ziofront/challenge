package com.ziofront.challenge.web.controller.rest;

import com.ziofront.challenge.service.PlaceFindHIstoryService;
import com.ziofront.challenge.service.PlaceFindService;
import com.ziofront.challenge.vo.Place;
import com.ziofront.challenge.vo.Top10History;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/place")
public class PlaceController {

    private static Logger LOG = LoggerFactory.getLogger(PlaceController.class);

    @Autowired
    private PlaceFindService placeService;

    @Autowired
    private PlaceFindHIstoryService placeFindHIstoryService;

    @GetMapping("/find")
    public Place find(@RequestParam(value = "keyword", defaultValue = "None") String keyword
            , @PageableDefault(page = 1, size = 10) Pageable pageable) throws Exception {

        LOG.debug("keyword={}, pageable={}", keyword, pageable);
        Place place = placeService.findByKeyword(keyword, pageable);
        return place;
    }

    @GetMapping("/top10")
    public List<Top10History> findTop10History() {

        List<Top10History> list = placeFindHIstoryService.findTop10History();
        LOG.debug("list={}", list);
        return list;

    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {

        return e.getMessage();
    }

}
