package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchImageRes;
import com.example.restaurant.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    NaverClient naverClient;

    @Test
    public void searchLocalTest() {

        var serch = new SearchLocalReq();
        serch.setQuery("갈비집");

        var result = naverClient.searchLocal(serch);
        System.out.println(result);

    }

    @Test
    public void searchImageTest() {

        var serch = new SearchImageReq();
        serch.setQuery("갈비집");

        var result = naverClient.searchImage(serch);
        System.out.println(result);

    }
}
