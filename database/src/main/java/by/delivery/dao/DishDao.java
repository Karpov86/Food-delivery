package by.delivery.dao;

public interface DishDao <T> {

    boolean save(T dish);

    boolean update(Long id, T dish);

    boolean delete(Long id);

    T find(Long id);

}
