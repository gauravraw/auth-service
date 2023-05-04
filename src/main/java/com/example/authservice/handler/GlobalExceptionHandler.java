package com.example.authservice.handler;

import com.example.authservice.exception.GlobalException;
import com.example.authservice.exception.error.ApiError;
import com.example.authservice.nonEntity.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<BaseResponse<ApiError>> handleGlobalException(GlobalException exception) {
        return ResponseEntity
                .ok(BaseResponse.<ApiError> builder().data(exception.getApiError()).success(false).build());
    }
}
