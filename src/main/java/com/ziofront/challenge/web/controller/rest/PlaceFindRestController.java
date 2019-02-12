package com.ziofront.challenge.web.controller.rest;

import com.ziofront.challenge.service.PlaceFindHIstoryService;
import com.ziofront.challenge.service.PlaceFindService;
import com.ziofront.challenge.vo.Place;
import com.ziofront.challenge.vo.Top10History;
import com.ziofront.challenge.web.utils.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/place")
public class PlaceFindRestController {

    private static Logger LOG = LoggerFactory.getLogger(PlaceFindRestController.class);

    @Value("${ziofront.pagination.default-pagination-size}")
    private int defaultPaginationSize;

    @Autowired
    private PlaceFindService placeService;

    @Autowired
    private PlaceFindHIstoryService placeFindHIstoryService;

    @GetMapping("/find")
    public ResponseEntity find(@RequestParam(value = "keyword", defaultValue = "None") String keyword
                               // 카카오맵 api에 버그인건지 page size를 15로 하지 않으면 특정 페이지 이후로 동일한 목록이 나온다.
            , @PageableDefault(page = 1, size = 15) Pageable pageable
            , Model model) throws Exception {

        LOG.debug("pageable={}", pageable);

        Place place = placeService.findByKeyword(keyword, pageable);

        Pagination pagination = Pagination.builder()
                .currentPage(pageable.getPageNumber())
                .totalCount(place.getTotalCount())
                .pageSize(pageable.getPageSize())
                .paginationSize(defaultPaginationSize).build();

        model.addAttribute("place", place);
        model.addAttribute("pagination", pagination);

        return ResponseEntity.ok(model);
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
