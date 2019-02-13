
package ru.trandefil.tm.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.trandefil.tm.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClearBin_QNAME = new QName("http://generated.tm.trandefil.ru/", "clearBin");
    private final static QName _ClearBinResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "clearBinResponse");
    private final static QName _ClearJson_QNAME = new QName("http://generated.tm.trandefil.ru/", "clearJson");
    private final static QName _ClearJsonResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "clearJsonResponse");
    private final static QName _ClearXml_QNAME = new QName("http://generated.tm.trandefil.ru/", "clearXml");
    private final static QName _ClearXmlResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "clearXmlResponse");
    private final static QName _LoadBin_QNAME = new QName("http://generated.tm.trandefil.ru/", "loadBin");
    private final static QName _LoadBinResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "loadBinResponse");
    private final static QName _LoadJson_QNAME = new QName("http://generated.tm.trandefil.ru/", "loadJson");
    private final static QName _LoadJsonResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "loadJsonResponse");
    private final static QName _LoadXml_QNAME = new QName("http://generated.tm.trandefil.ru/", "loadXml");
    private final static QName _LoadXmlResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "loadXmlResponse");
    private final static QName _SaveBin_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveBin");
    private final static QName _SaveBinResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveBinResponse");
    private final static QName _SaveJson_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveJson");
    private final static QName _SaveJsonResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveJsonResponse");
    private final static QName _SaveXml_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveXml");
    private final static QName _SaveXmlResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveXmlResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.trandefil.tm.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClearBin }
     * 
     */
    public ClearBin createClearBin() {
        return new ClearBin();
    }

    /**
     * Create an instance of {@link ClearBinResponse }
     * 
     */
    public ClearBinResponse createClearBinResponse() {
        return new ClearBinResponse();
    }

    /**
     * Create an instance of {@link ClearJson }
     * 
     */
    public ClearJson createClearJson() {
        return new ClearJson();
    }

    /**
     * Create an instance of {@link ClearJsonResponse }
     * 
     */
    public ClearJsonResponse createClearJsonResponse() {
        return new ClearJsonResponse();
    }

    /**
     * Create an instance of {@link ClearXml }
     * 
     */
    public ClearXml createClearXml() {
        return new ClearXml();
    }

    /**
     * Create an instance of {@link ClearXmlResponse }
     * 
     */
    public ClearXmlResponse createClearXmlResponse() {
        return new ClearXmlResponse();
    }

    /**
     * Create an instance of {@link LoadBin }
     * 
     */
    public LoadBin createLoadBin() {
        return new LoadBin();
    }

    /**
     * Create an instance of {@link LoadBinResponse }
     * 
     */
    public LoadBinResponse createLoadBinResponse() {
        return new LoadBinResponse();
    }

    /**
     * Create an instance of {@link LoadJson }
     * 
     */
    public LoadJson createLoadJson() {
        return new LoadJson();
    }

    /**
     * Create an instance of {@link LoadJsonResponse }
     * 
     */
    public LoadJsonResponse createLoadJsonResponse() {
        return new LoadJsonResponse();
    }

    /**
     * Create an instance of {@link LoadXml }
     * 
     */
    public LoadXml createLoadXml() {
        return new LoadXml();
    }

    /**
     * Create an instance of {@link LoadXmlResponse }
     * 
     */
    public LoadXmlResponse createLoadXmlResponse() {
        return new LoadXmlResponse();
    }

    /**
     * Create an instance of {@link SaveBin }
     * 
     */
    public SaveBin createSaveBin() {
        return new SaveBin();
    }

    /**
     * Create an instance of {@link SaveBinResponse }
     * 
     */
    public SaveBinResponse createSaveBinResponse() {
        return new SaveBinResponse();
    }

    /**
     * Create an instance of {@link SaveJson }
     * 
     */
    public SaveJson createSaveJson() {
        return new SaveJson();
    }

    /**
     * Create an instance of {@link SaveJsonResponse }
     * 
     */
    public SaveJsonResponse createSaveJsonResponse() {
        return new SaveJsonResponse();
    }

    /**
     * Create an instance of {@link SaveXml }
     * 
     */
    public SaveXml createSaveXml() {
        return new SaveXml();
    }

    /**
     * Create an instance of {@link SaveXmlResponse }
     * 
     */
    public SaveXmlResponse createSaveXmlResponse() {
        return new SaveXmlResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearBin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "clearBin")
    public JAXBElement<ClearBin> createClearBin(ClearBin value) {
        return new JAXBElement<ClearBin>(_ClearBin_QNAME, ClearBin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearBinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "clearBinResponse")
    public JAXBElement<ClearBinResponse> createClearBinResponse(ClearBinResponse value) {
        return new JAXBElement<ClearBinResponse>(_ClearBinResponse_QNAME, ClearBinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearJson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "clearJson")
    public JAXBElement<ClearJson> createClearJson(ClearJson value) {
        return new JAXBElement<ClearJson>(_ClearJson_QNAME, ClearJson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearJsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "clearJsonResponse")
    public JAXBElement<ClearJsonResponse> createClearJsonResponse(ClearJsonResponse value) {
        return new JAXBElement<ClearJsonResponse>(_ClearJsonResponse_QNAME, ClearJsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearXml }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "clearXml")
    public JAXBElement<ClearXml> createClearXml(ClearXml value) {
        return new JAXBElement<ClearXml>(_ClearXml_QNAME, ClearXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearXmlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "clearXmlResponse")
    public JAXBElement<ClearXmlResponse> createClearXmlResponse(ClearXmlResponse value) {
        return new JAXBElement<ClearXmlResponse>(_ClearXmlResponse_QNAME, ClearXmlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadBin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "loadBin")
    public JAXBElement<LoadBin> createLoadBin(LoadBin value) {
        return new JAXBElement<LoadBin>(_LoadBin_QNAME, LoadBin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadBinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "loadBinResponse")
    public JAXBElement<LoadBinResponse> createLoadBinResponse(LoadBinResponse value) {
        return new JAXBElement<LoadBinResponse>(_LoadBinResponse_QNAME, LoadBinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadJson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "loadJson")
    public JAXBElement<LoadJson> createLoadJson(LoadJson value) {
        return new JAXBElement<LoadJson>(_LoadJson_QNAME, LoadJson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadJsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "loadJsonResponse")
    public JAXBElement<LoadJsonResponse> createLoadJsonResponse(LoadJsonResponse value) {
        return new JAXBElement<LoadJsonResponse>(_LoadJsonResponse_QNAME, LoadJsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadXml }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "loadXml")
    public JAXBElement<LoadXml> createLoadXml(LoadXml value) {
        return new JAXBElement<LoadXml>(_LoadXml_QNAME, LoadXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadXmlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "loadXmlResponse")
    public JAXBElement<LoadXmlResponse> createLoadXmlResponse(LoadXmlResponse value) {
        return new JAXBElement<LoadXmlResponse>(_LoadXmlResponse_QNAME, LoadXmlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveBin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveBin")
    public JAXBElement<SaveBin> createSaveBin(SaveBin value) {
        return new JAXBElement<SaveBin>(_SaveBin_QNAME, SaveBin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveBinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveBinResponse")
    public JAXBElement<SaveBinResponse> createSaveBinResponse(SaveBinResponse value) {
        return new JAXBElement<SaveBinResponse>(_SaveBinResponse_QNAME, SaveBinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveJson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveJson")
    public JAXBElement<SaveJson> createSaveJson(SaveJson value) {
        return new JAXBElement<SaveJson>(_SaveJson_QNAME, SaveJson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveJsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveJsonResponse")
    public JAXBElement<SaveJsonResponse> createSaveJsonResponse(SaveJsonResponse value) {
        return new JAXBElement<SaveJsonResponse>(_SaveJsonResponse_QNAME, SaveJsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveXml }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveXml")
    public JAXBElement<SaveXml> createSaveXml(SaveXml value) {
        return new JAXBElement<SaveXml>(_SaveXml_QNAME, SaveXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveXmlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveXmlResponse")
    public JAXBElement<SaveXmlResponse> createSaveXmlResponse(SaveXmlResponse value) {
        return new JAXBElement<SaveXmlResponse>(_SaveXmlResponse_QNAME, SaveXmlResponse.class, null, value);
    }

}
