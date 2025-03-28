package com.grepp.greppcat.d_greppcap.http.request;

import com.grepp.greppcat.d_greppcap.http.HttpMethod;

public record RequestStartLine(
    HttpMethod method,
    String url,
    String queryString,
    String version
) {

}
