package com.semina.springDataJpa.dto;

import com.querydsl.core.types.Projections;
import lombok.Data;

@Data
public class UserDto {

    private String name;
    private int age;

    public UserDto() {
    }

    public UserDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
