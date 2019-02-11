package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.command.AbstractCommand;

public class DataBinLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-load";
    }

    @Override
    public String description() {
        return "load data from bin file";
    }

    @Override
    public void execute() {
/*        try (InputStream inputStream = new FileInputStream("data.bin")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Project[] projects = (Project[]) objectInputStream.readObject();
            User[] users = (User[]) objectInputStream.readObject();
            Task[] tasks = (Task[]) objectInputStream.readObject();
            printProjectCollection(Arrays.asList(projects),getServiceLocator().getSession());
            printUserCollection(Arrays.asList(users),getServiceLocator().getSession());
            printTaskCollection(Arrays.asList(tasks),getServiceLocator().getSession());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("is empty.");
        }*/
    }

    @Override
    public boolean secure() {
        return true;
    }

}
