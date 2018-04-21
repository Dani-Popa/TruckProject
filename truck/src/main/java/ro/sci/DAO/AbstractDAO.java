package ro.sci.DAO;


import java.util.List;

public interface AbstractDAO<T> {
    List<T> getAll();

    T create(T c);

    T update(T c);
}
