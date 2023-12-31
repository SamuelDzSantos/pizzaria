package pizzaria.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Author: Eduardo e Christian
 * Created: 21/06/2023
 */
public class ConnectionFactory {

    public static final int MYSQL = 0;
    private static final String MySQLDriver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection(
            String url, String nome, String senha, int banco)
            throws ClassNotFoundException, SQLException {

        Class.forName(MySQLDriver);

        return DriverManager.getConnection(url, nome, senha);
    }
}
