package ru.trandefil.tm;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App {

    public static void main(String[] args){
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        initializer.addPackages(true, App.class);
        SeContainer container = initializer.initialize();

        Bootstrap bootStrap = new Bootstrap();
        bootStrap.init();
    }

}
