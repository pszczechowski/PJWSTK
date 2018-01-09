package repo;

import fields.Actor;
import mapper.ActorMapper;
import repoInterface.IRepository;

import java.sql.Connection;

public class ActorRepository implements IRepository<Actor> {

    private Connection connection;
    private ActorMapper actorMapper;

    public ActorRepository(Connection connection){
        this.connection = connection;
        this.actorMapper = new ActorMapper(connection);
    }

    @Override
    public Actor GetById(int id) {
        return actorMapper.find((long) id);
    }

    @Override
    public int add(Actor entity) {
        return actorMapper.add(entity);
    }

    @Override
    public void remove(Actor entity) {
        actorMapper.remove((long) entity.getId());
    }

    @Override
    public void update(Actor entity) {
        actorMapper.update(entity);
    }
}
