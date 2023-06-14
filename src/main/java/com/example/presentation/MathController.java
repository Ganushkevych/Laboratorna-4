package com.example.presentation;

import com.example.models.CalculationsRequest;
import com.example.repository.MathRepository;
import com.example.service.MathService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/math")
public class MathController {
    private final MathRepository mathRepository;

    public MathController(MathRepository mathRepository) {
        this.mathRepository = mathRepository;
    }

    @PostMapping("/calculate")
    public String calculateAndSaveResult(@RequestBody CalculationsRequest request) {
        // Отримую параметри
        BigDecimal a = request.a();
        BigDecimal b = request.b();
        BigDecimal step = request.step();
        // Викликаю сервісний шар для виконання чисельного інтегрування
        MathService mathService = new MathService(a,b,step);
        BigDecimal result = mathService.numericalIntegration();
        CalculationsRequest calculationsRequest = new CalculationsRequest(a,b,step,result);
        // Зберегаю результат в файл
        String id = mathRepository.saveToFile(calculationsRequest);
        return "Результат успішно збережено. ";//ID: "+id;
    }
    @GetMapping("/result/{id}")
    @ResponseBody
    public CalculationsRequest getResultById(@PathVariable String id) {
        return mathRepository.getResultById(id);
    }
}
