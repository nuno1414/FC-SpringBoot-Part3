package com.example.restaurant.naver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocalRes {

    @ApiModelProperty(value = "lastBuildDate", example = "???")
    private String lastBuildDate;

    @ApiModelProperty(value = "total", example = "100")
    private int total;

    @ApiModelProperty(value = "start", example = "1")
    private int start;

    @ApiModelProperty(value = "display", example = "1")
    private int display;

    @ApiModelProperty(value = "items", example = "{???, ???, ???}")
    private List<SearchLocalItem> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchLocalItem {

        @ApiModelProperty(value = "title", example = "고향마을숯불돼지갈비")
        private String title;

        @ApiModelProperty(value = "link", example = "http://~~~~~")
        private String link;

        @ApiModelProperty(value = "category", example = "한식>돼지고기구이")
        private String category;

        @ApiModelProperty(value = "description", example = "~~~")
        private String description;

        @ApiModelProperty(value = "telephone", example = "02-000-1111")
        private String telephone;

        @ApiModelProperty(value = "address", example = "강원특별자치도 강릉시 ~~~")
        private String address;

        @ApiModelProperty(value = "roadAddress", example = "강원특별자치도 강릉시 ~~~")
        private String roadAddress;

        @ApiModelProperty(value = "mapx", example = "100")
        private int mapx;

        @ApiModelProperty(value = "mapy", example = "100")
        private int mapy;

    }
}
