package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Film {
    private Long id;
    private String filmName;
    private Double avgRate;
    private List<Comment> comments = new ArrayList<>();
    private List<Rate> rating = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();

    public Film(Long id, String filmName) {
        this.id = id;
        this.filmName = filmName;
    }

    public Film() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Double getAvgRate() {
        if(rating.size() == 0) return 0.0;
        Double sum = 0.0;
        for(Rate r : rating){
            sum += r.getValue();
        }

        return sum/rating.size();
    }

    public void addComment(String comment){
        Long id = getComments().size()+1L;
        comments.add(new Comment(id,comment));
    }

    public void removeComment(Long id){
        Comment comment = new Comment();
        for(Comment c: comments){
            if (c.getId().equals(id)) comment = c;
        }
        comments.remove(comment);
    }


    public List<Comment> getComments(){
        return comments;
    }

    public List<Rate> getRating() {
        return rating;
    }

    public void addRate(Rate rate){
        rating.add(rate);
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor){
        actors.add(actor);
    }
}
