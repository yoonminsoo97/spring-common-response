package com.example.response.member.exception;

import com.example.response.global.error.exception.BaseException;
import com.example.response.global.error.exception.ErrorType;

public class DuplicateNicknameException extends BaseException {

    public DuplicateNicknameException() {
        super(ErrorType.DUPLICATE_NICKNAME);
    }

}
