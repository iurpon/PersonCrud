package ru.trandefil.tm.command.xml;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DataXmlClearCommandTest {

    @Test
    public void execute() {
        File file = new File("data.xml");
        file.delete();
    }
}