package com.grepp.core.servlet;

import com.grepp.core.http.request.HttpRequest;
import com.grepp.core.http.response.HttpResponse;

public class HandlerAdapter {

    public HttpResponse handle(Servlet servlet, HttpRequest request){
        String httpMethod = request.startLine().method();

        if(httpMethod.equalsIgnoreCase("get")){
            return servlet.doGet(request);
        }else if(httpMethod.equalsIgnoreCase("post")){
            return servlet.doPost(request);
        }

        return null;
    }


}
