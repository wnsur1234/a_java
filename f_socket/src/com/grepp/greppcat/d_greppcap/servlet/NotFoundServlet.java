package com.grepp.greppcat.d_greppcap.servlet;

import com.grepp.greppcat.d_greppcap.http.HttpHeader;
import com.grepp.greppcat.d_greppcap.http.request.HttpRequest;
import com.grepp.greppcat.d_greppcap.http.response.HttpResponse;
import com.grepp.greppcat.d_greppcap.http.response.ResponseBody;
import com.grepp.greppcat.d_greppcap.http.response.ResponseStartLine;

public class NotFoundServlet implements Servlet {
    
    public HttpResponse doGet(HttpRequest request) {
        return new HttpResponse(
            ResponseStartLine.NOT_FOUND,
            new HttpHeader(),
            new ResponseBody()
        );
    }
    
    public HttpResponse doPost(HttpRequest request) {
        return new HttpResponse(
            ResponseStartLine.NOT_FOUND,
            new HttpHeader(),
            new ResponseBody()
        );
    }
}
