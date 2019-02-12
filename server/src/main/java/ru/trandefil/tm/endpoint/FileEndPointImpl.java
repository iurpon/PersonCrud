package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.FileService;
import ru.trandefil.tm.command.Domain;
import ru.trandefil.tm.generated.FileEndPoint;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.trandefil.tm.generated.FileEndPoint")
public class FileEndPointImpl implements FileEndPoint {

    private FileService fileService;

    public FileEndPointImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void saveBin() {
        fileService.saveBin();
    }

    @Override
    public Domain loadBin() {
        return fileService.loadBin();
    }

    @Override
    public void clearBin() {
        fileService.clearBin();
    }

    @Override
    public void saveXml() {
        fileService.saveXml();
    }

    @Override
    public Domain loadXml() {
        return fileService.loadXml();
    }

    @Override
    public void clearXml() {
        fileService.clearXml();
    }

    @Override
    public void saveJson() {
        fileService.saveJson();
    }

    @Override
    public Domain loadJson() {
        return fileService.loadJson();
    }

    @Override
    public void clearJson() {
        fileService.clearJson();
    }
}
