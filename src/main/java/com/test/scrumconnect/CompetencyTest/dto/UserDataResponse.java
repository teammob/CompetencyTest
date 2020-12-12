package com.test.scrumconnect.CompetencyTest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDataResponse {

    @ApiModelProperty
    private String name;

}