package com.gmail.at.kotamadeo.parsers.realization;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.gmail.at.kotamadeo.parsers.interfaces.ToJsonParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class CSVParser implements ToJsonParser {

    @Override
    public List<Map<?, ?>> parseToJSON(Path path) throws IOException {
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        List<Map<?, ?>> result;
        try (MappingIterator<Map<?, ?>> mappingIterator =
                     csvMapper.reader().forType(Map.class).with(csvSchema).readValues(path.toFile())) {
            result = mappingIterator.readAll();
            result.forEach(System.out::println);
        }
        System.out.println();
        return result;
    }
}
