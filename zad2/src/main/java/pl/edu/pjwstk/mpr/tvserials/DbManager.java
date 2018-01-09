package pl.edu.pjwstk.mpr.tvserials;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbManager {

    private Connection connection;
    private String url = "jdbc:hsqldb:hsql://localhost/";

    public DbManager(){

        try {
            Class.forName("org.hsqldb.jdbcDriver");

        connection = DriverManager.getConnection(url,"SA","");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
