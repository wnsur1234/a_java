package com.grepp.mc.infra.llm.gemini.text.vo;

import java.util.List;

public record Content (List<Part> parts){
    
    public Content(String text) {
        this(List.of(new Part(text)));
    }
}
