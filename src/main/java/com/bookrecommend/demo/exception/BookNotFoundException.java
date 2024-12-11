package com.bookrecommend.demo.exception;

import com.bookrecommend.demo.response.ApiResponseCode;

public class BookNotFoundException extends BusinessException {

    public BookNotFoundException() {
        super(ApiResponseCode.BOOK_NOT_FOUND);
    }
}
