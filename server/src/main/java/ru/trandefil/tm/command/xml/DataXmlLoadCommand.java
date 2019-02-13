package ru.trandefil.tm.command.xml;

import ru.trandefil.tm.command.AbstractCommand;

public class DataXmlLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-load";
    }

    @Override
    public String description() {
        return "load xml data from file";
    }

    @Override
    public void execute() {
/*        try {
            ObjectMapper objectMapper = new XmlMapper();
            String xmlString = new String(Files.readAllBytes(Paths.get("data.xml")));
            Domain objectFactory = objectMapper.readValue(xmlString, Domain.class);
            printProjectCollection(objectFactory.getLists(), getServiceLocator().getSession());
            printUserCollection(objectFactory.getUsers(), getServiceLocator().getSession());
            printTaskCollection(objectFactory.getTasks(), getServiceLocator().getSession());
        } catch (IOException e) {
            System.out.println("is empty.");
        }*/
    }

    @Override
    public boolean secure() {
        return true;
    }

}
