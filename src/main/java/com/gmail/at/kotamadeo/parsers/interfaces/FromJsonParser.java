package com.gmail.at.kotamadeo.parsers.interfaces;

import com.gmail.at.kotamadeo.model.Employee;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FromJsonParser {

    List<Employee> parseFromJSON(Path path) throws IOException;
}
