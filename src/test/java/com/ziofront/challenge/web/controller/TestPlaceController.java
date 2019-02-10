package com.ziofront.challenge.web.controller;

import com.google.gson.GsonBuilder;
import com.ziofront.challenge.vo.Place;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPlaceController extends AbstractTestController {

    private static Logger LOG = LoggerFactory.getLogger(TestPlaceController.class);


    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void test1_FindByKeyword() throws Exception {

        String uri = "/api/place/find?keyword=하나은행&page=3&size=10";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        Place place = super.mapFromJson(content, Place.class);

        LOG.debug("place={}", new GsonBuilder().setPrettyPrinting().create().toJson(place));

        assertTrue(place != null);
        assertTrue(place.getPlaceList() != null && place.getPlaceList().size() > 0);
    }


}