package unityofwork;

import fields.Entity;

/**
 * Created by piotr
 */
public interface IUnityOfWork {

    public void commit();
    public void rollback();
    public int markAsNew(Entity entity, IUnityOfWorkRepository repository);
    public void markAsDirty(Entity entity, IUnityOfWorkRepository repository);
    public void markAsDeleted(Entity entity, IUnityOfWorkRepository repository);
}
