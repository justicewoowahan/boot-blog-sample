package com.woowahan.blog.repository;

import com.woowahan.blog.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
}
