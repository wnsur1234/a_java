package com.grepp.mc.infra.llm.gemini.text.vo.generation;

public record Item<T>(
    String type,
    T properties
) {
    
    public Item(T properties) {
        this("OBJECT", properties);
    }
}
