package unityofwork;

import fields.Entity;
import fields.EntityState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;

@RunWith(MockitoJUnitRunner.class)
public class UnityOfWorkTest {

    @Mock
    IUnityOfWorkRepository repository;

    @Mock
    Connection connection;

    Entity entity;
    UnityOfWork uow;

    @Before
    public void setup(){
        entity = new Entity();
        uow = new UnityOfWork(connection);
    }


    @Test
    public void markAsNewCorrectArguments() throws Exception {
        uow.markAsNew(entity,repository);
        Assert.assertEquals(EntityState.New,entity.getState());
    }

    @Test (expected = NullPointerException.class)
    public void markAsNewNullPassed()throws Exception{
        uow.markAsNew(null,repository);
    }

    @Test
    public void markAsDirtyCorrectArguments() throws Exception {
        uow.markAsDirty(entity,repository);
        Assert.assertEquals(EntityState.Changed,entity.getState());
    }

    @Test (expected = NullPointerException.class)
    public void markAsDirtyNullPassed()throws Exception{
        uow.markAsDirty(null,repository);
    }

    @Test
    public void markAsDeletedCorrectArguments() throws Exception {
        uow.markAsDeleted(entity,repository);
        Assert.assertEquals(EntityState.Deleted,entity.getState());
    }

    @Test (expected = NullPointerException.class)
    public void markAsDeletedNullPassed()throws Exception{
        uow.markAsDeleted(null,repository);
    }

}