package com.example.response.member.dto;

import com.example.response.member.entity.Member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberProfileResponse {

    private String nickname;
    private String username;

    public MemberProfileResponse(Member member) {
        this.nickname = member.getNickname();
        this.username = member.getUsername();
    }

}
