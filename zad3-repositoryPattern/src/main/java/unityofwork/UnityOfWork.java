package unityofwork;


import fields.Entity;
import fields.EntityState;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class UnityOfWork implements IUnityOfWork {

    private Connection connection;

    private Map<Entity, IUnityOfWorkRepository> entities =
            new LinkedHashMap<>();

    public UnityOfWork(Connection connection){
        super();
        this.connection = connection;
        try{
            connection.setAutoCommit(false);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public void commit() {
        for(Entity entity: entities.keySet()){
            switch (entity.getState()){

                    case Changed:
                    entities.get(entity).persistUpdate(entity);
                    break;
                case Deleted:
                    entities.get(entity).persistDelete(entity);
                    break;
                case New:
                    entities.get(entity).persistAdd(entity);
                    break;
                case Unchanged:
                    break;
                default:
                    break;
            }
            try{
                connection.commit();
                entities.clear();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void rollback() {
        entities.clear();
    }

    @Override
    public int markAsNew(Entity entity, IUnityOfWorkRepository repository) {
        entity.setState(EntityState.New);
        entities.put(entity,repository);
        return 0;
    }

    @Override
    public void markAsDirty(Entity entity, IUnityOfWorkRepository repository) {
        entity.setState(EntityState.Changed);
        entities.put(entity,repository);
    }

    @Override
    public void markAsDeleted(Entity entity, IUnityOfWorkRepository repository) {
        entity.setState(EntityState.Deleted);
        entities.put(entity,repository);
    }
}
