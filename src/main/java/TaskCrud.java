import java.io.BufferedReader;
import java.io.IOException;

public class TaskCrud {

    public static void taskProcess(String[] choice, BufferedReader reader) {
        int choiceSize = choice.length;
        if(choiceSize < 2 ){
            badCommand();
        }else{
            String secondStep = choice[1].toLowerCase().trim();
            switch (secondStep){
      /*          case "list" :  taskList(reader);break;
                case "update" : taskUpdate(reader);break;
                case "create" : taskCreate(reader);break;
                case "delete" : taskDelete(reader);break;*/
                default: badCommand();
            }
        }

    }

    private static void taskList(BufferedReader reader) throws IOException {
        System.out.println("You are trying to see project tasks");
        System.out.print("Enter correct project name : ");
        String projectName = reader.readLine();
        boolean correctName = false;
        while(!correctName){
            if(projectName.isEmpty()){
                badCommand();
            }

        }


    }

    private static void badCommand(){
        System.out.println("Bad command");

    }
}
