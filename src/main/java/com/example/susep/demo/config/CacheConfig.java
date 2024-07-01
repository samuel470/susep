package com.example.susep.demo.config;

import com.example.susep.demo.client.response.ProdutosResponse;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public Cache<String, String> produtosCache() {
        return Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.DAYS)
                .build();
    }
}