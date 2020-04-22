package be.pxl.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ManageConnection {
    private String url;
    private String username = "root";
    private String password = "root";

    public void Connection(String url) {
        this.url = url;
    }

    public Connection getConnection() {
        return DriverManager.getConnection(url, user, password);
    }
}
