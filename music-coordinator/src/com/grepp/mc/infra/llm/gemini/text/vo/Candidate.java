package com.grepp.mc.infra.llm.gemini.text.vo;

import java.util.List;

public record Candidate(
    List<Content> content,
    String finishReason,
    Double avgLogprobs
    
) {

}
