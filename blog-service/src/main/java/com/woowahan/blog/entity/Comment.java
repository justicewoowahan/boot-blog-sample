package com.woowahan.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
    private String content;

    public Comment(Post post, String content) {
        this.post = post;
        this.content = content;
    }

    public Comment amend(String content) {
        this.content = content;
        return this;
    }

}
