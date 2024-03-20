package com.example.demo.infrastructure.controller.http.error;

import com.example.demo.domain.exceptions.InvalidParameterException;
import com.example.demo.infrastructure.controller.http.model.ErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Log4j2
@ControllerAdvice
public final class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static ResponseEntity<Object> badRequest(HttpHeaders headers,
                                                     List<String> errors) {
        return ResponseEntity.badRequest()
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponse()
                        .error(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(errors.toString()));
    }

    @ExceptionHandler({InvalidParameterException.class})
    private ResponseEntity<Object> handleBadRequest(Exception ex) {
        log.error("Exception while processing request", ex);
        return badRequest(new HttpHeaders(), List.of(ex.getMessage()));
    }

}
