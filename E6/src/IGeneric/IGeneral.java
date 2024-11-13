package IGeneric;

import java.util.List;

public interface IGeneral <T> {
    void add(T t);
    void update(T t);
    List<T> getByName(String name);
    T getById(int id);
    void delete(T t);
}
