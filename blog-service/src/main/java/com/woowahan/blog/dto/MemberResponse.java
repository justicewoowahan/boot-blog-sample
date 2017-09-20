package com.woowahan.blog.dto;

import com.woowahan.blog.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter @Setter
public class MemberResponse {
    private Long id;
    private String userId;
    private String name;
    private String nickname;
    private Date createdDate;
    private Date lastModifiedDate;


    public static MemberResponse of(Member member) {
        MemberResponse response = new MemberResponse();
        response.id = member.getId();
        response.userId = member.getUserId();
        response.name = member.getName();
        response.nickname = member.getNickname();
        response.createdDate = member.getCreatedDate();
        return response;
    }
}
