package com.example.response.member.exception;

import com.example.response.global.error.exception.BaseException;
import com.example.response.global.error.exception.ErrorType;

public class NotFountMemberException extends BaseException {

    public NotFountMemberException() {
        super(ErrorType.NOT_FOUNT_MEMBER);
    }

}
