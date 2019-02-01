package ru.trandefil.tm;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.command.ProjectList;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BootStrap {
    private static final Map<String, AbstractCommand> commandMap = new HashMap<>();
    static {
        commandMap.put("project-list",new ProjectList());
    }


    public void init() throws IOException {



        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                String s = reader.readLine();
                AbstractCommand abstractCommand = commandMap.get(s);
                if(abstractCommand == null){
                    System.out.println("Bad command.");
                    continue;
                }
                abstractCommand.execute();
            }
        }
    }

}
