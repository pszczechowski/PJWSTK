package controllers;

import model.Actor;
import model.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ActorRestServiceController {
    private Map<Long, Actor> actors = DatabaseClass.getActors();

    void addActor(Actor actor){
        actor.setId(actors.size() + 1L);
        actors.put(actor.getId(),actor);
    }

    List<Actor> getAllActors(){
        return new ArrayList<>(actors.values());
    }

    List<Film> getAllFilmsFromPointedActor(Long id){
        return actors.get(id).getFilms();
    }

    void addFilmToActor(Long filmId, Long actorId){
        actors.get(actorId).getFilms().add(new FilmRestServiceController().getFilm(filmId));

    }

    Actor getActor(Long id){
        if(!actors.containsKey(id)) throw new IllegalArgumentException();
        return actors.get(id);
    }
}
