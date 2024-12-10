package com.bookrecommend.demo.exception.handler;

import com.bookrecommend.demo.response.ApiResponseCode;
import com.bookrecommend.demo.response.CommonResponse;
import com.bookrecommend.demo.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.bookrecommend.demo")
public class BookExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CommonResponse<Void>> handleBusinessException(BusinessException ex) {
        ApiResponseCode code = ex.getCode();

        return ResponseEntity
                .status(code.getCode())
                .body(CommonResponse.error(code));
    }

    // 예상치 못한 예외를 작성했으나, BookExceptionHandler 에 있는 것은 아닌 것 같다. GlobalExceptionHandler 필요해보임.
    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse<Void>> handleException(Exception ex) {
        ApiResponseCode code = ApiResponseCode.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(code.getCode())
                .body(CommonResponse.error(code));
    }*/
}
