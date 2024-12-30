package com.bookrecommend.demo.exception;

import com.bookrecommend.demo.response.ApiResponseCode;

public class MemberNotFoundException extends BusinessException {

    public MemberNotFoundException() {
        super(ApiResponseCode.Member_NOT_FOUND);
    }
}
