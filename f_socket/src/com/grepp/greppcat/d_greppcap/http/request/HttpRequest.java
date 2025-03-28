package com.grepp.greppcat.d_greppcap.http.request;

import com.grepp.greppcat.d_greppcap.http.HttpHeader;

public record HttpRequest(
    RequestStartLine startLine,
    HttpHeader header,
    RequestParameter param
) {

}
