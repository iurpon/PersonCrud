package ru.trandefil.tm.command.json;

import ru.trandefil.tm.command.AbstractCommand;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-load";
    }

    @Override
    public String description() {
        return "load json from file and covert to Object";
    }

    @Override
    @WebMethod
    public void execute() {
/*        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String xmlString = new String(Files.readAllBytes(Paths.get("data.json")));
            Domain objectFactory = objectMapper.readValue(xmlString, Domain.class);
            printProjectCollection(objectFactory.getProjectList(), getServiceLocator().getSession());
            printUserCollection(objectFactory.getUserList(), getServiceLocator().getSession());
            printTaskCollection(objectFactory.getTaskList(), getServiceLocator().getSession());
        } catch (IOException e) {
            System.out.println("is empty.");
            e.printStackTrace();
        }*/
    }

    @Override
    public boolean secure() {
        return true;
    }

}
