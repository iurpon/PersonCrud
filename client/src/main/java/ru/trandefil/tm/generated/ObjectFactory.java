
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

    private final static QName _Delete_QNAME = new QName("http://generated.tm.trandefil.ru/", "delete");
    private final static QName _DeleteByName_QNAME = new QName("http://generated.tm.trandefil.ru/", "deleteByName");
    private final static QName _DeleteByNameResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "deleteByNameResponse");
    private final static QName _DeleteResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "deleteResponse");
    private final static QName _GetAll_QNAME = new QName("http://generated.tm.trandefil.ru/", "getAll");
    private final static QName _GetAllResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "getAllResponse");
    private final static QName _GetById_QNAME = new QName("http://generated.tm.trandefil.ru/", "getById");
    private final static QName _GetByIdResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "getByIdResponse");
    private final static QName _GetByName_QNAME = new QName("http://generated.tm.trandefil.ru/", "getByName");
    private final static QName _GetByNameResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "getByNameResponse");
    private final static QName _Save_QNAME = new QName("http://generated.tm.trandefil.ru/", "save");
    private final static QName _SaveResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.trandefil.tm.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link DeleteByName }
     * 
     */
    public DeleteByName createDeleteByName() {
        return new DeleteByName();
    }

    /**
     * Create an instance of {@link DeleteByNameResponse }
     * 
     */
    public DeleteByNameResponse createDeleteByNameResponse() {
        return new DeleteByNameResponse();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link GetAll }
     * 
     */
    public GetAll createGetAll() {
        return new GetAll();
    }

    /**
     * Create an instance of {@link GetAllResponse }
     * 
     */
    public GetAllResponse createGetAllResponse() {
        return new GetAllResponse();
    }

    /**
     * Create an instance of {@link GetById }
     * 
     */
    public GetById createGetById() {
        return new GetById();
    }

    /**
     * Create an instance of {@link GetByIdResponse }
     * 
     */
    public GetByIdResponse createGetByIdResponse() {
        return new GetByIdResponse();
    }

    /**
     * Create an instance of {@link GetByName }
     * 
     */
    public GetByName createGetByName() {
        return new GetByName();
    }

    /**
     * Create an instance of {@link GetByNameResponse }
     * 
     */
    public GetByNameResponse createGetByNameResponse() {
        return new GetByNameResponse();
    }

    /**
     * Create an instance of {@link Save }
     * 
     */
    public Save createSave() {
        return new Save();
    }

    /**
     * Create an instance of {@link SaveResponse }
     * 
     */
    public SaveResponse createSaveResponse() {
        return new SaveResponse();
    }

    /**
     * Create an instance of {@link Project }
     * 
     */
    public Project createProject() {
        return new Project();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "deleteByName")
    public JAXBElement<DeleteByName> createDeleteByName(DeleteByName value) {
        return new JAXBElement<DeleteByName>(_DeleteByName_QNAME, DeleteByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "deleteByNameResponse")
    public JAXBElement<DeleteByNameResponse> createDeleteByNameResponse(DeleteByNameResponse value) {
        return new JAXBElement<DeleteByNameResponse>(_DeleteByNameResponse_QNAME, DeleteByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getAll")
    public JAXBElement<GetAll> createGetAll(GetAll value) {
        return new JAXBElement<GetAll>(_GetAll_QNAME, GetAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getAllResponse")
    public JAXBElement<GetAllResponse> createGetAllResponse(GetAllResponse value) {
        return new JAXBElement<GetAllResponse>(_GetAllResponse_QNAME, GetAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getById")
    public JAXBElement<GetById> createGetById(GetById value) {
        return new JAXBElement<GetById>(_GetById_QNAME, GetById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getByIdResponse")
    public JAXBElement<GetByIdResponse> createGetByIdResponse(GetByIdResponse value) {
        return new JAXBElement<GetByIdResponse>(_GetByIdResponse_QNAME, GetByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getByName")
    public JAXBElement<GetByName> createGetByName(GetByName value) {
        return new JAXBElement<GetByName>(_GetByName_QNAME, GetByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getByNameResponse")
    public JAXBElement<GetByNameResponse> createGetByNameResponse(GetByNameResponse value) {
        return new JAXBElement<GetByNameResponse>(_GetByNameResponse_QNAME, GetByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Save }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "save")
    public JAXBElement<Save> createSave(Save value) {
        return new JAXBElement<Save>(_Save_QNAME, Save.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveResponse")
    public JAXBElement<SaveResponse> createSaveResponse(SaveResponse value) {
        return new JAXBElement<SaveResponse>(_SaveResponse_QNAME, SaveResponse.class, null, value);
    }

}
