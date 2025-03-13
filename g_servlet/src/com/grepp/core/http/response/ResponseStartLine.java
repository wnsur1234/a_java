package com.grepp.core.http.response;

public record ResponseStartLine(
    String protocol,
    String statusCode,
    String statusMsg
) {

    @Override
    public String toString(){
        return protocol + " " + statusCode + " " + statusMsg + "\n";
    }
}
