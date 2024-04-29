package com.example.restaurant.naver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchImageRes {

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

        @ApiModelProperty(value = "thumbnail", example = "http://~~~~~")
        private String thumbnail;

        @ApiModelProperty(value = "sizeheight", example = "100")
        private String sizeheight;

        @ApiModelProperty(value = "sizewidth", example = "100")
        private String sizewidth;

    }
}
