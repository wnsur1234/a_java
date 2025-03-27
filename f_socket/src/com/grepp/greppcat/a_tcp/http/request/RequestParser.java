package com.grepp.greppcat.a_tcp.http.request;

import com.grepp.greppcat.a_tcp.http.HttpMethod;
import java.io.BufferedReader;

public class RequestParser {

    public HttpRequest parse(String line, BufferedReader reader) {
        RequestStartLine startLine = parseStartLine(line);
        RequestParameter param = new RequestParameter();
        
        if(startLine.method().equals(HttpMethod.GET)){
            param = parseQueryString(startLine.queryString());
        }
        
        return new HttpRequest(startLine, null, param);
    }
    
    private RequestParameter parseQueryString(String queryString) {
        
        RequestParameter param = new RequestParameter();
        if(queryString.isEmpty()) return param;
        
        String[] paramTokens = queryString.split("&");
        for(String paramToken : paramTokens){
            param.add(paramToken);
        }
        
        return param;
    }
    
    private RequestStartLine parseStartLine(String line) {
        
        String[] tokens = line.split(" ");
        String method = tokens[0];
        String url = tokens[1];
        String version = tokens[2];
        String queryString = "";
        
        int queryIndex = url.indexOf("?");
        
        if(queryIndex == -1) return new RequestStartLine(
            HttpMethod.valueOf(method),
            url,
            queryString,
            version
        );
        
        url = tokens[1].substring(0, queryIndex);
        queryString = tokens[1].substring(queryIndex+1);


        return new RequestStartLine(
            HttpMethod.valueOf(method),
            url,
            queryString,
            version
        );
    }
}
