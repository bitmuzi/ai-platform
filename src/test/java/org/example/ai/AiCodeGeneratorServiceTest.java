package org.example.ai;

import jakarta.annotation.Resource;
import org.example.ai.ai.AiCodeGeneratorService;
import org.example.ai.ai.model.HtmlCodeResult;
import org.example.ai.ai.model.MultiFileCodeResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCode("做个工作记录小工具, 不超过20行");
        Assertions.assertNotNull(result);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult multiFileCode = aiCodeGeneratorService.generateMultiFileCode("做个留言板, 不超过20行");
        Assertions.assertNotNull(multiFileCode);
    }

}


