package com.ziofront.challenge.web.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/view/place")
public class PlaceFindController {

    @RequestMapping(value = "/find")
    public String find() {
        return "place/find";
    }

}
