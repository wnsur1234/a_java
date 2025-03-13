package com.grepp.core.servlet;

import com.grepp.core.http.request.HttpRequest;

public interface HandlerMapper {
     Servlet getHandler(String url);
}
