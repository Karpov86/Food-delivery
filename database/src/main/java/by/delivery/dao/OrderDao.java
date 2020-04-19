package by.delivery.dao;

public interface OrderDao<T> {

    boolean save(T order);

    boolean update(Long id, T order);

    boolean delete(Long id);

    T find(Long id);
}
