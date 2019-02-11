package ru.trandefil.tm.util;

import java.io.InputStream;
import java.util.Properties;
import java.util.stream.IntStream;

public class SignatureUtil {

    public static String generateSignature() {
        final String uuid = UUIDUtil.getUniqueString();
        final String uuidHash = HashUtil.hashPassword(uuid);
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream("prop.properties")) {
            final Properties properties = new Properties();
            properties.load(inputStream);
            final String salt = properties.getProperty("salt");
            final int cycle = Integer.parseInt(properties.getProperty("cycle"));
            final String superUniqie = getMultiHash(salt, cycle, uuidHash);
            return superUniqie;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getMultiHash(final String salt, final int cycle, final String uuidHash) {
        final String saltHah = salt + uuidHash + salt;
        final String[] str = new String[1];
        str[0] = saltHah;
        IntStream.range(0, cycle).forEach((i) -> str[0] = HashUtil.hashPassword(str[0]));
        return str[0];
    }

}
