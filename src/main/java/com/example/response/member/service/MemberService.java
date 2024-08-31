package com.example.response.member.service;

import com.example.response.member.dto.MemberProfileResponse;
import com.example.response.member.dto.MemberSignupRequest;
import com.example.response.member.entity.Member;
import com.example.response.member.exception.DuplicateNicknameException;
import com.example.response.member.exception.DuplicateUsernameException;
import com.example.response.member.exception.NotFountMemberException;
import com.example.response.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public void memberNicknameExists(String nickname) {
        if (memberRepository.existsByNickname(nickname)) {
            throw new DuplicateNicknameException();
        }
    }

    @Transactional(readOnly = true)
    public void memberUsernameExists(String username) {
        if (memberRepository.existsByUsername(username)) {
            throw new DuplicateUsernameException();
        }
    }

    @Transactional
    public void memberSignup(MemberSignupRequest memberSignupRequest) {
        memberNicknameExists(memberSignupRequest.getNickname());
        memberUsernameExists(memberSignupRequest.getUsername());
        Member member = Member.builder()
                .nickname(memberSignupRequest.getNickname())
                .username(memberSignupRequest.getUsername())
                .password(memberSignupRequest.getPassword())
                .build();
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public MemberProfileResponse memberProfile(String username) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(NotFountMemberException::new);
        return new MemberProfileResponse(member);
    }

}
