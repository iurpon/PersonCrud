package ru.trandefil.tm.command;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.ProjectService;



public class ProjectRemoveCommand  extends AbstractCommand {

    public ProjectRemoveCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "remove project";
    }

    @Override
    public void execute() {
        System.out.println("Plz enter project name you want to delete : ");
        String name = getServiceLocator().getTerminalService().nextLine();
        ProjectService projectService = serviceLocator.getProjectService();
        projectService.deleteByName(name);
    }

}
