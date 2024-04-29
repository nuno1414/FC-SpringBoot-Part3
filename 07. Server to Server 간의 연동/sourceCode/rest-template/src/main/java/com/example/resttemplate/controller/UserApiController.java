package com.example.resttemplate.controller;

import com.example.resttemplate.dto.User;
import com.example.resttemplate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @GetMapping("")
    public void get(){
        userService.naver();
    }

    @GetMapping("/hello")
    public ResponseEntity<User> hello(){

        ResponseEntity<User> response = userService.getForEntity();
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
        return response;
    }

}
