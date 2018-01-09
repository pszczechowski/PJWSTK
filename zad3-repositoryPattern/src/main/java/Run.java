import fields.Actor;
import fields.Director;
import fields.TvSeries;
import repo.ActorRepository;
import repo.DirectorRepository;
import repo.TvSeriesRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Run {

    public static void main(String[] args) {
        String url = "";
        String username = "";
        String password = "";


        try(Connection connection = DriverManager.getConnection(url,username,password)) {


            ActorRepository actor = new ActorRepository(connection);
            TvSeriesRepository tv = new TvSeriesRepository(connection);
            TvSeries tvSeries = new TvSeries();
            tvSeries.setName("asd");
            int key = tv.add(tvSeries);

            Actor a = new Actor();
            a.setActorName("asd");
            a.setActorDayOfBirth(dateInput("1993-01-01"));
            a.setActorBiography("asdasdasd");
            a.setIdTvSeries(key);
            actor.add(a);
            System.out.println(a);
            a.setActorName("dsa");
            a.setActorDayOfBirth(dateInput("1999-01-01"));
            a.setActorBiography("dsa");
            a.setIdTvSeries(key);
            actor.update(a);




        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static LocalDate dateInput(String userInput) {


        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate date = LocalDate.parse(userInput, dateFormat);
        return date ;
    }
}
