package com.grepp.greppcat.a_tcp.domain;

import com.grepp.greppcat.a_tcp.http.request.HttpRequest;
import com.grepp.greppcat.a_tcp.util.QrCodeUtil;
import java.io.FileOutputStream;
import java.io.IOException;

public class QrCode {
    
    public void doGet(HttpRequest request) {
        
        String filename = request.param().get("name").getFirst();
        String content = request.param().get("content").getFirst();
        
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            QrCodeUtil.createQrCode("png", content, fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
