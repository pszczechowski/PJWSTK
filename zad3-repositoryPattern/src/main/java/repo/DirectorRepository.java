package repo;


import fields.Director;
import mapper.DirectorMapper;
import repoInterface.IRepository;

import java.sql.Connection;

public class DirectorRepository implements IRepository<Director> {

    private Connection connection;
    private DirectorMapper directorMapper;

    public DirectorRepository(Connection connection){
        this.connection = connection;
        this.directorMapper = new DirectorMapper(connection);
    }

    @Override
    public Director GetById(int id) {
        return directorMapper.find((long) id);
    }

    @Override
    public int add(Director entity) {
        return directorMapper.add(entity);
    }

    @Override
    public void remove(Director entity) {
        directorMapper.remove((long) entity.getId());
    }

    @Override
    public void update(Director entity) {
        directorMapper.update(entity);
    }
}
