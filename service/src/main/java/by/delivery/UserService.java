package by.delivery;

public interface UserService<T> {

    boolean save(T user);

    boolean update(Long id, T user);

    boolean delete(Long id);

    T find(Long id);
}
