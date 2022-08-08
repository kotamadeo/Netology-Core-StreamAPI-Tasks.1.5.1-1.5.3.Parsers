package com.gmail.at.kotamadeo.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.at.kotamadeo.model.Employee;
import lombok.SneakyThrows;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class POJOParser implements AbstractParser {
    @Override
    public List<Map<?, ?>> parseToJSON(Path path) {
        throw new UnsupportedOperationException();
    }

    @SneakyThrows
    public List<Employee> parseFromJSON(Path path) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Employee> employees = objectMapper.readValue(path.toFile(), new TypeReference<>() {
        });
        employees.forEach(System.out::println);
        System.out.println();
        return employees;
    }
}
