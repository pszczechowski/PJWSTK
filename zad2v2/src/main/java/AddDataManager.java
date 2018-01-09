import javax.xml.crypto.Data;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddDataManager {

    Scanner sc = new Scanner(System.in);
    TvSeries tv = new TvSeries();
    Director d = new Director();
    Season s;


    private PreparedStatement addTvSeriesStatement;
    private PreparedStatement addDirectorStatement;
    private PreparedStatement getTVseriesID;
    private PreparedStatement addActorStatement;
    private PreparedStatement addSeasonStatement;
    private PreparedStatement getSeasonId;
    private PreparedStatement addEpisodeStatement;

    public AddDataManager(Connection con){
        try{
            addTvSeriesStatement = con.
                    prepareStatement("INSERT INTO TvSeries(tvSeriesName) VALUE(?)");
            addDirectorStatement = con.
                    prepareStatement("INSERT INTO Director(directorName, directorDayOfBirth,directorBiography,idTvSeries) VALUE(?,?,?,?)");
            getTVseriesID = con.
                    prepareStatement("SELECT id FROM TvSeries");
            getSeasonId = con.
                    prepareStatement("SELECT id FROM Season");
            addActorStatement = con.
                    prepareStatement("INSERT INTO Actor(actorName,actorDayOfBirth,actorBiography,idTvSeries) VALUE (?,?,?,?)");
            addSeasonStatement = con.
                    prepareStatement("INSERT INTO Season(seasonNumber,seasonYearOfRelease,idTvSeries) VALUE (?,?,?)");
            addEpisodeStatement = con.
                    prepareStatement("INSERT INTO Episode(episodeName,episodeReleaseDate,episodeNumber,episodeDuration,idSeason) VALUE (?,?,?,?,?)");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }



    public void addTvSeries(){
        System.out.println("Podaj nazwę serialu który chcesz dodać");
        tv.setName(sc.nextLine());
        try {
            addTvSeriesStatement.setString(1, tv.getName());
            addTvSeriesStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void addDirecotr(DataManager db){
        System.out.println("Podaj dane reżysera");
        System.out.println("Imię i nazwisko");
        d.setDirectorName(sc.nextLine());
        System.out.println("Data urodzenia (RRRR-MM-DD)");
        d.setDirectorDayOfBirth(dateInput(sc.nextLine()));
        System.out.println("Biografia reżysera");
        d.setDirectorBiography(sc.nextLine());

        try {
            ResultSet rs = getTVseriesID.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                if(rs.getInt("id") >= id){
                    d.setIdTvSeries(rs.getInt("id"));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        try {
            addDirectorStatement.setString(1, d.getDirectorName());
            Date date = Date.valueOf(d.getDirectorDayOfBirth());
            addDirectorStatement.setDate(2,date);
            addDirectorStatement.setString(3,d.getDirectorBiography());
            addDirectorStatement.setInt(4,d.getIdTvSeries());
            addDirectorStatement.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static LocalDate dateInput(String userInput) {


        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate date = LocalDate.parse(userInput, dateFormat);
        return date ;
    }

    public void addActor(){
        System.out.println("Podaj ilu aktorów chcesz dodać");
        int count = sc.nextInt();
        sc.nextLine();
        int actorNumber = 0;
        while(count > 0){
            count--;
            actorNumber++;
            Actor a = new Actor();
            System.out.println("Podaj dane o aktorze nr. "+actorNumber);
            System.out.println("Imię i Nazwisko");
            a.setActorName(sc.nextLine());
            System.out.println("Data Urodzenia (RRRR-MM-DD");
            a.setActorDayOfBirth(dateInput(sc.nextLine()));
            System.out.println("Biografia");
            a.setActorBiography(sc.nextLine());

            try {
                addActorStatement.setString(1, a.getActorName());
                Date date = Date.valueOf(a.getActorDayOfBirth());
                addActorStatement.setDate(2,date);
                addActorStatement.setString(3,a.getActorBiography());
                addActorStatement.setInt(4,d.getIdTvSeries());

                addActorStatement.executeUpdate();

            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    public void addSeason(){
        System.out.println("Ile sezonów chesz dodać ?");
        int count=0;
        count = sc.nextInt();
        sc.nextLine();
        int seasonNumber=0;
        while(count > 0){
            count--;
            seasonNumber++;
            System.out.println("Podaj dane o sezonie nr. " +seasonNumber);
            s = new Season();
            System.out.println("Number sezozu");
            s.setSeasonNumber(sc.nextInt());
            System.out.println("Rok publikacji");
            s.setYearOfrelease(sc.nextInt());

            try{
                addSeasonStatement.setInt(1,s.getSeasonNumber());
                addSeasonStatement.setInt(2,s.getYearOfrelease());
                addSeasonStatement.setInt(3,d.getIdTvSeries());

                addSeasonStatement.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
                addEpisode();
            }
       }
       public void addEpisode(){
           System.out.println("Podaj dane epizodów dodanego sezonu");
           int episodeNumber;
           int number = 0;
           System.out.println("Ile epizodów chcesz dodać?");
           episodeNumber = sc.nextInt();
           sc.nextLine();
           while(episodeNumber > 0){
               episodeNumber--;
               number++;
               Episode e = new Episode();
               System.out.println("Podaj dane o epizodzie nr. " +number);
               System.out.println("Nazwa");
               e.setName(sc.nextLine());
               System.out.println("Data publikacji (RRRR-MM-DD");
               e.setReleaseDate(dateInput(sc.nextLine()));
               System.out.println("Numer");
               e.setEpisodeNumber(sc.nextInt());
               sc.nextLine();
               System.out.println("Czas trwania (H:MM)");
               e.setDuration(sc.nextLine());

               try {
                   ResultSet rs = getSeasonId.executeQuery();
                   while(rs.next()) {
                       int id = rs.getInt("id");
                       if(rs.getInt("id") >= id){
                           s.setId(rs.getInt("id"));
                       }
                   }

                   addEpisodeStatement.setString(1,e.getName());
                   Date date = Date.valueOf(e.getReleaseDate());
                   addEpisodeStatement.setDate(2,date);
                   addEpisodeStatement.setInt(3,e.getEpisodeNumber());
                   String duration = e.getDuration().toString();
                   addEpisodeStatement.setString(4,duration);
                   addEpisodeStatement.setInt(5,s.getId());

                   addEpisodeStatement.executeUpdate();


               }catch(SQLException g){
                   g.printStackTrace();
               }


               }
    }


}
