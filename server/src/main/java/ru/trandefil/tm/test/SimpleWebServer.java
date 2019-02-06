package ru.trandefil.tm.test;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class SimpleWebServer {

    @WebMethod
    public int sum(@WebParam(name = "a") int a, @WebParam(name = "b") int b){
        return a + b;
    }

    public static void main(String[] args){
        Endpoint.publish("http://localhost:8080/simpleWebService?wsdl",new SimpleWebServer());
    }
}
