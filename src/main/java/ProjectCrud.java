import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;



public class ProjectCrud {

    private static void badCommand(){
        System.out.println("Bad command");
    }

    public static void projectProcess(String[] choice, BufferedReader reader) throws IOException {
        int choiceSize = choice.length;
        if(choiceSize < 2 ){
            badCommand();
        }else{
            String secondStep = choice[1].toLowerCase().trim();
            switch (secondStep){
                case "list" :  projectList();break;
                case "update" : projectUpdate(reader);break;
                case "create" : projectCreate(reader);break;
                case "delete" : projectDelete(reader);break;
                default: badCommand();
            }
        }
    }

    private static void projectDelete(BufferedReader reader) throws IOException {
        System.out.println("You are trying to delete project : ");
        Project project = TaskCrud.getProject(reader);
        AppRun.tasks.values().forEach( t -> {
            if(t.getProject().equals(project)){
                AppRun.tasks.remove(t.getName());
            }
        });
        AppRun.projects.remove(project.getName());
        Map<String, Project> projects = AppRun.projects;
        Map<String,Task> tasks = AppRun.tasks;
        System.out.println();


    }


    private static void projectCreate(BufferedReader reader) throws IOException {
        System.out.println("You are trying to create new project : ");
        boolean filled = false;
        while(!filled){
            filled = true;
            System.out.print("Enter new project name  : ");
            String newName = reader.readLine();
            if(newName.isEmpty()){
                badCommand();
                filled = false;
                continue;
            }
            System.out.print("Enter new project description  : ");
            String newDescription = reader.readLine();
            if(newDescription.isEmpty()){
                badCommand();
                filled = false;
                continue;
            }
            UUID uuid = UUID.randomUUID();
            String id = uuid.toString();

            Project project = new Project(id,newName,newDescription);
            AppRun.projects.put(newName,project);
        }

    }

    private static void projectUpdate(BufferedReader reader) throws IOException {
        System.out.print("Enter project Id you want to update : ");
        String projectName = reader.readLine();
//        System.out.println();
        Project project = AppRun.projects.get(projectName);
        if(project == null){
            badCommand();
        }else{
            System.out.println("you trying to update project : " + project);
            boolean filled = false;
            while(!filled){
                filled = true;
                System.out.print("Enter new project name  : ");
                String newName = reader.readLine();
                if(newName.isEmpty()){
                    badCommand();
                    filled = false;
                }
                System.out.print("Enter new project name  : ");
                String newDescription = reader.readLine();
                if(newDescription.isEmpty()){
                    filled = false;
                }

                project.setName(newName);
                project.setName(newDescription);
                AppRun.projects.remove(projectName);
                AppRun.projects.put(newName,project);

            }
        }
    }


    private static void projectList() {
        AppRun.projects.values().forEach(System.out::println);
    }
}
