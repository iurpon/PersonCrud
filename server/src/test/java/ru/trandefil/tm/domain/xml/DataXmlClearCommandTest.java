package ru.trandefil.tm.domain.xml;

import org.junit.Test;

import java.io.File;

public class DataXmlClearCommandTest {

    @Test
    public void execute() {
        File file = new File("data.xml");
        file.delete();
    }
}