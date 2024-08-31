package com.example.response.member.controller;

import com.example.response.global.common.dto.ApiResponse;
import com.example.response.member.dto.MemberProfileResponse;
import com.example.response.member.dto.MemberSignupRequest;
import com.example.response.member.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<ApiResponse<Void>> memberNicknameExists(@PathVariable("nickname") String nickname) {
        memberService.memberNicknameExists(nickname);
        return ResponseEntity.ok().body(ApiResponse.success());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<ApiResponse<Void>> memberUsernameExists(@PathVariable("username") String username) {
        memberService.memberUsernameExists(username);
        return ResponseEntity.ok().body(ApiResponse.success());
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Void>> memberSignup(@Valid @RequestBody MemberSignupRequest memberSignupRequest) {
        memberService.memberSignup(memberSignupRequest);
        return ResponseEntity.ok().body(ApiResponse.success());
    }

    @GetMapping("/me/{username}")
    public ResponseEntity<ApiResponse<MemberProfileResponse>> memberProfile(@PathVariable("username") String username) {
        MemberProfileResponse memberProfileResponse = memberService.memberProfile(username);
        return ResponseEntity.ok().body(ApiResponse.success(memberProfileResponse));
    }

}
