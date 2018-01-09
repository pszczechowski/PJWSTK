package repo;

import fields.TvSeries;
import mapper.TvSeriesMapper;
import repoInterface.IRepository;

import java.sql.Connection;

public class TvSeriesRepository implements IRepository<TvSeries> {

    private Connection connection;
    private TvSeriesMapper tvSeriesMapper;

    public TvSeriesRepository(Connection connection){
        this.connection = connection;
        this.tvSeriesMapper = new TvSeriesMapper(connection);
    }

    public int add(TvSeries tv){
        return tvSeriesMapper.add(tv);
    }

    public void update(TvSeries tv){
        tvSeriesMapper.update(tv);
    }

    public void remove(TvSeries tv){
        tvSeriesMapper.remove((long) tv.getId());
    }

    public TvSeries GetById(int id){
        return tvSeriesMapper.find((long) id);
    }
}

