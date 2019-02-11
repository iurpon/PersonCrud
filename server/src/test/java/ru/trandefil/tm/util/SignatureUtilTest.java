package ru.trandefil.tm.util;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.*;

public class SignatureUtilTest {

    @Test
    public void testResourse(){

        try(InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("prop.properties")) {
            Properties properties = new Properties();
            properties.load(systemResourceAsStream);
            System.out.println(properties.getProperty("salt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}