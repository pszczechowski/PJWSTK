package pl.edu.pjwstk.mpr.tvserials.Director;

import java.sql.Date;

public class Director {
    private int id;
    private String name;
    private int dateOfBirth;
    private String biography;


    public Director(int id, String name, int dateOfBirth, String biography) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.biography = biography;
    }

    public Director() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name + " Day of Birth: " + dateOfBirth + "  Biography: " +biography;
    }
}

