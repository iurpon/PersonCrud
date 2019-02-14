package ru.trandefil.tm.api;

import java.sql.Connection;

public interface ConnectionService {

    void startConnection();

    Connection getDbConnect();

}
