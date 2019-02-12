package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.Project;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.generated.Session;

import java.util.List;

public class ProjectListCommand extends AbstractCommand {

    public ProjectListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectListCommand() {
    }

    @Override
    public String command() {
        return "project-list";
    }

    @Override
    public String description() {
        return "show all created projects";
    }

    @Override
    public void execute() {
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final Session session = getServiceLocator().getSession();
        final List<Project> projects = projectEndPoint.getAllProjects(session);
        if(projects == null){
            return;
        }
        projects.forEach(System.out::println);
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

}
