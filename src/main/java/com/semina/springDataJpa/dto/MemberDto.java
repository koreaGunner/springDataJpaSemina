package com.semina.springDataJpa.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MemberDto {
    private String username;
    private int age;

    public MemberDto() {
    }

    @QueryProjection //Dto도 Q파일로 생성됨
    public MemberDto(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
