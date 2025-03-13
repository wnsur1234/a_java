package com.grepp.qrcode;

import com.grepp.core.GreppCat;
import com.grepp.core.servlet.Servlet;
import com.grepp.qrcode.domain.QrCode;
import java.util.Map;

public class Run {
    public static void main(String[] args) {

        Map<String, Servlet> servlets = Map.of(
            "/qrcode", QrCode.getInstance()
        );

        GreppCat greppCat = new GreppCat(e -> {
            System.out.println(e);
            return servlets.get(e);
        });
        greppCat.start();
    }
}
