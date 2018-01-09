package fields;


import java.util.List;

public class TvSeries implements DomainObject {
    private int id;
    private String name;
    private List<Season> seasons;

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

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    @Override
    public String toString() {
        return "TvSeries{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seasons=" + seasons +
                '}';
    }
}
