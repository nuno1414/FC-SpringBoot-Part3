package com.example.hello.controller;

import com.example.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;


/**
 * {
 *     "name" : "steve",
 *     "age": 20,
 *     "car_list" : [
 *      {
 *          "name" : "BMW",
 *          "car_number" : "1111"
 *      },
 *      {
 *          "name" : "A4",
 *          "car_number" : "2222"
 *       }
 *     ]
 * }
 */
@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto putRequestDto,
                             @PathVariable(name = "userId") Long userId) {

        System.out.println(putRequestDto);
        System.out.println(userId);
        // SpringBoot의 경우 dto를 response하면 json형태로 response 함
        // (Naming에 대한 부분은 dto에서 지정한 대로 전달됨)
        return putRequestDto;
    }
}
