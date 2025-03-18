package com.grepp.mc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grepp.mc.infra.llm.GeminiChatModel;
import com.grepp.mc.infra.llm.gemini.text.vo.RequestDocument;

public class Run {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        RequestDocument<BookFormat> doc
            = new RequestDocument<>("신나는 노래 추천해줘, 제목과 이유를 알려줘", new BookFormat());
        System.out.println(gson.toJson(doc));
        GeminiChatModel.invoke(doc);
    }
}
