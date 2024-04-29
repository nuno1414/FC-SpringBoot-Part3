package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {

        return "main.html";
    }

    // ResponseEntity

    // ResponseBody
    @GetMapping("/user")
    @ResponseBody // @Controller에서 html 등의 페이지가 아닌, ResponseBody(json)를 만들어서 내리겠다는 어노테이션
    public User user() {
        User user = new User();
        user.setName("steve");
        user.setAddress("Korea Seoul");

        return user;
    }
}
