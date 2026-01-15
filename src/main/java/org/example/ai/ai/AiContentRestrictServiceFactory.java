package org.example.ai.ai;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.ai.utils.SpringContextUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class AiContentRestrictServiceFactory {


    /**
     * 创建AI内容限制服务实例
     */
    @Bean
    public AiContentRestrictService createAiContentRestrictService() {
        ChatModel chatModel = SpringContextUtil.getBean("contentChatModelPrototype", ChatModel.class);
        return AiServices.builder(AiContentRestrictService.class)
                .chatModel(chatModel)
                .build();
    }

    /**
     * 默认提供一个Bean
     * @return
     */
    @Bean
    public AiContentRestrictService aiContentRestrictService() {
        return createAiContentRestrictService();
    }
}
