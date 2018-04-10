package controllers;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    Connection connection = new DatabaseController().DatabaseConnection();

    public boolean addToDataBase(User u) {
        String query = "INSERT INTO USERS (LOGIN,PASSWORD,EMAIL,RIGHTS) VALUES (?,?,?,?)";

        if (isUserExistInDatabase(u.getLogin())) {
            return false;
        } else {

            try {
                PreparedStatement insertRecord = connection.prepareStatement(query);
                insertRecord.setString(1, u.getLogin());
                insertRecord.setString(2, u.getPassword());
                insertRecord.setString(3, u.getEmail());
                insertRecord.setString(4, u.getRights());
                insertRecord.executeUpdate();

                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    private ResultSet selectUserFromDatabase(String login) {
        ResultSet rs = null;
        String query = "SELECT * FROM USERS WHERE LOGIN = (?)";

        try {
            PreparedStatement select = connection.prepareStatement(query);
            select.setString(1, login);
            rs = select.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    private boolean isUserExistInDatabase(String login) {
        String query = "SELECT LOGIN FROM USERS WHERE LOGIN = (?)";
        boolean exist = true;
        try {
            PreparedStatement select = connection.prepareStatement(query);
            select.setString(1, login);

            ResultSet rs = select.executeQuery();
            rs.next();
            exist = rs.isFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exist;
    }

    public boolean isUserCorrectAuth(String login, String password) {
        ResultSet rs = selectUserFromDatabase(login);
        boolean isCorrect = false;

        try {
            rs.next();
            isCorrect = rs.getString("LOGIN").equals(login) & rs.getString("PASSWORD").equals(password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isCorrect;
    }

    public User getUserByName(String login) {
        ResultSet rs = selectUserFromDatabase(login);

        User u = new User();
        try {
            rs.next();
            u.setLogin(rs.getString("LOGIN"));
            u.setEmail(rs.getString("EMAIL"));
            u.setRights(rs.getString("RIGHTS"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM USERS";

        try {
            PreparedStatement select = connection.prepareStatement(query);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                if(rs.getString("LOGIN").equals("admin")) continue;
                User u = new User();
                u.setLogin(rs.getString("LOGIN"));
                u.setEmail(rs.getString("EMAIL"));
                u.setRights(rs.getString("RIGHTS"));
                users.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updatePrivileges(String user, String right) {
        String query = "UPDATE USERS SET (RIGHTS) = (?) WHERE LOGIN = ?";
        try {
            PreparedStatement update = connection.prepareStatement(query);
            update.setString(1, right);
            update.setString(2, user);
            update.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String user){
        String query = "DELETE FROM USERS WHERE LOGIN = ?";
        try {
            PreparedStatement delete = connection.prepareStatement(query);
            delete.setString(1,user);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
