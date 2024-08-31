package com.example.response.member.exception;

import com.example.response.global.error.exception.BaseException;
import com.example.response.global.error.exception.ErrorType;

public class DuplicateUsernameException extends BaseException {

    public DuplicateUsernameException() {
        super(ErrorType.DUPLICATE_USERNAME);
    }

}
