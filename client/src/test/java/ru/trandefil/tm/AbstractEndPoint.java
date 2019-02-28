package ru.trandefil.tm;

import ru.trandefil.tm.endpoint.ProjectEndPointImplService;
import ru.trandefil.tm.endpoint.TaskEndPointImplService;
import ru.trandefil.tm.endpoint.UserEndPointImplService;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.generated.TaskEndPoint;
import ru.trandefil.tm.generated.UserEndPoint;

public class AbstractEndPoint {

    protected final UserEndPoint userEndPoint = new UserEndPointImplService().getUserEndPointImplPort();

    protected final TaskEndPoint taskEndPoint = new TaskEndPointImplService().getTaskEndPointImplPort();

    protected final ProjectEndPoint projectEndPoint = new ProjectEndPointImplService().getProjectEndPointImplPort();

}
