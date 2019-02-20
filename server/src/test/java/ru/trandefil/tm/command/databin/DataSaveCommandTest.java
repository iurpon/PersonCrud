package ru.trandefil.tm.command.databin;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class DataSaveCommandTest {

    @Test
    public void execute() {
        InputStream inputStream = ClassLoader.class.getResourceAsStream("/data.bin");
        Assert.assertEquals(true,inputStream!=null);
    }
}