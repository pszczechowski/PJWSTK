package fields;

import java.util.List;

public class Season implements DomainObject {
    private int id;
    private int idTvSeries;
    private int seasonNumber;
    private int seasonYearOfRelease;
    private List<Episode> episodes;

    public int getIdTvSeries() {
        return idTvSeries;
    }

    public void setIdTvSeries(int idTvSeries) {
        this.idTvSeries = idTvSeries;
    }

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

    public int getSeasonYearOfRelease() {
        return seasonYearOfRelease;
    }

    public void setSeasonYearOfRelease(int seasonYearOfRelease) {
        this.seasonYearOfRelease = seasonYearOfRelease;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonNumber=" + seasonNumber +
                ", seasonYearOfRelease=" + seasonYearOfRelease +
                ", episodes=" + episodes +
                '}';
    }
}
