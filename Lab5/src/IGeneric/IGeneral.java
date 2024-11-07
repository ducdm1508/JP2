package IGeneric;

import java.util.Optional;

public interface IGeneral<T> {
    void add(T item);
    T getById(int id);
}
