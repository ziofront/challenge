package com.ziofront.challenge.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(HttpServletRequest request) {
        String referer = request.getHeader("Referer");

        request.getSession().setAttribute("prevPage", referer);

        return "login";
    }

}
