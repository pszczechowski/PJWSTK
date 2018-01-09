package repo;


import fields.Episode;
import mapper.EpisodeMapper;
import repoInterface.IRepository;

import java.sql.Connection;

public class EpisodeRepository implements IRepository<Episode> {

    private Connection connection;
    private EpisodeMapper episodeMapper;

    public EpisodeRepository(Connection connection){
        this.connection = connection;
        this.episodeMapper= new EpisodeMapper(connection);
    }

    @Override
    public Episode GetById(int id) {
        return episodeMapper.find((long) id);
    }

    @Override
    public int add(Episode entity) {
        return episodeMapper.add(entity);
    }

    @Override
    public void remove(Episode entity) {
        episodeMapper.remove((long) entity.getId());
    }

    @Override
    public void update(Episode entity) {
        episodeMapper.update(entity);
    }
}
