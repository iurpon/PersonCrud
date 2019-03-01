package ru.trandefil.tm.endpoint;

import lombok.NonNull;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.dto.ProjectDTO;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.exception.SecurityAuthentificationException;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.util.SignatureUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@WebService(endpointInterface = "ru.trandefil.tm.generated.ProjectEndPoint")
public class ProjectEndPointImpl implements ProjectEndPoint {

    @Inject
    private ProjectService projectService;

    @Inject
    private UserService userService;

    @Override
    public ProjectDTO saveProject(String name, String description, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final Project saved = projectService.save(session.getUserId(), name, description);
        return getDTOproject(saved);
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO project, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final Project updated = projectService.update(fromDTO(project));
        return getDTOproject(updated);
    }

    @Override
    public List<ProjectDTO> getAllProjects(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final List<Project> projectList = projectService.getAll(session.getUserId());
        return getDTOProjectList(projectList);
    }

    @Override
    public ProjectDTO getProjectById(String id, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        Project project = projectService.getById(id, session.getUserId());
        return getDTOproject(project);
    }

    @Override
    public void deleteProject(ProjectDTO projectDTO, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final Project project = fromDTO(projectDTO);
        projectService.delete(session.getUserId(), project);
    }

    @Override
    public void deleteProjectByName(String projectName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        projectService.deleteByName(session.getUserId(), projectName);
    }

    @Override
    public ProjectDTO getProjectByName(String projectName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        Project project = projectService.getByName(projectName, session.getUserId());
        return getDTOproject(project);
    }

    private ProjectDTO getDTOproject(@NonNull Project project) {
        final ProjectDTO dto = new ProjectDTO(project);
        return dto;
    }

    private List<ProjectDTO> getDTOProjectList(@NonNull List<Project> projects) {
        final List<ProjectDTO> projectDTOList = new ArrayList<>();
        projects.forEach(p -> projectDTOList.add(getDTOproject(p)));
        return projectDTOList;
    }

    private Project fromDTO(@NonNull ProjectDTO dto) {
        final User user = userService.getByName(dto.getUserName());
        final Project project = new Project(dto.getId(),dto.getName(),dto.getDescription(),user);
        return project;
    }

}
