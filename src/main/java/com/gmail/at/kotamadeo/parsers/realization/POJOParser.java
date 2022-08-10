package com.gmail.at.kotamadeo.parsers.realization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.at.kotamadeo.model.Employee;
import com.gmail.at.kotamadeo.parsers.interfaces.FromJsonParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class POJOParser implements FromJsonParser {

    @Override
    public List<Employee> parseFromJSON(Path path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Employee> employees = objectMapper.readValue(path.toFile(), new TypeReference<>() {
        });
        employees.forEach(System.out::println);
        System.out.println();
        return employees;
    }
}
