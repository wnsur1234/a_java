package com.grepp.greppcat.d_greppcap.http.response;

import com.grepp.greppcat.d_greppcap.http.HttpHeader;

public record HttpResponse(
    ResponseStartLine startLine,
    HttpHeader httpHeader,
    ResponseBody body
) {

}
