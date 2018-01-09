package unityofwork;

import fields.Entity;

/**
 * Created by slawo on 17.11.2017.
 */
public interface IUnityOfWork {

    public void commit();
    public void rollback();
    public int markAsNew(Entity entity, IUnityOfWorkRepository repository);
    public void markAsDirty(Entity entity, IUnityOfWorkRepository repository);
    public void markAsDeleted(Entity entity, IUnityOfWorkRepository repository);
}
