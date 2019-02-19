package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.AdminService;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.exception.SecurityAuthentificationException;
import ru.trandefil.tm.exception.SecurityAuthorizationException;
import ru.trandefil.tm.generated.AdminEndPoint;
import ru.trandefil.tm.util.SignatureUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "ru.trandefil.tm.generated.AdminEndPoint")
public class AdminEndPointImpl implements AdminEndPoint {

    private AdminService adminService;

    public AdminEndPointImpl(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    @WebMethod
    public void saveJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to do this domain.");
            throw new SecurityAuthorizationException("not authorized for this operation.");
        }
        adminService.saveJson();
    }

    @Override
    @WebMethod
    public void loadJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to do this domain.");
            throw new SecurityAuthorizationException("not authorized for this operation.");
        }
        adminService.loadJson();
    }

    @Override
    @WebMethod
    public void clearJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to do this domain.");
            throw new SecurityAuthorizationException("not authorized for this operation.");
        }
        adminService.clearJson();
    }

}
