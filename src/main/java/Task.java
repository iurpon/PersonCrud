import java.util.*;

public class Task {
    private String id;
    private String name;
    private String description;
    private Date begin;
    private Date end;
    private Project project;

    public Task(String id, String name, String description, Date begin, Date end, Project project) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.project = project;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", begin=" + (begin == null?"Didn't start":DateTimeFormatter.format(begin)) +
                ", end=" + (end == null?"Still in production":DateTimeFormatter.format(end)) +
                ", project='" + project + '\'' +
                '}';
    }
}
