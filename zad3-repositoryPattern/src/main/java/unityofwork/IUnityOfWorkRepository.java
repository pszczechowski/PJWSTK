package unityofwork;


import fields.Entity;



    public interface IUnityOfWorkRepository{

    public void persistAdd(Entity entity);
    public void persistUpdate(Entity entity);
    public void persistDelete(Entity entity);

}
