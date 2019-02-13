package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.AdminEndPoint;
import ru.trandefil.tm.generated.Session;

import java.io.File;

public class DataBinClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-clear. Admin only";
    }

    @Override
    public String description() {
        return "clear-data-file";
    }

    @Override
    public void execute() {
        final AdminEndPoint adminEndPoint = getServiceLocator().getAdminEndPoint();
        final Session session = getServiceLocator().getSession();
        adminEndPoint.clearBin(session);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
