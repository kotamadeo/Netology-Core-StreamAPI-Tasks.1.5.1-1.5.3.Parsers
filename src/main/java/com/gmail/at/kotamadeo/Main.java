package com.gmail.at.kotamadeo;

import com.gmail.at.kotamadeo.parsers.CSVParser;
import com.gmail.at.kotamadeo.parsers.POJOParser;
import com.gmail.at.kotamadeo.parsers.XMLParser;

import java.nio.file.Path;

public class Main {
    private static final Path csv = Path.of("D:\\Module_1-Stream_API-Tasks_1.5.1-1.5.3-Parsers\\data.csv");
    private static final Path xml = Path.of("D:\\Module_1-Stream_API-Tasks_1.5.1-1.5.3-Parsers\\data.xml");
    private static final Path jsonFromCsv = Path.of("D:\\Module_1-Stream_API-Tasks_1.5.1-1.5.3-Parsers\\data.json");
    private static final Path jsonFromXml = Path.of("D:\\Module_1-Stream_API-Tasks_1.5.1-1.5.3-Parsers\\data2.json");

    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();
        XMLParser xmlParser = new XMLParser();
        POJOParser pojoParser = new POJOParser();
        csvParser.writeJSON(jsonFromCsv, csvParser.parseToJSON(csv));
        xmlParser.writeJSON(jsonFromXml, xmlParser.parseToJSON(xml));
        pojoParser.parseFromJSON(jsonFromCsv);
        pojoParser.parseFromJSON(jsonFromXml);
    }
}