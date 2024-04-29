package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * JSON
 * { "key" : "value" }
 * string  : value
 * number  : value
 * boolean : value
 * object  : value {}
 * array   : value []
 * {
 *     "phone_number" : "010-1111-2222",
 *     "age" : 10,
 *     "isAgree" : true,
 *     "account" : {
 *         "email" : "steve@gmail.com",
 *         "password" : "1234"
 *     },
 *     "user_list" : [
 *         {
 *             "account" : "aaaa",
 *             "password" : "1111"
 *         },
 *         {
 *             "account" : "bbbb",
 *             "password" : "2222"
 *        },
 *        {
 *            "account" : "cccc",
 *            "password" : "3333"
 *        },
 *     ]
 * }
 *
 * 예시 - 사용자 계정
 * {
 *     "account" : "",
 *     "email" : "",
 *     "password" : "",
 *     "address" : ""
 * }
 */
@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String ,Object> requestData) {

//        requestData.entrySet().forEach( entry -> {
//            System.out.println("key : " + entry.getKey());
//            System.out.println("value : " + entry.getValue());
//        });
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });

    }

    @PostMapping("/post02")
    public void post02(@RequestBody PostRequestDto requestData) {

        System.out.println(requestData.toString());
    }
}
