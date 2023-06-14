package com.example.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig implements WebMvcConfigurer {
    private BigDecimal a;
    private BigDecimal  b;
    private BigDecimal  step;
    @Bean
    public BigDecimal a() {
        return BigDecimal.valueOf(0); // або будь-яке інше значення для 'a'
    }

    @Bean
    public BigDecimal b() {
        return BigDecimal.valueOf(10); // або будь-яке інше значення для 'b'
    }

    @Bean
    public BigDecimal step() {
        return BigDecimal.valueOf(1); // або будь-яке інше значення для 'step'
    }
}
