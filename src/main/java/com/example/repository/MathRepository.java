package com.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import com.example.models.CalculationsRequest;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Repository
public class MathRepository {
    private static final String FILE_PATH = "result.json";
    public String saveToFile(CalculationsRequest request) {
        String id = UUID.randomUUID().toString(); // Генеруємо унікальний ідентифікатор
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(FILE_PATH), request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }
    public CalculationsRequest getResultById(String id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(FILE_PATH), CalculationsRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
