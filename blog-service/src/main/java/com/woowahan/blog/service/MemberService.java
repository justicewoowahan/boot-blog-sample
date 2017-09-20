package com.woowahan.blog.service;

import com.woowahan.blog.dto.MemberEditRequest;
import com.woowahan.blog.dto.MemberRegisterRequest;
import com.woowahan.blog.dto.MemberResponse;

public interface MemberService {
    MemberResponse register(MemberRegisterRequest request);

    MemberResponse edit(Long id, MemberEditRequest request);
}
