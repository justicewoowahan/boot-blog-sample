package com.woowahan.blog.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/")
@Controller
public class HomeController {

    @GetMapping(value="/")
    public String home() {
        return "index";
    }
}
