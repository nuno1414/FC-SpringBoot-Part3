package com.example.restaurant.controller;

import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.service.WishListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
@Api(tags = {"Naver 맛집 REST API CONTROLLER"})
public class ApiController {

    private final WishListService wishListService;

    @ApiOperation(value = "search method", notes = "Naver 맛집 검색 GET API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "검색어", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/search")
    public WishListDto search(@RequestParam String query) {

        return wishListService.search(query);

    }

    @ApiOperation(value = "add method", notes = "Naver 위시리스트 추가 POST API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "wishListDto", value = "wishListDto", required = true, dataType = "wishListDto", paramType = "query")
    })
    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto wishListDto) {
        log.info("{}", wishListDto);

        return wishListService.add(wishListDto);
    }

    @ApiOperation(value = "findAll method", notes = "Naver 맛집 전체 조회 GET API")
    @GetMapping("/all")
    public List<WishListDto> findAll() {

        return wishListService.findAll();
    }

    @ApiOperation(value = "findAll method", notes = "Naver 위시리스트 삭제 DELETE API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "index", value = "인덱스", required = true, dataType = "int", paramType = "path")
    })
    @DeleteMapping("/{index}")
    public void delete(@PathVariable(name = "index") int index) {

        wishListService.delete(index);
    }

    @ApiOperation(value = "findAll method", notes = "Naver 맛집 방문 추가 POST API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "index", value = "인덱스", required = true, dataType = "int", paramType = "path")
    })
    @PostMapping("/{index}")
    public void addVisit(@PathVariable(name = "index") int index) {

        wishListService.addVisit(index);
    }
}
