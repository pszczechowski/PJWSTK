package repo;

import fields.Entity;
import repoInterface.IRepository;
import unityofwork.IUnityOfWork;
import unityofwork.IUnityOfWorkRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Repository<TEntity extends Entity>
        implements IRepository<TEntity>, IUnityOfWorkRepository {

    protected IUnityOfWork uow;
    protected Connection connection;
    protected PreparedStatement selectByID;
    protected PreparedStatement insert;
    protected PreparedStatement delete;
    protected PreparedStatement update;

    protected abstract void setUpUpdateQuery(TEntity entity) throws SQLException;
    protected abstract void setUpInsertQuery(TEntity entity) throws SQLException;
    protected abstract String getTableName();
    protected abstract String getUpdateQuery();
    protected abstract String getInsertQuery();


    protected String selectByIDSql = "SELECT * FROM " + getTableName() + " WHERE id=?";
    protected String deleteSql = "DELETE FROM " + getTableName() + " WHERE id=?";

    protected Repository(Connection connection, IUnityOfWork uow){

        this.uow = uow;
        this.connection = connection;

        try{
            selectByID = connection.prepareStatement(selectByIDSql);
            insert = connection.prepareStatement(getInsertQuery());
            delete = connection.prepareStatement(deleteSql);
            update = connection.prepareStatement(getUpdateQuery());
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
    @Override
    public int add(TEntity entity){
        return uow.markAsNew(entity,this);
    }

    @Override
    public void update(TEntity entity){
        uow.markAsDirty(entity,this);
    }

    @Override
    public void remove(TEntity entity){
        uow.markAsDeleted(entity,this);
    }
    @Override
    public void persistAdd(Entity entity){
        try {
            setUpInsertQuery((TEntity) entity);
            insert.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void persistUpdate(Entity entity){
        try{
            setUpUpdateQuery((TEntity) entity);
            update.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void persistDelete(Entity entity){
        try{
            delete.setInt(1,entity.getId());
            delete.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public TEntity GetById(int id){
        ResultSet rs;
       try{
           selectByID.setInt(1,id);
           rs = selectByID.executeQuery();
        }catch(SQLException e){
           throw new RuntimeException(e);
       }
        return (TEntity)rs;
    }

}
