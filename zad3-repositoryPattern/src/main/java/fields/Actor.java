package fields;

import java.time.LocalDate;
import java.util.List;

public class Actor implements DomainObject {
    private int id;
    private String actorName;
    private LocalDate actorDayOfBirth;
    private String actorBiography;
    private int idTvSeries;
    private List<Actor> actors;

    public int getIdTvSeries() {
        return idTvSeries;
    }

    public void setIdTvSeries(int idTvSeries) {
        this.idTvSeries = idTvSeries;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public LocalDate getActorDayOfBirth() {
        return actorDayOfBirth;
    }

    public void setActorDayOfBirth(LocalDate actorDayOfBirth) {
        this.actorDayOfBirth = actorDayOfBirth;
    }

    public String getActorBiography() {
        return actorBiography;
    }

    public void setActorBiography(String actorBiography) {
        this.actorBiography = actorBiography;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorName='" + actorName + '\'' +
                ", actorDayOfBirth=" + actorDayOfBirth +
                ", actorBiography='" + actorBiography + '\'' +
                ", actors=" + actors +
                '}';
    }
}
