package com.ziofront.challenge.web.controller;

import com.ziofront.challenge.vo.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiho
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public String hello(Model model) {

        model.addAttribute("testData", Place.Item.builder().id("1").name("어느장소").x("1234567890").y("0987654321").url("http://hello.com").build());

        return "hello";
    }
}
