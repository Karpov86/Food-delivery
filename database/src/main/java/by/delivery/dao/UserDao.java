package by.delivery.dao;

public interface UserDao <T> {

    boolean save(T user);

    boolean update(Long id, T user);

    boolean delete(Long id);

    T find(Long id);
}
