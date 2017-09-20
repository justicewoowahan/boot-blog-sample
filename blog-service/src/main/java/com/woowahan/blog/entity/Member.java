package com.woowahan.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String nickname;

    public Member(String userId, String password, String name, String nickname) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    public Member amend(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
        return this;
    }
}
