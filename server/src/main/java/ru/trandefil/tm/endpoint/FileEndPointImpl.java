package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.FileService;
import ru.trandefil.tm.command.Domain;
import ru.trandefil.tm.generated.FileEndPoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "ru.trandefil.tm.generated.FileEndPoint")
public class FileEndPointImpl implements FileEndPoint {

    private FileService fileService;

    public FileEndPointImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    @WebMethod
    public void saveBin() {
        fileService.saveBin();
    }

    @Override
    @WebMethod
    public Domain loadBin() {
        return fileService.loadBin();
    }

    @Override
    @WebMethod
    public void clearBin() {
        fileService.clearBin();
    }

    @Override
    @WebMethod
    public void saveXml() {
        fileService.saveXml();
    }

    @Override
    @WebMethod
    public Domain loadXml() {
        return fileService.loadXml();
    }

    @Override
    @WebMethod
    public void clearXml() {
        fileService.clearXml();
    }

    @Override
    @WebMethod
    public void saveJson() {
        fileService.saveJson();
    }

    @Override
    @WebMethod
    public Domain loadJson() {
        return fileService.loadJson();
    }

    @Override
    @WebMethod
    public void clearJson() {
        fileService.clearJson();
    }
}
