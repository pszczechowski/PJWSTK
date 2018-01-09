import java.time.Duration;
import java.time.LocalDate;

public class Episode {
    private String name;
    private LocalDate releaseDate;
    private int episodeNumber;
    private String duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Nazwa: " + name + ", Data Produkcji: " + releaseDate + ", Numer Odcinka: " + episodeNumber + ", czas trwania: " + duration;
    }
}
