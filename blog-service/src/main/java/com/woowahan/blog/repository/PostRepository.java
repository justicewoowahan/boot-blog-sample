package com.woowahan.blog.repository;

import com.woowahan.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long>{
}
