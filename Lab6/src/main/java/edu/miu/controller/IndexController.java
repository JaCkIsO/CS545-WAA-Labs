package edu.miu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/students")
    public String students(){
        return "students";
    }

    @GetMapping("/faculty")
    public String faculty(){
        return "faculty";
    }

    @GetMapping("/class")
    public String classes(){
        return "class";
    }
}
