package com.woowahan.blog.repository;

import com.woowahan.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long>{
}
