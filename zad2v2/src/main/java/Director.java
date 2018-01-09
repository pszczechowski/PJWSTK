import java.time.LocalDate;

public class Director {
    private String directorName;
    private LocalDate directorDayOfBirth;
    private String directorBiography;
    private int idTvSeries;

    public int getIdTvSeries() {
        return idTvSeries;
    }

    public void setIdTvSeries(int idTvSeries) {
        this.idTvSeries = idTvSeries;
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

    @Override
    public String toString() {
        return "Reżyser: " + directorName + '\'' +
                ", Data urodzenie: " + directorDayOfBirth +
                ", Biografia: " + directorBiography;
    }
}
