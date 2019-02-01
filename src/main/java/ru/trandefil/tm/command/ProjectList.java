package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.BaseEntity;
import ru.trandefil.tm.service.ProjectService;

import java.util.List;

public class ProjectList implements AbstractCommand {

    private ProjectService projectService;

    public ProjectList(ProjectService projectService) {
        this.projectService = projectService;
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
    public List<BaseEntity> execute() {
        return projectService.projectList();
    }
}
