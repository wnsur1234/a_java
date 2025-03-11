package com.grepp.exception.custom;

import java.util.Random;

// UnChecked Exception : RuntimeException 상속
public class NotValidException extends RuntimeException {
    public NotValidException(String message) {
        super(message);
    }
}
