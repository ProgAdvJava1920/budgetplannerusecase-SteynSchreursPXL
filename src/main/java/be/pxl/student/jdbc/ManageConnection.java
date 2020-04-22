package be.pxl.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageConnection {
    private String url;
    private String username = "root";
    private String password = "root";

    public void Connection(String url) {
        this.url = url;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
