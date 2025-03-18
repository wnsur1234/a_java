package com.grepp.mc;

import com.grepp.mc.infra.llm.gemini.text.vo.RequestDocument;

public class Run {
    public static void main(String[] args) {
        RequestDocument doc = new RequestDocument("오늘 저녁메뉴 추천해줘");
    }
}
