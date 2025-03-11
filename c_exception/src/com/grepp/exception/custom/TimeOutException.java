package com.grepp.exception.custom;

// NOTE B01 예외객체 만들기
// Checked Exception   : Exception 상속
public class TimeOutException extends Exception {
    public TimeOutException(String message) {
        super(message);
    }
}
