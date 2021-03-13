package DBConnector;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static DBConnector instance;
    private Connection connection;
    private DBCredentials c;

    private static class DBCredentials {
        private String host;
        private int port;
        private String username;
        private String password;
    }

    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    private DBConnector() {
        loadCredentials();
        if (c != null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + c.host + ":" + c.port + "/harbour", c.username, c.password);
            } catch (ClassNotFoundException e) {
                System.out.println("Unable to use MySQL. " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error communicating with MySQL Database. " + e.getMessage());
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private void loadCredentials() {
        Gson gson = new Gson();
        try {
            DBCredentials credentials = gson.fromJson(new FileReader("db_settings.json"), DBCredentials.class);
            if (credentials == null) {
                System.out.println("Credentials missing in config file");
                return;
            }
            this.c = credentials;
        } catch (FileNotFoundException e) {
            System.out.println("Error reading credentials. " + e.getMessage() );
        }
    }
}
