package com.example.resttemplate.service;

import com.example.resttemplate.dto.Req;
import com.example.resttemplate.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class UserService {

    public User getForObject(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api")
                .queryParam("name","steve")
                .queryParam("age",10)
                .encode()
                .build()
                .toUri();
        log.info("uri : {}",uri);

        RestTemplate restTemplate = new RestTemplate();
        // getForObject의 get은 http의 get임
        User user = restTemplate.getForObject(uri, User.class);
        log.info("user : {}", user);

        return user;
    }

    public ResponseEntity<User> getForEntity(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/{path}")
                .queryParam("name","steve")
                .queryParam("age",10)
                .encode()
                .build()
                .expand("user")
                .toUri();
        log.info("uri : {}", uri);

        RestTemplate restTemplate = new RestTemplate();
        // getForEntity의 get은 http의 get임
        ResponseEntity<User> response = restTemplate.getForEntity(uri, User.class);
        log.info("{}",response.getStatusCode());
        log.info("{}",response.getHeaders());
        log.info("{}",response.getBody());

        // return 형식이 User이면 return
        // return 형식이 User이면 return은 response.getBody()로 return;
        return response;
    }

    public User postForObject(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/{userId}/{userName}")
                .encode()
                .build()
                .expand("100", "steve") // pathvariable와 순서대로 매핑됨
                .toUri();
        log.info("uri : {}", uri);

        RestTemplate restTemplate = new RestTemplate();

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);
        User response = restTemplate.postForObject(uri, user, User.class);
        log.info("response : {}", response);

        return response;
    }

    public void postForEntity(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/{path}")
                .encode()
                .build()
                .expand("user")
                .toUri();
        log.info("uri : {}", uri);

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> response = restTemplate.postForEntity(uri, user, User.class);
        log.info("{}",response.getStatusCode());
        log.info("{}",response.getHeaders());
        log.info("{}",response.getBody());
    }

    public void exchange(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/{path}/header")
                .encode()
                .build()
                .expand("user")
                .toUri();
        log.info("uri : {}", uri);

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        // 보낼 때는 RequestEntity, 받을 때는 ResponseEntity
        RequestEntity<User> req = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","my-header")
                .body(user);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> response = restTemplate.exchange(req, new ParameterizedTypeReference<>(){});
        //ResponseEntity<User> response = restTemplate.exchange(req, User.class);
        log.info("{}",response.getStatusCode());
        log.info("{}",response.getHeaders());
        log.info("{}",response.getBody());
    }

    /**
     * {
     *     "header" : {
     *         "response_code" : "OK"
     *     },
     *     "body" : {
     *          유동적으로 변함
     *     }
     * }
     *
     */
    public User genericHeader(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/{path}/generic-header")
                .encode()
                .build()
                .expand("user")
                .toUri();
        log.info("uri : {}", uri);

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Req<User> req = new Req<User>();
        req.setHeader(new Req.Header());
        req.setResBody(user);

        // 보낼 때는 RequestEntity, 받을 때는 ResponseEntity
        RequestEntity<Req<User>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","my-header")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Req<User>> response = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Req<User>>(){});
        log.info("{}",response.getStatusCode());
        log.info("{}",response.getHeaders());
        log.info("{}",response.getBody());

        return response.getBody().getResBody();
    }



    public void naver(){
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query","갈비집") // %EC%A3%BC%EC%8B%9D
                .queryParam("display","10")
                .queryParam("start","1")
                .queryParam("sort","random")
                .encode()
                .build()
                .toUri();
        log.info("uri : {}", uri);

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id","Zi3o1uQftp59zuIqEAz4")
                .header("X-Naver-Client-Secret","iy6YKSWpLM")
                .build();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(req, new ParameterizedTypeReference<>(){});
        log.info("{}",response.getStatusCode());
        log.info("{}",response.getHeaders());
        log.info("{}",response.getBody());
    }
}
