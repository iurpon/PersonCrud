package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.AdminEndPoint;
import ru.trandefil.tm.generated.Session;

public class DataBinLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-load";
    }

    @Override
    public String description() {
        return "load data from bin file. Admin only.";
    }

    @Override
    public void execute() {
        final AdminEndPoint adminEndPoint = getServiceLocator().getAdminEndPoint();
        final Session session = getServiceLocator().getSession();
        adminEndPoint.loadBin(session);
    }


    @Override
    public boolean secure() {
        return true;
    }

}
