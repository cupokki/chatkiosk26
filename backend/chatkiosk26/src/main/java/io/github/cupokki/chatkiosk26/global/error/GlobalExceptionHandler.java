package io.github.cupokki.chatkiosk26.global.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e) {
        ErrorCode errorCode = e.getErrorCode();

        log.warn("비즈니스 로직 에러 발생: {} - {}", errorCode.name(), errorCode.getMessage());

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(errorCode.getMessage());
    }

    /**
     * 인터널 에러
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleInternalServerError(Exception e) {
        log.error("서버 내부 시스템 에러 발생: ", e);

        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(errorCode.getMessage());
    }
}
