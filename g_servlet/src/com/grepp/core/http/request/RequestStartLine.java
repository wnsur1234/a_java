package com.grepp.core.http.request;

public record RequestStartLine(
    String method,
    String url,
    String queryString,
    String protocol
) {

}
