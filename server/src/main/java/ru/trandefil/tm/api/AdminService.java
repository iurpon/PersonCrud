package ru.trandefil.tm.api;

import ru.trandefil.tm.command.Domain;

public interface AdminService {

    void saveBin();

    void loadBin();

    void clearBin();

    void saveXml();

    void loadXml();

    void clearXml();

    void saveJson();

    void loadJson();

    void clearJson();

}
