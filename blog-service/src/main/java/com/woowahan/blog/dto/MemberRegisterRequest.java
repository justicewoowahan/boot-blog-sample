package com.woowahan.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class MemberRegisterRequest {
    private String userId;
    private String password;
    private String name;
    private String nickname;

    public MemberRegisterRequest(String userId, String password, String name, String nickname) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

}
