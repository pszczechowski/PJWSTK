import java.util.List;

public class Season {

    private int id;
    private int seasonNumber;
    private int yearOfrelease;
    private List<Episode> episodes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getYearOfrelease() {
        return yearOfrelease;
    }

    public void setYearOfrelease(int yearOfrelease) {
        this.yearOfrelease = yearOfrelease;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "Numer: " + seasonNumber + ", Rok Produkcji: " + yearOfrelease;
    }

}
