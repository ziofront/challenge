package com.ziofront.challenge.service;

import com.ziofront.challenge.web.model.response.Place;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPlaceService {

    @Autowired
    PlaceService placeService;

    @Test
    public void test1FindByKeyword() throws Exception {

        List<Place> list = placeService.findByKeyword("카카오오오");

        assertTrue(list != null);

    }


}
