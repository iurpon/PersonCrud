package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.AdminService;
import ru.trandefil.tm.entity.Session;
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
    public void saveBin(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return ;
        }
        adminService.saveBin();
    }

    @Override
    @WebMethod
    public void loadBin(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return ;
        }
         adminService.loadBin();
    }

    @Override
    @WebMethod
    public void clearBin(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return ;
        }
        adminService.clearBin();
    }

    @Override
    @WebMethod
    public void saveXml(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return ;
        }
        adminService.saveXml();
    }

    @Override
    @WebMethod
    public void loadXml(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return ;
        }
        adminService.loadXml();
    }

    @Override
    @WebMethod
    public void clearXml(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return ;
        }
        adminService.clearXml();
    }

    @Override
    @WebMethod
    public void saveJson(Session session) {
        adminService.saveJson();
    }

    @Override
    @WebMethod
    public void loadJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return ;
        }
        adminService.loadJson();
    }

    @Override
    @WebMethod
    public void clearJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return ;
        }
        adminService.clearJson();
    }

}
