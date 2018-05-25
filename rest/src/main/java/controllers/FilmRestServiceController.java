package controllers;

import model.Actor;
import model.Comment;
import model.Film;
import model.Rate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilmRestServiceController {
    private Map<Long, Film> films = DatabaseClass.getFilms();

    void addFilm(Film film){
        film.setId(films.size() + 1L);
        films.put(film.getId(),film);
    }


    Film getFilm(Long id){
        if(!films.containsKey(id)) throw new IllegalArgumentException();
        return films.get(id);
    }


    List<Film> getAllFilms(){
        return new ArrayList<>(films.values());
    }

    void updateFilmInfo(Long filmToUpdateId, String newName){
        if(!films.containsKey(filmToUpdateId)) throw new IllegalArgumentException();
        films.get(filmToUpdateId).setFilmName(newName);
    }

    List<Comment> getFilmComments(Long id){
        if(!films.containsKey(id)) throw new IllegalArgumentException();
        return films.get(id).getComments();
    }

    void removeComment(Long id, Long commentId){
        if(!films.containsKey(id)) throw new IllegalArgumentException();
        films.get(id).removeComment(commentId);
    }

    void addComment(Long id, String comment){
        if(!films.containsKey(id)) throw new IllegalArgumentException();
        films.get(id).addComment(comment);
    }

    void addRate(Long id, double rate){
        if(!films.containsKey(id)) throw new IllegalArgumentException();
        films.get(id).addRate(new Rate(rate));
    }

    void addActorToFilm(Long id,Long actorId){
        if(!films.containsKey(id)) throw new IllegalArgumentException();
        films.get(id).addActor(new ActorRestServiceController().getActor(actorId));
    }

    List<Actor> getAllActorsFromPointedFilm(Long id){
        return films.get(id).getActors();
    }
}
