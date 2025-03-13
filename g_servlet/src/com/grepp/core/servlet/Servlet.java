package com.grepp.core.servlet;

import com.grepp.core.http.request.HttpRequest;
import com.grepp.core.http.response.HttpResponse;

public interface Servlet {
    HttpResponse doGet(HttpRequest request);
    HttpResponse doPost(HttpRequest request);
}
