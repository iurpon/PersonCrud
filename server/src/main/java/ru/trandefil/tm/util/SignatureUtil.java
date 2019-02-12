package ru.trandefil.tm.util;

import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;

import java.io.InputStream;
import java.util.Properties;
import java.util.stream.IntStream;

public class SignatureUtil {

    private static String generateSignature(final String allFields) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream("prop.properties")) {
            final Properties properties = new Properties();
            properties.load(inputStream);
            final String salt = properties.getProperty("salt");
            final int cycle = Integer.parseInt(properties.getProperty("cycle"));
            final String superUniqie = getMultiHash(salt, cycle, allFields);
            return superUniqie;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getMultiHash(final String salt, final int cycle, final String allFields) {
        final String solted = salt + allFields + salt;
        final String[] str = new String[1];
        str[0] = solted;
        IntStream.range(0, cycle).forEach((i) -> str[0] = HashUtil.hashPassword(str[0]));
        return str[0];
    }

    public static String createSignature(final String id, final String userId, final long timeStamp, final Role role) {
        final String sessionFields = id + userId + timeStamp + role.name();
        return generateSignature(sessionFields);
    }

    public static boolean checkCorrectSession(Session session) {
        if (session == null) {
            System.out.println("session is null");
            return false;
        }
        if (session.getId() == null) {
            return false;
        }
        if (session.getRole() == null) {
            return false;
        }
        if (session.getUserId() == null) {
            return false;
        }
        if (session.getTimeStamp() == 0) {
            return false;
        }
        if (session.getSignature() == null) {
            return false;
        }
        return session.getSignature().equals(createSignature(session.getId(),
                session.getUserId(), session.getTimeStamp(), session.getRole()));
    }

}
