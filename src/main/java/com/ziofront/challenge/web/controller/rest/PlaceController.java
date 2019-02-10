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

//        maxDisplayPage = 7;
//        currentPage = 17
//        totalCount = 1230;
//        pageSize = 10;
//        totalPage = parseInt(totalCount / pageSize);
//        totalPage = (totalCount % pageSize > 0) ? totalPage + 1 : totalPage;
//        console.info('totalPage=' + totalPage);
//
//        totalPageSet = parseInt(totalPage / maxDisplayPage);
//        totalPageSet = (totalPage % maxDisplayPage > 0) ? totalPageSet + 1 : totalPageSet;
//        console.info('totalPageSet=' + totalPageSet);
//
//        currentPageSet = parseInt((pageSize * currentPage) / (maxDisplayPage * pageSize )) + 1;
//        console.info('currentPageSet=' + currentPageSet);
//
//        endPageNo = currentPageSet * maxDisplayPage;
//        console.info('endPageNo=' + endPageNo);
//
//        startPageNo = endPageNo - maxDisplayPage + 1;
//        console.info('startPageNo=' + startPageNo);

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
