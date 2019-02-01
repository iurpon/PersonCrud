package ru.trandefil.tm.command;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.AbstractServiceLocator;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.util.DateTimeFormatter;


import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class TaskCreateCommand extends AbstractCommand {
    public TaskCreateCommand(AbstractServiceLocator abstractServiceLocator) {
        super(abstractServiceLocator);
    }

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "create new task for project";
    }

    @Override
    public void execute() {
        Scanner scanner = abstractServiceLocator.getScanner();
        System.out.println("enter project name to add new task :");
        String projectName = scanner.nextLine();
        ProjectService projectService = abstractServiceLocator.getProjectService();
        Project project = projectService.getByName(projectName);
        if(project == null){
            System.out.println("Wrong project name");
            return;
        }else{

        }

    }
    private Date getDate(Scanner scanner, String str) throws IOException {
        boolean correctDate = false;
        Date date = null;
        while (!correctDate){
            System.out.format("Enter the %s date with format dd-MM-yyyy : ",str);
            String dateString = scanner.nextLine();

            if(dateString.isEmpty()){
                return null;
            }else{
                try {
                    date = DateTimeFormatter.parse(dateString);
                    correctDate = true;
                } catch (ParseException e) {
                    System.out.println("Incorrect date format");
                }
            }
        }
        return date;
    }
    private String getNotNullString( Scanner scanner,String requestedStringName){
        System.out.format("Enter Task %s : ",requestedStringName);
        boolean notNull = false;
        String requestString = null;
        while (!notNull){
            requestString = scanner.nextLine();
            if("return".equals(requestString)) return null;
            if(requestString.isEmpty()){
                System.out.println("String must be not empty");
            }else{
                notNull = true;
            }
        }
        return requestString;
    }
}
