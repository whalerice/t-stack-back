package com.example.t_stack_back.service;

import com.example.t_stack_back.domain.Member;
import com.example.t_stack_back.dto.MemberResponse;
import com.example.t_stack_back.dto.MemberSignupRequest;
import com.example.t_stack_back.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponse signup(MemberSignupRequest request) {
        // Validate duplicate loginId
        memberRepository.findByLoginId(request.getLoginId())
                .ifPresent(m -> {
                    throw new IllegalArgumentException("Login ID already exists: " + request.getLoginId());
                });

        // Create Member entity
        Member member = new Member(request.getLoginId(), request.getPassword(), request.getName());
        
        // Save to DB
        Member savedMember = memberRepository.save(member);

        // Return representation
        return new MemberResponse(
                savedMember.getId(),
                savedMember.getLoginId(),
                savedMember.getName(),
                savedMember.getCreatedAt()
        );
    }
}
