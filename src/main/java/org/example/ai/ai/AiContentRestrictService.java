package org.example.ai.ai;

import dev.langchain4j.service.SystemMessage;

/**
 * 内容限制
 */
public interface AiContentRestrictService {
    /**
     * 根据用户描述进行精简后得到应用名
     * @param userPrompt 用户输入的需求描述
     * @return 精简后的应用名称（12字以内）
     */
    @SystemMessage(fromResource = "prompt/content-restrict-prompt.txt")
    String generateAppName(String userPrompt);
}
