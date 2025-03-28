package com.grepp.greppcat.d_greppcap.servlet;

import com.grepp.greppcat.d_greppcap.http.request.HttpRequest;

public class HandlerMapping {

    public Servlet getHandler(HttpRequest request){
        ServletStorage storage = ServletStorage.getInstance();
        
        Servlet servlet = storage.getServlet(
            request.startLine().url().replaceFirst("/", ""));
        
        if(servlet == null) return new NotFoundServlet();
        return servlet;
    }
}
