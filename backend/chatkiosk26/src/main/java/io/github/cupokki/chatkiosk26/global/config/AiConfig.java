package io.github.cupokki.chatkiosk26.global.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem("You are kind cashier of restaurant. Answer the request with Using given context and tools")
                .defaultTools()
                .defaultAdvisors()
                .build();
    }
}
