package com.bookrecommend.demo.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiResponseCode {

    // 성공
    SUCCESS(200, "Success"),

    // 예외(사용자)
    BOOK_NOT_FOUND(400, "도서 정보가 존재하지 않습니다."),

    // 예외(서버)
    INTERNAL_SERVER_ERROR(500, "서버에서 오류가 발생했습니다.");



    private final int code;
    private final String message;
}
