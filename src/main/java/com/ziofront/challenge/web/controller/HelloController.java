package com.ziofront.challenge.web.controller;

import com.ziofront.challenge.web.model.response.Place;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(Model model) {

        model.addAttribute("testData", Place.builder().id("1").name("어느장소").x("1234567890").y("0987654321").url("http://hello.com").build());

        return "hello";
    }
}
