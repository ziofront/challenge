package com.ziofront.challenge.web.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiho
 */
@Controller
@RequestMapping(value = "/view/place")
public class PlaceFindController {

    @RequestMapping(value = "/find")
    public String find() {
        return "place/find";
    }

    @RequestMapping(value = "/top10")
    public String top10() {
        return "place/top10";
    }

}
