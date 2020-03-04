package com.pensil.lab.productinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@ControllerAdvice
public class AppGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFound(ProductNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        //ProductNotFoundException notFoundException = (ProductNotFoundException) ex;
        body.put("timestamp", ISO_DATE_TIME.format(LocalDateTime.now(ZoneId.of("UTC"))));
        StringBuilder sb = new StringBuilder();
        ex.getProductIdList().forEach(productId -> sb.append(productId).append(","));
        body.put("product-id", sb.toString());
        body.put("message", "not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}