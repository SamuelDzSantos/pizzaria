package pizzaria.services;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Author: Eduardo e Christian
 * Created: 21/06/2023
 */
public class ConnectionFactory {

    public static final int PostgreSQL = 0;
    private static final String PostgreSQLDriver = "org.postgresql.Driver";
    private static String user;
    private static String dbUrl;
    private static String password;

    public static Connection getConnection() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/application.properties"));
            user = properties.getProperty("database.user");
            dbUrl = properties.getProperty("database.url");
            password = properties.getProperty("database.password");
            Class.forName(PostgreSQLDriver);
            return DriverManager.getConnection(dbUrl, user, password);
        } catch (Exception e) {
            System.out.println(e);
            return null;
            // throw new RuntimeException(e.getMessage());
        }
    }

}
