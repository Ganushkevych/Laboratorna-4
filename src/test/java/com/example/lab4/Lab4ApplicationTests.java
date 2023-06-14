package com.example.lab4;

import com.example.models.CalculationsRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MathControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void calculateAndSaveResult_ValidData_Returns200AndSavesToFile() {
        BigDecimal a = BigDecimal.valueOf(0);
        BigDecimal b = BigDecimal.valueOf(10);
        BigDecimal step = BigDecimal.valueOf(1);
        CalculationsRequest request = new CalculationsRequest(a, b, step, null);

        ResponseEntity<String> response = restTemplate.postForEntity("/math/calculate", request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Результат успішно збережено. ", response.getBody());

        // Verify that the result is saved to the file
        File file = new File("result.json");
        assertTrue(file.exists());
        file.delete();
    }
}
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MathControllerIntegrationTest1 {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void calculateAndSaveResult_ValidData_Returns200AndSavesToFile() {
        BigDecimal a = BigDecimal.valueOf(0);
        BigDecimal b = BigDecimal.valueOf(10);
        BigDecimal step = BigDecimal.valueOf(0.5);
        BigDecimal expectedResult = BigDecimal.valueOf(10.000).setScale(3, RoundingMode.HALF_UP);

        CalculationsRequest request = new CalculationsRequest(a, b, step, null);

        ResponseEntity<String> response = restTemplate.postForEntity("/math/calculate", request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Результат успішно збережено. ", response.getBody());

        File file = new File("result.json");
        assertTrue(file.exists());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CalculationsRequest result = objectMapper.readValue(file, CalculationsRequest.class);
            assertEquals(expectedResult, result.result());
        } catch (IOException e) {
            fail("Failed to read the result from the file.");
        }

        file.delete();
    }
}



