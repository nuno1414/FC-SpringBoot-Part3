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
public class SearchLocalReq {

    @ApiModelProperty(value = "title", example = "고향마을숯불돼지갈비")
    private String query = "";

    @ApiModelProperty(value = "display", example = "1")
    private int display = 1;

    @ApiModelProperty(value = "start", example = "1")
    private int start = 1;

    @ApiModelProperty(value = "sort", example = "random")
    private String sort = "random";

    public MultiValueMap<String, String> toMultiValueMap() {
        var map = new LinkedMultiValueMap<String, String>();

        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);

        return map;
    }
}
