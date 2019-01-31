import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AppRun {
    public static Map<String, List<String>> helper = new HashMap<>();

    static {
        helper.put("help", Arrays.asList("quit",
                "project-list","project-remove","project-create","project-update",
                "task-list","task-remove","task-create","task-update"));
    }

    public static Map<String,Project> projects = new HashMap<>();
    public static Map<String,Task> tasks = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String userChoice = "";
        System.out.println("you can type help to see available command");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(!"exit".equals(userChoice)){
                userChoice = reader.readLine();
                String[] choises = userChoice.split("-");
                processingUserChoise(choises,reader);
            }
        }

    }

    private static void processingUserChoise(String[] choises, BufferedReader reader) throws IOException {
        String firstStep = choises[0].toLowerCase().trim();
        switch (firstStep){
            case "help" : help();break;
            case "project" :  ProjectCrud.projectProcess(choises,reader);break;
            case "task" :     TaskCrud.taskProcess(choises,reader);break;
            case "exit" : break;
            default: System.out.println("bad request");
        }
    }

    private static void help() {
        helper.get("help").forEach(System.out::println);
    }



}
