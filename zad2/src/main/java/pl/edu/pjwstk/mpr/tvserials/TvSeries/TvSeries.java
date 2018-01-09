package pl.edu.pjwstk.mpr.tvserials.TvSeries;

import pl.edu.pjwstk.mpr.tvserials.Season;

import java.util.List;

public class TvSeries {
    private String name;
    private List<Season> seasons;

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
}
