package repoInterface;

public interface IRepository<T> {

    T GetById(int id);
    int add(T entity);
    void remove(T entity);
    void update(T entity);

}
