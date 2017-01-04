package com.shubin.mapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {


    public static Connection getConnection() throws SQLException {
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            Connection con = null;
            props.load(fis);

            Class.forName(props.getProperty("DB_DRIVER_CLASS"));

            con = DriverManager.getConnection(props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));

            return con;
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }
    }
}
