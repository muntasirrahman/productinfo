package com.pensil.lab.productinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    private LocalDateTime timestamp = LocalDateTime.now();
    private List<Long> productIdList;

    public ProductNotFoundException(List<Long> productIdList) {
        super("requested products are not found");
        this.timestamp = timestamp;
        this.productIdList = productIdList;
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<Long> getProductIdList() {
        return productIdList;
    }
}
