package pl.edu.pjwstk.mpr.tvserials.Director;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DirectorManager {

    private Connection connection;
    private String url = "jdbc:hsqldb:hsql://localhost/";

    private String createTableDirectors = "CREATE TABLE Director(id bigint GENERATED BY DEFAULT AS IDENTITY, name varchar(20), dob integer, biography varchar(300))";

    private PreparedStatement addDirectorSt;
    private PreparedStatement deleteAllDirectorsSt;
    private PreparedStatement getAllDirectorsSt;

    private Statement statement;

    public DirectorManager(){
        try{
            Class.forName("org.hsqldb.jdbcDriver");

            connection = DriverManager.getConnection(url,"SA","");
            statement = connection.createStatement();

            ResultSet rs = connection.getMetaData().getTables(null,null,null,null);
            boolean tableExists = false;

            while(rs.next()) {
                if("Director".equalsIgnoreCase(rs.getString(3))){
                    tableExists = true;

                }
            }
            if(!tableExists){
                statement.executeUpdate(createTableDirectors);
            }


            addDirectorSt = connection.
                    prepareStatement("INSERT INTO Director (name, dob, biography) VALUES (?,?,?)");
            deleteAllDirectorsSt = connection.
                    prepareStatement("DROP TABLE Director");
            getAllDirectorsSt = connection.
                    prepareStatement("SELECT id, name, dob, biography FROM Director");

        }catch(Exception e){
            System.out.println("Error " + e);
        }
    }

    public void clearPersons(){
        try{
            deleteAllDirectorsSt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int addDirector(Director director){
        int count = 0;
        try{
            addDirectorSt.setString(1,director.getName());
            addDirectorSt.setInt(2,director.getDateOfBirth());
            addDirectorSt.setString(3,director.getBiography());

            count = addDirectorSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Director> getAllDirectors(){
        List<Director> directors = new ArrayList<Director>();

        try{
            ResultSet rs = getAllDirectorsSt.executeQuery();

            while(rs.next()){
                Director d = new Director();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setDateOfBirth(rs.getInt("dob"));
                d.setBiography(rs.getString("biography"));
                directors.add(d);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        for(Director director: directors){
            System.out.println(director);
        }
        return directors;
    }

}
