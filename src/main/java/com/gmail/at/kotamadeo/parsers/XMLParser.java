package com.gmail.at.kotamadeo.parsers;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class XMLParser implements AbstractParser {

    @Override
    @SneakyThrows
    public List<Map<?, ?>> parseToJSON(Path path) {
        XmlMapper xmlMapper = new XmlMapper();
        List<Map<?, ?>> result;
        try (MappingIterator<Map<?, ?>> mappingIterator =
                     xmlMapper.reader().forType(Map.class).readValues(path.toFile())) {
            result = mappingIterator.readAll();
            result.forEach(System.out::println);
        }
        System.out.println();
        return result;
    }
}
