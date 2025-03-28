package com.grepp.greppcat.d_greppcap.servlet;

import com.grepp.greppcat.d_greppcap.http.HttpMethod;
import com.grepp.greppcat.d_greppcap.http.request.HttpRequest;
import com.grepp.greppcat.d_greppcap.http.response.HttpResponse;

public class HandlerAdapter {

    public HttpResponse handle(HttpRequest request, Servlet servlet){
        HttpMethod method = request.startLine().method();
        
        if(method.equals(HttpMethod.GET)){
            return servlet.doGet(request);
        }
        
        return servlet.doPost(request);
    }
}
