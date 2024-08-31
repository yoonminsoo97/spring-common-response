package com.example.response.global.common.dto;

import com.example.response.global.error.dto.ErrorResponse;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private static final String SUCCESS_RESPONSE_PROPERTY = "data";
    private static final String FAIL_RESPONSE_PROPERTY = "error";

    private String status;
    private Map<String, T> data;

    private ApiResponse(String status) {
        this.status = status;
        this.data = Collections.emptyMap();
    }

    private ApiResponse(String status, String property, T data) {
        this.status = status;
        this.data = Collections.singletonMap(property, data);
    }

    public static ApiResponse<Void> success() {
        return new ApiResponse<>(SUCCESS);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(SUCCESS, SUCCESS_RESPONSE_PROPERTY, data);
    }

    public static ApiResponse<ErrorResponse> fail(ErrorResponse errorResponse) {
        return new ApiResponse<>(FAIL, FAIL_RESPONSE_PROPERTY, errorResponse);
    }

    @JsonAnyGetter
    public Map<String, T> getData() {
        return data;
    }

}
