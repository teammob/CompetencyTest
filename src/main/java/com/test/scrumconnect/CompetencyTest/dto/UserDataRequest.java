package com.test.scrumconnect.CompetencyTest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDataRequest {

    @ApiModelProperty(position = 0)
    @NotNull(message = "Please provide name")
    private String name;

    @ApiModelProperty(position = 1)
    @NotNull(message = "Please provide sex")
    private String sex;

    @ApiModelProperty(position = 2)
    @Min(value = 1, message = "Please provide age")
    private int age;

    @ApiModelProperty(position = 3)
    @NotNull(message = "Please provide country")
    private String country;

    public UserDataRequest(@NotNull(message = "Please provide name") String name, @NotNull(message = "Please provide sex") String sex, @Min(value = 1, message = "Please provide age") int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.country = country;
    }
}
