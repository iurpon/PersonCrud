package ru.trandefil.tm.generated;


import ru.trandefil.tm.command.Domain;
import ru.trandefil.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AdminEndPoint {

    @WebMethod
    void saveBin(@WebParam(name = "session") Session session);

    @WebMethod
    void loadBin(@WebParam(name = "session") Session session);

    @WebMethod
    void clearBin(@WebParam(name = "session") Session session);

    @WebMethod
    void saveXml(@WebParam(name = "session") Session session);

    @WebMethod
    void loadXml(@WebParam(name = "session") Session session);

    @WebMethod
    void clearXml(@WebParam(name = "session") Session session);

    @WebMethod
    void saveJson(@WebParam(name = "session") Session session);

    @WebMethod
    void loadJson(@WebParam(name = "session") Session session);

    @WebMethod
    void clearJson(@WebParam(name = "session") Session session);

}
