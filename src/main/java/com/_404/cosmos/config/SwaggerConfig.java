package com._404.cosmos.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.jackson.ModelResolver;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    SwaggerConfig() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        ModelConverters.getInstance().addConverter(new ModelResolver(mapper));
    }
}
