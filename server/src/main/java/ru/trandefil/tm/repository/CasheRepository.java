package ru.trandefil.tm.repository;

import ru.trandefil.tm.command.Domain;

import java.util.HashMap;
import java.util.Map;

public class CasheRepository {

    private Map<String, Domain> cache = new HashMap<>();

    private final String BIN = "bin";

    private final String XML = "xml";

    private final String JSON = "json";

    public void saveBin(Domain domain){
        cache.put(BIN,domain);
    }

    public Domain loadBin(){
        return cache.get(BIN);
    }

    public void saveXml(Domain domain){
        cache.put(XML,domain);
    }

    public Domain loadXml(){
        return cache.get(XML);
    }

    public void saveJson(Domain domain){
        cache.put(JSON,domain);
    }

    public Domain loadJson(){
        return cache.get(JSON);
    }

}
