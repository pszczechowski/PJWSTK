package model;

import java.util.ArrayList;
import java.util.List;

public class Actor {
    private Long id;
    private String actorName;
    private String actorLastName;
    private List<Film> films = new ArrayList<>();

    public Actor() {
    }

    public Actor(String actorName, String actorLastName) {
        this.actorName = actorName;
        this.actorLastName = actorLastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorLastName() {
        return actorLastName;
    }

    public void setActorLastName(String actorLastName) {
        this.actorLastName = actorLastName;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film){
        films.add(film);
    }

}
