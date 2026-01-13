package org.example.ai.ai;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class AiContentRestrictServiceFactory {
    @Resource
    private ChatModel chatModel;

    /**
     * 创建AI内容限制服务实例
     */
    @Bean
    public AiContentRestrictService aiContentRestrictService() {
        return AiServices.builder(AiContentRestrictService.class)
                .chatModel(chatModel)
                .build();
    }
}
