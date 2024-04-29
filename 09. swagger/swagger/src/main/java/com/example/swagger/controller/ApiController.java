package com.example.swagger.controller;

import com.example.swagger.dto.UserRequest;
import com.example.swagger.dto.UserResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"REST API CONTROLLER - API 정보를 제공하는 Controller"}) // class를 swagger의 리소스로 표시
@RestController
@RequestMapping("/api")
public class ApiController {

    @ApiOperation(value = "hello method", notes = "기본적인 인사 GET API") // 특정 경로의 오퍼레이션 HTTP 메소드 설명
    /* @ApiImplicitParams({ // @ApiImplicitParams, @ApiImplicitParam - 메소드 단위의 오퍼레이션 파라미터 설
            @ApiImplicitParam(name = "name", value = "사용자 이름", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "age", value = "사용자 나이", required = true, dataType = "int", paramType = "query")
    })*/
    @GetMapping("/hello/{name}")
    public String hello(
            @ApiParam(value = "사용자 이름") // 오퍼레이션 파라미터에 메타 데이터 설명
            @PathVariable String name,

            @ApiParam(value = "사용자 나이") // 오퍼레이션 파라미터에 메타 데이터 설명
            @RequestParam int age){
        return "hello";
    }

    @ApiOperation(value = "hello method", notes = "기본적인 인사 GET API") // 특정 경로의 오퍼레이션 HTTP 메소드 설명
    @ApiImplicitParams({ // @ApiImplicitParams, @ApiImplicitParam - 메소드 단위의 오퍼레이션 파라미터 설
            @ApiImplicitParam(name = "name", value = "사용자 이름", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "age", value = "사용자 나이", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/hi/{name}")
    public String hi(
            @PathVariable String name,
            @RequestParam int age){
        return "hello";
    }

    @ApiOperation(value="사용자의 이름과 나이를 리턴하는 메소드")
    @ApiResponse(code = 404, message = "not found") // 오퍼레이션의 응답 지정
    @GetMapping("/user")
    public UserResponse user(UserRequest userRequest){
        return new UserResponse(userRequest.getName(), userRequest.getAge());
    }

    @PostMapping("/user")
    @ApiResponse(code = 404, message = "not found") // 오퍼레이션의 응답 지정
    public UserResponse post(@RequestBody UserRequest userRequest){
        return new UserResponse(userRequest.getName(), userRequest.getAge());
    }
}
