import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public Season s;
    TvSeries tv = null;

    PreparedStatement getTvSeriesStatement;
    PreparedStatement getSeasonStatement;
    PreparedStatement getEpisodeStatement;
    PreparedStatement getDirectorStatement;
    PreparedStatement getActorStatement;

    public DataManager(Connection connection) {

     try {
        getTvSeriesStatement = connection.prepareStatement("SELECT * FROM TvSeries");
        getSeasonStatement = connection.prepareStatement("SELECT * FROM Season ");
        getEpisodeStatement = connection.prepareStatement("SELECT * FROM Episode");
        getDirectorStatement = connection.prepareStatement("SELECT * FROM Director");
        getActorStatement = connection.prepareStatement("SELECT * FROM Actor");
     }catch(SQLException e){
         e.printStackTrace();
     }

    }
    public void getSeasonName() {
        try {
            ResultSet rs = getTvSeriesStatement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("tvSeriesName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public TvSeries getTvSeriesInfo(int chose){
        try{
            ResultSet rs = getTvSeriesStatement.executeQuery();
            while(rs.next()){
                if((rs.getInt("id")) == chose){
                    tv = new TvSeries();
                    tv.setId(rs.getInt("id"));
                    tv.setName(rs.getString("tvSeriesName"));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return tv;
    }

    public TvSeries getSeasonInfo() {
        List<Season> seasons = new ArrayList<>();

        try {
            ResultSet rs = getSeasonStatement.executeQuery();
            while (rs.next()) {
                if((tv.getId()) == rs.getInt("idTvSeries")) {
                    s = new Season();
                    s.setSeasonNumber(rs.getInt("seasonNumber"));
                    s.setYearOfrelease(rs.getInt("seasonYearOfrelease"));
                    s.setId(rs.getInt("id"));
                    seasons.add(s);
                }
            }
            tv.setSeasons(seasons);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tv;
    }

    public Season getEpisodInfo(TvSeries tv) {
        List<Episode> episodes = new ArrayList<>();
        try {
            ResultSet rs = getEpisodeStatement.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < tv.getSeasons().size(); i++) {
                    if ((tv.getSeasons().get(i).getId()) == (rs.getInt("idSeason"))) {
                        Episode e = new Episode();
                        e.setName(rs.getString("episodeName"));
                        e.setReleaseDate(rs.getDate("episodeReleaseDate").toLocalDate());
                        e.setEpisodeNumber(rs.getInt("episodeNumber"));
                        e.setDuration(rs.getString("episodeDuration"));
                        episodes.add(e);
                    }
                }
            }
            s.setEpisodes(episodes);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return s;
    }

    public Director getDirectorInfo(int chose){
        Director d = null;
        try{
            ResultSet rs = getDirectorStatement.executeQuery();
            while(rs.next()){
                if(rs.getInt("idTvSeries") == chose) {
                    d = new Director();
                    d.setDirectorName(rs.getString("directorName"));
                    d.setDirectorDayOfBirth(rs.getDate("directorDayOfBirth").toLocalDate());
                    d.setDirectorBiography(rs.getString("directorBiography"));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return d;
    }

    public Actor getActirInfo(int chose){
        List<Actor> actors = new ArrayList<>();
        Actor a = null;
        try{
            ResultSet rs = getActorStatement.executeQuery();
            while(rs.next()) {
                if (rs.getInt("idTvSeries") == chose) {
                    a = new Actor();
                    a.setActorName(rs.getString("actorName"));
                    a.setActorDayOfBirth(rs.getDate("actorDayOfBirth").toLocalDate());
                    a.setActorBiography(rs.getString("actorBiography"));
                    actors.add(a);
                }
            }
            a.setActors(actors);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return a;

    }
}
