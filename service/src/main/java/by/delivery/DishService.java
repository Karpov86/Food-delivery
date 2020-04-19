package by.delivery;

public interface DishService<T> {

    boolean save(T dish);

    boolean update(Long id, T dish);

    boolean delete(Long id);

    T find(Long id);

}
