package com.example.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // Registering the WebSocket endpoint for frontend to connect to

        registry.addEndpoint("/chat") //WebSocket url
                .setAllowedOrigins("*")      //Allow any origin or set specific origins (e.g., "http://localhost:3000")
                .withSockJS();               //Fallbacks options
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // Configuring the message broker for routing messages to destinations

        registry.setApplicationDestinationPrefixes("/app");               // Prefix for messages from clients (e.g., /app/chat)
        registry.enableSimpleBroker("/topic", "/queue"); // Enable message brokers for specific destinations (e.g., /topic/group, /queue/private)
        registry.setUserDestinationPrefix("/user");                       //Prefix for user-specific destinations (e.g., /user/queue/messages)
    }
}
