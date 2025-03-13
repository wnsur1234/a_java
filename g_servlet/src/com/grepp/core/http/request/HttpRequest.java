package com.grepp.core.http.request;


import com.grepp.core.http.HttpHeader;

public record HttpRequest(
    RequestStartLine startLine,
    HttpHeader header,
    RequestParameter param
) {

}
