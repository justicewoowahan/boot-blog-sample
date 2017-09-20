package com.woowahan.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Blog extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String blogId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member owner;

    public Blog(Long id, String name, String blogId) {
        this.id = id;
        this.name = name;
        this.blogId = blogId;
    }
}
