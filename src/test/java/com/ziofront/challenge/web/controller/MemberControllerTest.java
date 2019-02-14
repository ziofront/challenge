package com.ziofront.challenge.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ziofront.challenge.security.AuthenticationRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MemberControllerTest {

    private static Logger LOG = LoggerFactory.getLogger(MemberControllerTest.class);

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    public void loginTest() throws Exception {
        AuthenticationRequest request = new AuthenticationRequest();
        request.setUsername("test1");
        request.setPassword("1024");

        ObjectMapper om = new ObjectMapper();

        ResultActions result = mvc.perform(post("/api/v1/member/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(om.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.username", is(request.getUsername())))
                .andExpect(jsonPath("$.authorities[*].roleName", hasItem("BASIC")))
        ;

        LOG.info(">>>>>{}", jsonPath("$.username", is(request.getUsername())));
        LOG.info("result={}", result.andReturn().getResponse().getContentAsString());


    }
}
