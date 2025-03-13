package com.grepp.core.http.response;


import com.grepp.core.http.HttpHeader;

public record HttpResponse(
    ResponseStartLine startLine,
    HttpHeader header,
    ResponseBody body
) {

}
