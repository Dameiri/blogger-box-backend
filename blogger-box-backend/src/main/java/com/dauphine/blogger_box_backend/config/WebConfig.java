package com.dauphine.blogger_box_backend.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configuration CORS
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/v1/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET","POST","PUT","UPDATE","DELETE")
                .allowCredentials(true);
    }

    /**
     * Configure Jackson pour gérer java.time.LocalDateTime
     * et ne pas écrire les dates sous forme de timestamps.
     */
    @Bean
    public ObjectMapper jacksonObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        // Module JSR-310 pour LocalDateTime, etc.
        om.registerModule(new JavaTimeModule());
        // Force l’écriture en chaîne (pas en timestamp)
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return om;
    }
}