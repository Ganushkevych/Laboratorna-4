package com.example.service;

import com.example.exceptions.WrongValueException;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
@Service
public class MathService {
    private final BigDecimal a;
    private final BigDecimal b;
    private final BigDecimal step;
    public MathService(BigDecimal a, BigDecimal b,  BigDecimal step) {
        this.a = a;
        this.b = b;
        this.step = step;
    }
    public BigDecimal numericalIntegration() {
        if(step.compareTo(BigDecimal.ZERO) <= 0) throw new WrongValueException("Step should be positive");
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal value = a;
        while (value.compareTo(b) <= 0) {
            if (value.equals(a)||value.compareTo(b)==0) {
                result = result.add(f(value)
                        .divide(BigDecimal.valueOf(2), 3, RoundingMode.HALF_UP));
            } else {
                result = result.add(f(value));
            }
            value = value.add(step);
        }
        return result.multiply(step).setScale(3, RoundingMode.HALF_UP);
    }
    private BigDecimal f(BigDecimal x){
        return BigDecimal.valueOf(1);
    }
}

