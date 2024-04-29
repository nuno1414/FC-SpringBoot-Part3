package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResponseApiController {

    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) {

        return account;
    }


    // JSON

    /**
     * {
     *     "name" : "steve",
     *     "age" : 10,
     *     "phoneNumber" : "010-1111-2222",
     *     "address" : "Korea Seoul"
     * }
     */
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {

        return user;
    }

    // ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user);
    }
}
