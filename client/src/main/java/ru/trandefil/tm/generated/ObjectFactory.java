
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

    private final static QName _DeleteTask_QNAME = new QName("http://generated.tm.trandefil.ru/", "deleteTask");
    private final static QName _DeleteTaskByName_QNAME = new QName("http://generated.tm.trandefil.ru/", "deleteTaskByName");
    private final static QName _DeleteTaskByNameResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "deleteTaskByNameResponse");
    private final static QName _DeleteTaskResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "deleteTaskResponse");
    private final static QName _GetAllTasks_QNAME = new QName("http://generated.tm.trandefil.ru/", "getAllTasks");
    private final static QName _GetAllTasksResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "getAllTasksResponse");
    private final static QName _GetTaskByName_QNAME = new QName("http://generated.tm.trandefil.ru/", "getTaskByName");
    private final static QName _GetTaskByNameResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "getTaskByNameResponse");
    private final static QName _SaveTask_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveTask");
    private final static QName _SaveTaskResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveTaskResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.trandefil.tm.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteTask }
     * 
     */
    public DeleteTask createDeleteTask() {
        return new DeleteTask();
    }

    /**
     * Create an instance of {@link DeleteTaskByName }
     * 
     */
    public DeleteTaskByName createDeleteTaskByName() {
        return new DeleteTaskByName();
    }

    /**
     * Create an instance of {@link DeleteTaskByNameResponse }
     * 
     */
    public DeleteTaskByNameResponse createDeleteTaskByNameResponse() {
        return new DeleteTaskByNameResponse();
    }

    /**
     * Create an instance of {@link DeleteTaskResponse }
     * 
     */
    public DeleteTaskResponse createDeleteTaskResponse() {
        return new DeleteTaskResponse();
    }

    /**
     * Create an instance of {@link GetAllTasks }
     * 
     */
    public GetAllTasks createGetAllTasks() {
        return new GetAllTasks();
    }

    /**
     * Create an instance of {@link GetAllTasksResponse }
     * 
     */
    public GetAllTasksResponse createGetAllTasksResponse() {
        return new GetAllTasksResponse();
    }

    /**
     * Create an instance of {@link GetTaskByName }
     * 
     */
    public GetTaskByName createGetTaskByName() {
        return new GetTaskByName();
    }

    /**
     * Create an instance of {@link GetTaskByNameResponse }
     * 
     */
    public GetTaskByNameResponse createGetTaskByNameResponse() {
        return new GetTaskByNameResponse();
    }

    /**
     * Create an instance of {@link SaveTask }
     * 
     */
    public SaveTask createSaveTask() {
        return new SaveTask();
    }

    /**
     * Create an instance of {@link SaveTaskResponse }
     * 
     */
    public SaveTaskResponse createSaveTaskResponse() {
        return new SaveTaskResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "deleteTask")
    public JAXBElement<DeleteTask> createDeleteTask(DeleteTask value) {
        return new JAXBElement<DeleteTask>(_DeleteTask_QNAME, DeleteTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTaskByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "deleteTaskByName")
    public JAXBElement<DeleteTaskByName> createDeleteTaskByName(DeleteTaskByName value) {
        return new JAXBElement<DeleteTaskByName>(_DeleteTaskByName_QNAME, DeleteTaskByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTaskByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "deleteTaskByNameResponse")
    public JAXBElement<DeleteTaskByNameResponse> createDeleteTaskByNameResponse(DeleteTaskByNameResponse value) {
        return new JAXBElement<DeleteTaskByNameResponse>(_DeleteTaskByNameResponse_QNAME, DeleteTaskByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "deleteTaskResponse")
    public JAXBElement<DeleteTaskResponse> createDeleteTaskResponse(DeleteTaskResponse value) {
        return new JAXBElement<DeleteTaskResponse>(_DeleteTaskResponse_QNAME, DeleteTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getAllTasks")
    public JAXBElement<GetAllTasks> createGetAllTasks(GetAllTasks value) {
        return new JAXBElement<GetAllTasks>(_GetAllTasks_QNAME, GetAllTasks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTasksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getAllTasksResponse")
    public JAXBElement<GetAllTasksResponse> createGetAllTasksResponse(GetAllTasksResponse value) {
        return new JAXBElement<GetAllTasksResponse>(_GetAllTasksResponse_QNAME, GetAllTasksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaskByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getTaskByName")
    public JAXBElement<GetTaskByName> createGetTaskByName(GetTaskByName value) {
        return new JAXBElement<GetTaskByName>(_GetTaskByName_QNAME, GetTaskByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaskByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getTaskByNameResponse")
    public JAXBElement<GetTaskByNameResponse> createGetTaskByNameResponse(GetTaskByNameResponse value) {
        return new JAXBElement<GetTaskByNameResponse>(_GetTaskByNameResponse_QNAME, GetTaskByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveTask")
    public JAXBElement<SaveTask> createSaveTask(SaveTask value) {
        return new JAXBElement<SaveTask>(_SaveTask_QNAME, SaveTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveTaskResponse")
    public JAXBElement<SaveTaskResponse> createSaveTaskResponse(SaveTaskResponse value) {
        return new JAXBElement<SaveTaskResponse>(_SaveTaskResponse_QNAME, SaveTaskResponse.class, null, value);
    }

}
