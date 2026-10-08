package com.example.backend.controller;

import com.example.backend.dto.DataRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api/data")
@CrossOrigin(origins = "*")
public class DataController {

    private static final String FILE_PATH = "data.txt";

    @PostMapping
    public ResponseEntity<String> saveData(@RequestBody DataRequest request) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(request.getText());
            writer.newLine();
            return ResponseEntity.ok("Данные успешно сохранены в файл");
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Ошибка записи: " + e.getMessage());
        }
    }
}