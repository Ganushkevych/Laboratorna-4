package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public record CalculationsRequest(@JsonProperty("a")BigDecimal a, @JsonProperty("b")BigDecimal b,
                                  @JsonProperty("step")BigDecimal step, @JsonProperty("result") BigDecimal result) {
}