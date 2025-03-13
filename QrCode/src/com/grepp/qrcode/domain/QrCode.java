package com.grepp.qrcode.domain;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.grepp.core.http.HttpHeader;
import com.grepp.core.http.error.ServletException;
import com.grepp.core.http.request.HttpRequest;
import com.grepp.core.http.response.HttpResponse;
import com.grepp.core.http.response.ResponseBody;
import com.grepp.core.http.response.ResponseStartLine;
import com.grepp.core.servlet.Servlet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class QrCode implements Servlet {

    private static QrCode instance;

    public static QrCode getInstance(){
        if(instance == null){
            instance = new QrCode();
        }

        return instance;
    };

    private QrCode(){}

    @Override
    public HttpResponse doGet(HttpRequest request) {
        String content = request
            .param()
            .getParameter("url")
            .orElseGet(() -> List.of("Grepp QR Code"))
            .getFirst();

        byte[] bytes = createQR(content);

        return new HttpResponse(
            new ResponseStartLine("http/1.1", "200", "OK"),
            new HttpHeader()
                .add("Content-Type", "text/html; Charset=utf-8")
                .add("Content-Disposition", "attachment; filename=test.jpg"),
            new ResponseBody().addBody(bytes)
        );
    }

    @Override
    public HttpResponse doPost(HttpRequest request) {
        return null;
    }

    private byte[] createQR(String contents) {
        try(ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            QRCodeWriter qrMaker = new QRCodeWriter();
            BitMatrix matrix = qrMaker.encode(contents, BarcodeFormat.QR_CODE, 500, 500);
            MatrixToImageWriter.writeToStream(matrix, "jpg", os);
            return os.toByteArray();
        } catch (IOException | WriterException e ) {
            throw new ServletException("qrcode 생성 중 에러가 발생하였습니다.");
        }
    }
}
