package repo;


import fields.Season;
import mapper.SeasonMapper;
import repoInterface.IRepository;

import java.sql.Connection;

public class SeasonRepository implements IRepository<Season> {

    private Connection connection;
    private SeasonMapper seasonMapper;

    public SeasonRepository(Connection connection){
        this.connection = connection;
        this.seasonMapper = new SeasonMapper(connection);
    }


    @Override
    public Season GetById(int id) {
        return seasonMapper.find((long) id);
    }

    @Override
    public int add(Season entity) {
        return seasonMapper.add(entity);
    }

    @Override
    public void remove(Season entity) {
        seasonMapper.remove((long) entity.getId());
    }

    @Override
    public void update(Season entity) {
        seasonMapper.update(entity);
    }
}
