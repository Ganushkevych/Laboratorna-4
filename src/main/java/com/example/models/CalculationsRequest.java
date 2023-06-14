package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public record CalculationsRequest(@JsonProperty("a")BigDecimal a, @JsonProperty("b")BigDecimal b,
                                  @JsonProperty("step")BigDecimal step, @JsonProperty("result") BigDecimal result) {
    public String textRequest(String language){
        if(language.equals("en")) return "Integration algorithm: Trapezium method\nInterval: from " + a + " to " + b+"\nStep: " + step+"\nResult: " + result;
        return "Алгоритм інтегрування: Метод трапецій\nІнтервал: від " + a + " до " + b+"\nКрок: " + step+"\nРезультат інтегрування: " + result;
    }
}