package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestDataLoader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode loadJson(String filePath) {
        try {
            return mapper.readTree(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data from: " + filePath, e);
        }
    }
}