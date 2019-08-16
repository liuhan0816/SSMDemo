package com.arthur.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author liuhan
 * @Date 2019/7/25 11:26
 * @Version 1.0
**/

@Controller
@RequestMapping(value = "/demo")
public class DemoController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(Model model) {
        return "Hellow Spring Boot";
    }

    @RequestMapping("/test1")
    public ModelAndView test1() {
        ModelAndView model = new ModelAndView();

        model.addObject("name","liuhan");
        model.setViewName("member/index");
        return model;
    }

    @RequestMapping("/test2")
    public String test2(){
        return "member/index";
    }

    @RequestMapping("/test3")
    public String test3(){
        return "redirect:/index";
    }
}
