package com.woowahan.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberEditRequest {

    private String name;
    private String nickname;

    public MemberEditRequest(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

}
