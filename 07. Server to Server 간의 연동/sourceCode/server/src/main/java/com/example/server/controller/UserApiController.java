package com.example.server.controller;

import com.example.server.dto.Car;
import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Request;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping("")
    public User get(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        user.setCarList(Arrays.asList(
                new Car("K5","11가 1111"),
                new Car("A4","22나 2222"),
                new Car("BMW","33가 3333")
        ));

        return user;
    }

    @PostMapping("")
    public User post(@RequestBody User user,
                     @PathVariable int userId,
                     @PathVariable String userName){
        log.info("user : {}", user);
        log.info("userId: {}", userId);
        log.info("userName : {}", userName);
        return user;
    }

    @PostMapping("header")
    public User header(@RequestHeader(value = "x-authorization") String header, // @RequestHeader header 값 받기
                       @RequestBody User user){
        log.info("header : {}",header);
        log.info("body : {}", user);
        return user;
    }

    @PostMapping("generic-header")
    public Req<User> genericHeader(
                       HttpEntity<String> entity, // 디버그 시 사용 - 순수한 http entity가 들어옴
                       @RequestHeader(value = "x-authorization") String header, // @RequestHeader header 값 받기
                       @RequestBody Req<User> user){
        log.info("http entity : {}",entity.getBody());
        log.info("header : {}",header);
        log.info("body : {}", user);

        Req<User> response = new Req<User>();
        response.setHeader(new Req.Header());
        response.setResBody(user.getResBody());

        return response;
    }

    // https://openapi.naver.com/v1/search/local.json
    // ?query=%EC%A3%BC%EC%8B%9D
    // &display=10
    // &start=1
    // &sort=random
    @GetMapping("/naver")
    public String naver() {

        String query = "갈비집";

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/vi/search/local.json")
                .queryParam("query", query)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id","JsjGsOXou036Cf9as_Xt")
                .header("X-Naver-Client-Secret","dRn0ReF05X")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        //ResponseEntity<String> response = restTemplate.exchange(req, new ParameterizedTypeReference<>(){});

        return result.getBody();
    }
}
