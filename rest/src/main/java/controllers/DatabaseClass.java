package controllers;

import model.Actor;
import model.Film;

import java.util.HashMap;
import java.util.Map;

class DatabaseClass {
    private static Map<Long, Film> films = new HashMap<>();
    private static Map<Long, Actor> actors = new HashMap<>();

    static Map<Long, Film> getFilms(){
        return films;
    }
    static Map<Long, Actor> getActors() { return actors;}
}
