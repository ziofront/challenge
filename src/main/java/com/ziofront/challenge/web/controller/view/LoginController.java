package com.ziofront.challenge.web.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(HttpServletRequest request) {

        request.getSession().setAttribute("prevPage", request.getHeader("Referer"));

        return "login";
    }

}
