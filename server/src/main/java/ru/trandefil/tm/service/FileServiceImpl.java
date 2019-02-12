package ru.trandefil.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.trandefil.tm.api.FileService;
import ru.trandefil.tm.command.Domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileServiceImpl implements FileService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void saveBin() {

    }

    @Override
    public Domain loadBin() {
        return null;
    }

    @Override
    public void saveXml() {

    }

    @Override
    public Domain loadXml() {
        try {
            final String xmlString = new String(Files.readAllBytes(Paths.get("data.xml")));
            final ObjectMapper objectMapper = new XmlMapper();
            final Domain objectFactory = objectMapper.readValue(xmlString, Domain.class);
            return objectFactory;
        } catch (IOException e) {
            logger.info("data is empty.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveJson() {

    }

    @Override
    public Domain loadJson() {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            final String xmlString = new String(Files.readAllBytes(Paths.get("data.json")));
            final Domain objectFactory = objectMapper.readValue(xmlString, Domain.class);
            return objectFactory;
        } catch (IOException e) {
            System.out.println("is empty.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void clearBin() {
        File file = new File("data.bin");
        file.delete();
    }

    @Override
    public void clearXml() {
        File file = new File("data.xml");
        file.delete();
    }

    @Override
    public void clearJson() {
        File file = new File("data.json");
        file.delete();
    }

}
