package bg.tuvarna.sit.group5.tickets.data.repositories;

import java.util.List;
import java.util.Optional;

public interface DAORepository<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    List<T>getById(Long id);
    List<T> getAll();

}
