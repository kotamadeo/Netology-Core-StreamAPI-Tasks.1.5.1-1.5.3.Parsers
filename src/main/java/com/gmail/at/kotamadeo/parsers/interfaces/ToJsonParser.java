package com.gmail.at.kotamadeo.parsers.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface ToJsonParser {

    default void writeJSON(Path path, List<Map<?, ?>> data) throws IOException {
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        String json = new ObjectMapper().writeValueAsString(data);
        System.out.println("**********************************************************************\n" + json);
        try (FileWriter fileWriter = new FileWriter(path.toFile())) {
            fileWriter.write(json);
        }
    }

    List<Map<?, ?>> parseToJSON(Path path) throws IOException;
}
