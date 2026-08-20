package io.github.cupokki.chatkiosk26.common.error;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage()); // 부모 예외 클래스에 메시지 전달
        this.errorCode = errorCode;
    }
}