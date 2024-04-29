package com.example.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

    @ApiModelProperty(value = "사용자 이름", example = "steve") // 모델의 속성 데이터를 설명
    private String name;


    @ApiModelProperty(value = "사용자 나이", example = "10") // 모델의 속성 데이터를 설명
    private int age;
}
