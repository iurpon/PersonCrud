package ru.trandefil.tm.api;

import ru.trandefil.tm.command.Domain;

public interface FileService {

    void saveBin();

    Domain loadBin();

    void clearBin();

    void saveXml();

    Domain loadXml();

    void clearXml();

    void saveJson();

    Domain loadJson();

    void clearJson();

}
