package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.AdminEndPoint;
import ru.trandefil.tm.generated.Session;

public class DataBinSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-save";
    }

    @Override
    public String description() {
        return "store data to bin file. Admin only.";
    }

    @Override
    public void execute() {
        final AdminEndPoint adminEndPoint = getServiceLocator().getAdminEndPoint();
        final Session session = getServiceLocator().getSession();
        adminEndPoint.saveBin(session);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
