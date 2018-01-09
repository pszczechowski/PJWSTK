package fields;

import java.time.LocalDate;

public class Director implements DomainObject {
    private int id;
    private String directorName;
    private LocalDate directorDayOfBirth;
    private String directorBiography;
    private int idTvSeries;

    public Director(int id, String directorName, LocalDate directorDayOfBirth, String directorBiography, int idTvSeries) {
        this.id = id;
        this.directorName = directorName;
        this.directorDayOfBirth = directorDayOfBirth;
        this.directorBiography = directorBiography;
        this.idTvSeries = idTvSeries;
    }

    public Director() {
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public LocalDate getDirectorDayOfBirth() {
        return directorDayOfBirth;
    }

    public void setDirectorDayOfBirth(LocalDate directorDayOfBirth) {
        this.directorDayOfBirth = directorDayOfBirth;
    }

    public String getDirectorBiography() {
        return directorBiography;
    }

    public void setDirectorBiography(String directorBiography) {
        this.directorBiography = directorBiography;
    }

    public int getIdTvSeries() {
        return idTvSeries;
    }

    public void setIdTvSeries(int idTvSeries) {
        this.idTvSeries = idTvSeries;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", directorName='" + directorName + '\'' +
                ", directorDayOfBirth=" + directorDayOfBirth +
                ", directorBiography='" + directorBiography + '\'' +
                ", idTvSeries=" + idTvSeries +
                '}';
    }
}
