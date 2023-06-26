package com.example.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;
import java.util.function.Function;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig implements WebMvcConfigurer {
    private BigDecimal a;
    private BigDecimal  b;
    private BigDecimal  step;
    @Bean("Prototype")
    public BigDecimal a() {
        return BigDecimal.valueOf(0);
    }

    @Bean("Prototype")
    public BigDecimal b() {
        return BigDecimal.valueOf(10);
    }

    @Bean("Prototype")
    public BigDecimal step() {
        return BigDecimal.valueOf(1);
    }
    @Bean("Prototype")
    public Function<BigDecimal,BigDecimal> f(){
        return arg -> arg.pow(2);
    }
}