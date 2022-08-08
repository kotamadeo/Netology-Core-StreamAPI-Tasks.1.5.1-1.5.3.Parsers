package com.gmail.at.kotamadeo.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface AbstractParser {

    @SneakyThrows
     default void writeJSON(Path path, List<Map<?, ?>> data) {
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        String json = new ObjectMapper().writeValueAsString(data);
        System.out.println("**********************************************************************\n" + json);
        try (FileWriter fileWriter = new FileWriter(path.toFile())) {
            fileWriter.write(json);
        }
    }


    List<Map<?, ?>> parseToJSON(Path path);
}
