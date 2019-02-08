package com.ziofront.challenge.web.controller;

import com.ziofront.challenge.web.model.response.Place;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPlaceController extends AbstractTestController {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void test1FindByKeyword() throws Exception {
        String uri = "/api/place/find/helloworld";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        List<Place> list = super.mapFromJson(content, List.class);

        assertTrue(list != null);
        assertTrue(list.size() > 0);
    }

    @Test
    public void test2FindByKeyword() throws Exception {
        String uri = "/api/place/find2?keyword=카카오프렌즈";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        List<Place> list = super.mapFromJson(content, List.class);

        assertTrue(list != null);
        assertTrue(list.size() > 0);
    }


}