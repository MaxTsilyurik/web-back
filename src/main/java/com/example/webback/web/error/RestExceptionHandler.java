package com.example.webback.web.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private RestExceptionHandler() {
        super();
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResult apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResult errorResult = new ErrorResult(NOT_FOUND);
        errorResult.setMessage(ex.getMessage());
        return buildResponseEntity(errorResult);
    }

    @ExceptionHandler(NotAccessException.class)
    protected ResponseEntity<Object> handleNotAccessException(NotAccessException ex) {
        ErrorResult errorResult = new ErrorResult(FORBIDDEN);
        errorResult.setMessage( ex.getMessage() );
        errorResult.setDebugMessage(ex.getMessage());
        return buildResponseEntity(errorResult);
    }

    @Data
    @AllArgsConstructor
    private static class ErrorResult {
        private int code;
        private HttpStatus status;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDateTime timestamp;
        private String message;
        private String debugMessage;

        private ErrorResult() {
            timestamp = LocalDateTime.now();
        }

        ErrorResult(HttpStatus status) {
            this();
            this.status = status;
            this.code = status.value();
        }

        ErrorResult(HttpStatus status, Throwable ex) {
            this();
            this.status = status;
            this.message = "Unexpected error";
            this.debugMessage = ex.getLocalizedMessage();
        }

        ErrorResult(HttpStatus status, String message, Throwable ex) {
            this();
            this.status = status;
            this.message = message;
            this.debugMessage = ex.getLocalizedMessage();
        }
    }
}
