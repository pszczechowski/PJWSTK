package controllers;

import model.Actor;
import model.Comment;
import model.Film;
import model.Rate;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/films")
public class RestEndpointController {

    private FilmRestServiceController controller = new FilmRestServiceController();
    private ActorRestServiceController actorController = new ActorRestServiceController();


    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film getPointedFil(@PathParam("id") Long id){
        return controller.getFilm(id);
    }

    @POST
    @Path("/add/film")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Film addFilmToMap(Film film){
        controller.addFilm(film);
        return film;
    }

    @GET
    @Path("/get/films")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFilms(){
        List<Film> films = controller.getAllFilms();
        GenericEntity<List<Film>> genericEntity = new GenericEntity<List<Film>>(films){};
        return Response.ok(genericEntity).build();
    }

    @POST
    @Path("/add/{id}/comment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Film addCommentToFilm(Comment comment, @PathParam("id") Long id){
        controller.addComment(id,comment.getText());
        return controller.getFilm(id);
    }

    @DELETE
    @Path("/remove/{id}/comment/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film removeComment(@PathParam("id") Long id,@PathParam("commentId") Long commentId){
        controller.removeComment(id,commentId);
        return controller.getFilm(id);
    }

    @GET
    @Path("/get/{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCOmmentsForPointedFilm(@PathParam("id") Long id){
        List<Comment> comments = controller.getFilmComments(id);
        GenericEntity<List<Comment>> genericEntity = new GenericEntity<List<Comment>>(comments){};
        return Response.ok(genericEntity).build();
    }

    @PUT
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film changeFilmName(@PathParam("id") Long id, Film film){
        controller.updateFilmInfo(id,film.getFilmName());
        return controller.getFilm(id);
    }

    @POST
    @Path("/add/{id}/rate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Film addRateToFilm(@PathParam("id") Long id, Rate rate){
        controller.addRate(id,rate.getValue());
        return controller.getFilm(id);
    }

    @POST
    @Path("/add/actor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Actor addActor(Actor actor){
        actorController.addActor(actor);
        return actor;
    }

    @GET
    @Path("/get/actors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActors(){
        List<Actor> actors = actorController.getAllActors();
        GenericEntity<List<Actor>> genericEntity = new GenericEntity<List<Actor>>(actors){};
        return Response.ok(genericEntity).build();
    }

    @PUT
    @Path("/add/film/{filmId}/toActor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Actor addFilmToActor(@PathParam("id") Long actorId, @PathParam("filmId") Long filmId){
        actorController.addFilmToActor(filmId,actorId);
        return actorController.getActor(actorId);
    }

    @PUT
    @Path("add/actor/{actorId}/toFilm/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film addActorToFilm(@PathParam("actorId") Long actorId, @PathParam("id") Long id){
        controller.addActorToFilm(id,actorId);
        return controller.getFilm(id);
    }

    @GET
    @Path("/get/actorFilms/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFilmsFromPointedActor(@PathParam("id") Long id){
        List<Film> films = actorController.getAllFilmsFromPointedActor(id);
        GenericEntity<List<Film>> genericEntity = new GenericEntity<List<Film>>(films){};
        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/get/filmsActor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActorsFromPointedFilm(@PathParam("id") Long id){
        List<Actor> actors = controller.getAllActorsFromPointedFilm(id);
        GenericEntity<List<Actor>> genericEntity = new GenericEntity<List<Actor>>(actors){};
        return Response.ok(genericEntity).build();
    }
}
