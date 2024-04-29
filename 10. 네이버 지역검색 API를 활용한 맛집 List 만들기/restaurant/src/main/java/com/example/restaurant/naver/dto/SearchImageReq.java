package com.example.restaurant.naver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchImageReq {

    @ApiModelProperty(value = "검색어", example = "갈비집")
    private String query = "";

    @ApiModelProperty(value = "display", example = "1")
    private int display = 1;

    @ApiModelProperty(value = "start", example = "1")
    private int start = 1;

    @ApiModelProperty(value = "sort", example = "sim")
    private String sort = "sim";

    @ApiModelProperty(value = "filter", example = "all")
    private String filter = "all";


    public MultiValueMap<String, String> toMultiValueMap() {

        var map = new LinkedMultiValueMap<String, String>();
        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);
        map.add("filter", filter);

        return map;
    }
}
