
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

    private final static QName _DeleteUserByName_QNAME = new QName("http://generated.tm.trandefil.ru/", "deleteUserByName");
    private final static QName _DeleteUserByNameResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "deleteUserByNameResponse");
    private final static QName _GetAllUsers_QNAME = new QName("http://generated.tm.trandefil.ru/", "getAllUsers");
    private final static QName _GetAllUsersResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "getAllUsersResponse");
    private final static QName _GetSession_QNAME = new QName("http://generated.tm.trandefil.ru/", "getSession");
    private final static QName _GetSessionResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "getSessionResponse");
    private final static QName _GetUserByName_QNAME = new QName("http://generated.tm.trandefil.ru/", "getUserByName");
    private final static QName _GetUserByNameResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "getUserByNameResponse");
    private final static QName _Registry_QNAME = new QName("http://generated.tm.trandefil.ru/", "registry");
    private final static QName _RegistryResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "registryResponse");
    private final static QName _SaveUser_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveUser");
    private final static QName _SaveUserResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "saveUserResponse");
    private final static QName _UpdateUser_QNAME = new QName("http://generated.tm.trandefil.ru/", "updateUser");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "updateUserResponse");
    private final static QName _UserLogout_QNAME = new QName("http://generated.tm.trandefil.ru/", "userLogout");
    private final static QName _UserLogoutResponse_QNAME = new QName("http://generated.tm.trandefil.ru/", "userLogoutResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.trandefil.tm.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteUserByName }
     * 
     */
    public DeleteUserByName createDeleteUserByName() {
        return new DeleteUserByName();
    }

    /**
     * Create an instance of {@link DeleteUserByNameResponse }
     * 
     */
    public DeleteUserByNameResponse createDeleteUserByNameResponse() {
        return new DeleteUserByNameResponse();
    }

    /**
     * Create an instance of {@link GetAllUsers }
     * 
     */
    public GetAllUsers createGetAllUsers() {
        return new GetAllUsers();
    }

    /**
     * Create an instance of {@link GetAllUsersResponse }
     * 
     */
    public GetAllUsersResponse createGetAllUsersResponse() {
        return new GetAllUsersResponse();
    }

    /**
     * Create an instance of {@link GetSession }
     * 
     */
    public GetSession createGetSession() {
        return new GetSession();
    }

    /**
     * Create an instance of {@link GetSessionResponse }
     * 
     */
    public GetSessionResponse createGetSessionResponse() {
        return new GetSessionResponse();
    }

    /**
     * Create an instance of {@link GetUserByName }
     * 
     */
    public GetUserByName createGetUserByName() {
        return new GetUserByName();
    }

    /**
     * Create an instance of {@link GetUserByNameResponse }
     * 
     */
    public GetUserByNameResponse createGetUserByNameResponse() {
        return new GetUserByNameResponse();
    }

    /**
     * Create an instance of {@link Registry }
     * 
     */
    public Registry createRegistry() {
        return new Registry();
    }

    /**
     * Create an instance of {@link RegistryResponse }
     * 
     */
    public RegistryResponse createRegistryResponse() {
        return new RegistryResponse();
    }

    /**
     * Create an instance of {@link SaveUser }
     * 
     */
    public SaveUser createSaveUser() {
        return new SaveUser();
    }

    /**
     * Create an instance of {@link SaveUserResponse }
     * 
     */
    public SaveUserResponse createSaveUserResponse() {
        return new SaveUserResponse();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link UserLogout }
     * 
     */
    public UserLogout createUserLogout() {
        return new UserLogout();
    }

    /**
     * Create an instance of {@link UserLogoutResponse }
     * 
     */
    public UserLogoutResponse createUserLogoutResponse() {
        return new UserLogoutResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link UserDTO }
     * 
     */
    public UserDTO createUserDTO() {
        return new UserDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "deleteUserByName")
    public JAXBElement<DeleteUserByName> createDeleteUserByName(DeleteUserByName value) {
        return new JAXBElement<DeleteUserByName>(_DeleteUserByName_QNAME, DeleteUserByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "deleteUserByNameResponse")
    public JAXBElement<DeleteUserByNameResponse> createDeleteUserByNameResponse(DeleteUserByNameResponse value) {
        return new JAXBElement<DeleteUserByNameResponse>(_DeleteUserByNameResponse_QNAME, DeleteUserByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getAllUsers")
    public JAXBElement<GetAllUsers> createGetAllUsers(GetAllUsers value) {
        return new JAXBElement<GetAllUsers>(_GetAllUsers_QNAME, GetAllUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getAllUsersResponse")
    public JAXBElement<GetAllUsersResponse> createGetAllUsersResponse(GetAllUsersResponse value) {
        return new JAXBElement<GetAllUsersResponse>(_GetAllUsersResponse_QNAME, GetAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getSession")
    public JAXBElement<GetSession> createGetSession(GetSession value) {
        return new JAXBElement<GetSession>(_GetSession_QNAME, GetSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getSessionResponse")
    public JAXBElement<GetSessionResponse> createGetSessionResponse(GetSessionResponse value) {
        return new JAXBElement<GetSessionResponse>(_GetSessionResponse_QNAME, GetSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getUserByName")
    public JAXBElement<GetUserByName> createGetUserByName(GetUserByName value) {
        return new JAXBElement<GetUserByName>(_GetUserByName_QNAME, GetUserByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "getUserByNameResponse")
    public JAXBElement<GetUserByNameResponse> createGetUserByNameResponse(GetUserByNameResponse value) {
        return new JAXBElement<GetUserByNameResponse>(_GetUserByNameResponse_QNAME, GetUserByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Registry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "registry")
    public JAXBElement<Registry> createRegistry(Registry value) {
        return new JAXBElement<Registry>(_Registry_QNAME, Registry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "registryResponse")
    public JAXBElement<RegistryResponse> createRegistryResponse(RegistryResponse value) {
        return new JAXBElement<RegistryResponse>(_RegistryResponse_QNAME, RegistryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveUser")
    public JAXBElement<SaveUser> createSaveUser(SaveUser value) {
        return new JAXBElement<SaveUser>(_SaveUser_QNAME, SaveUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "saveUserResponse")
    public JAXBElement<SaveUserResponse> createSaveUserResponse(SaveUserResponse value) {
        return new JAXBElement<SaveUserResponse>(_SaveUserResponse_QNAME, SaveUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLogout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "userLogout")
    public JAXBElement<UserLogout> createUserLogout(UserLogout value) {
        return new JAXBElement<UserLogout>(_UserLogout_QNAME, UserLogout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://generated.tm.trandefil.ru/", name = "userLogoutResponse")
    public JAXBElement<UserLogoutResponse> createUserLogoutResponse(UserLogoutResponse value) {
        return new JAXBElement<UserLogoutResponse>(_UserLogoutResponse_QNAME, UserLogoutResponse.class, null, value);
    }

}
