package fields;


import java.time.Duration;
import java.time.LocalDate;

public class Episode implements DomainObject {
    private String episodeName;
    private LocalDate episodeReleaseDate;
    private int episodeNumber;
    private String episodeDuration;
    private int idSeason;
    private int id;

    public int getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(int idSeason) {
        this.idSeason = idSeason;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public LocalDate getEpisodeReleaseDate() {
        return episodeReleaseDate;
    }

    public void setEpisodeReleaseDate(LocalDate episodeReleaseDate) {
        this.episodeReleaseDate = episodeReleaseDate;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getEpisodeDuration() {
        return episodeDuration;
    }

    public void setEpisodeDuration(String episodeDuration) {
        this.episodeDuration = episodeDuration;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "episodeName='" + episodeName + '\'' +
                ", episodeReleaseDate=" + episodeReleaseDate +
                ", episodeNumber=" + episodeNumber +
                ", episodeDuration=" + episodeDuration +
                '}';
    }
}
