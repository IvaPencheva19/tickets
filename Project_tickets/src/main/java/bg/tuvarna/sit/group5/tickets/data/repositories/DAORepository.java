package bg.tuvarna.sit.group5.tickets.data.repositories;

import java.util.List;


public interface DAORepository<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    T getById(int id);
    List<T> getAll();

}
