package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "get hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "get hi";
    }

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    // 01. 파라미터가 어떤 것이 들어올지 모를때 사용하는 방법 : Map
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();
        // HashMap의 EntrySet은 Entry의 집합(Set)입니다.
        // Entry는 HashMap 요소 key와 value를 쌍으로 갖고 있습니다.
        // 즉, Entry 1개는 요소 1개를 의미합니다.
        // EntrySet.forEach()를 이용하여 모든 요소를 순회할 수 있습니다.
        // 람다식을 보면 Entry를 인자로 전달하며, Entry를 통해 key와 value에 접근합니다.
        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + "=" + entry.getValue()+"\n");
        });

        return sb.toString();
    }

    // 02. 파라미터가 몇개 안돼는 경우에 간단히 사용
    @GetMapping(path = "/query-param02")
    public String queryParam02(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam int age) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    // 03. 가장 일반적으로 사용하는 방식 : dto 객체 생성하여 사용
    @GetMapping(path = "/query-param03")
    public String queryParam03(UserRequest userRequest) { //@RequestParam 없음

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
