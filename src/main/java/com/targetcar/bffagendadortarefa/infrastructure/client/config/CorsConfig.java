package com.targetcar.bffagendadortarefa.infrastructure.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer confiCors() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200") // Permite a origem do front-end
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE") // Métodos HTTP
                        .allowedHeaders("*") // Permite qualquer cabeçalho
                        .allowCredentials(true) // Permite credenciais como cookies
                        .maxAge(3600); // Tempo de cache de CORS (em segundos, aqui 1 hora)
            }
        };
    }
}
