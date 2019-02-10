package com.ziofront.challenge.service;

import com.google.gson.GsonBuilder;
import com.ziofront.challenge.vo.Place;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPlaceSearchService {


    private static Logger LOG = LoggerFactory.getLogger(TestPlaceSearchService.class);

    @Autowired
    PlaceFindService placeSearchService;

    @Test
    public void test1FindByKeyword() throws Exception {

        Pageable p = Pageable.unpaged();

        Place place = placeSearchService.findByKeyword("하나은행", p);

        LOG.debug("place={}", new GsonBuilder().setPrettyPrinting().create().toJson(place));

        assertTrue(place.getPlaceList() != null);

    }


}
