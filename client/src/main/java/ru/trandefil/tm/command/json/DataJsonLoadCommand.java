package ru.trandefil.tm.command.json;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.AdminEndPoint;
import ru.trandefil.tm.generated.FileEndPoint;
import ru.trandefil.tm.generated.Session;

public class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-load";
    }

    @Override
    public String description() {
        return "load json from file and cache it. Admin only,";
    }

    @Override
    public void execute() {
        final AdminEndPoint adminEndPoint = getServiceLocator().getAdminEndPoint();
        final Session session = getServiceLocator().getSession();
        adminEndPoint.loadJson(session);
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
