package com.woowahan.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;
    private String title;
    private String content;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();


    public Post(Blog blog, String title, String content) {
        this.blog = blog;
        this.title = title;
        this.content = content;
    }

}

