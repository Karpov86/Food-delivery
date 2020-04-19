package by.delivery;

public interface OrderService<T> {

    boolean save(T order);

    boolean update(Long id, T order);

    boolean delete(Long id);

    T find(Long id);

}
