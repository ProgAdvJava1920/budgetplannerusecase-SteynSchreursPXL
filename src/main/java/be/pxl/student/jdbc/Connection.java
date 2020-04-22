package be.pxl.student.jdbc;

import java.sql.DriverManager;
import java.util.logging.LogManager;

public class Connection {
    private String url;
    private String username = "root";
    private String password = "root";

    public Connection(String url) {
        this.url = url;
    }

    public Connection getConnection() {
        return DriverManager.getConnection(url, user, password);
    }
}
