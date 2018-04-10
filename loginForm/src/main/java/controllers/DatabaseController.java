package controllers;

import java.sql.*;

public class DatabaseController {

    private static final String url = "jdbc:hsqldb:hsql://localhost/";
    private static final String username = "SA";
    private static final String password = "";

    private Connection connection;

    public Connection DatabaseConnection() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection(url, username, password);
            if(!isDatabaseExist()) createTable();
        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }
        return connection;
    }


    private boolean isDatabaseExist() {
        ResultSet resultSet = null;
        try {
            resultSet = connection.getMetaData().getCatalogs();

            while (resultSet.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet != null;
    }

    private void createTable(){
        String query = "CREATE TABLE USERS (\n" +
                "ID INT IDENTITY PRIMARY KEY,\n" +
                "LOGIN VARCHAR(30) NOT NULL,\n" +
                "PASSWORD VARCHAR(30) NOT NULL,\n" +
                "EMAIL VARCHAR(50),\n" +
                "RIGHTS VARCHAR(50)\n" +
                ")";

        String queryUsers = "INSERT INTO USERS (LOGIN,PASSWORD,EMAIL,RIGHTS) VALUES ('admin','admin','admin@admin','administrator')";

        try {

            Statement s = connection.createStatement();
            s.executeUpdate(query);
            s.executeUpdate(queryUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }
