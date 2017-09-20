package com.woowahan.blog.service.impl;

import com.woowahan.blog.dto.MemberEditRequest;
import com.woowahan.blog.dto.MemberRegisterRequest;
import com.woowahan.blog.dto.MemberResponse;
import com.woowahan.blog.entity.Member;
import com.woowahan.blog.ex.ResourceNotFoundException;
import com.woowahan.blog.repository.MemberRepository;
import com.woowahan.blog.service.MemberService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Inject
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberResponse register(MemberRegisterRequest request) {
        return MemberResponse.of(memberRepository.save(new Member(request.getUserId(), request.getPassword(), request.getName(), request.getNickname())));
    }

    @Override
    public MemberResponse edit(Long id, MemberEditRequest request) {
        Member savedMember = findValidMember(id);
        return MemberResponse.of(savedMember.amend(request.getName(), request.getNickname()));
    }

    private Member findValidMember(Long id) {
        return Optional.ofNullable(memberRepository.findOne(id))
                .orElseThrow(() -> new ResourceNotFoundException("id[%d]는 존재하지 않는 사용자 입니다"));
    }

}
