package ru.trandefil.tm.generated;


import ru.trandefil.tm.command.Domain;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface FileEndPoint {

    @WebMethod
    void saveBin();

    @WebMethod
    Domain loadBin();

    @WebMethod
    void clearBin();

    @WebMethod
    void saveXml();

    @WebMethod
    Domain loadXml();

    @WebMethod
    void clearXml();

    @WebMethod
    void saveJson();

    @WebMethod
    Domain loadJson();

    @WebMethod
    void clearJson();

}
