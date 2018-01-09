import java.sql.*;

public class DBManager {

    Connection connection;

    String url = "";
    String username = "";
    String password = "";

    public Connection establishConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }







}

