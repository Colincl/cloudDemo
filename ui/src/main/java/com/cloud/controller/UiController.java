package com.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/27.
 */
@Controller
public class UiController {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}
