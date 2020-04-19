package by.delivery;

import by.delivery.dao.DishDaoImpl;
import by.delivery.dao.UserDaoImpl;
import by.delivery.entity.Dish;
import by.delivery.entity.User;

public class DishServiceImpl implements DishService<Dish> {

    @Override
    public boolean save(Dish dish) {
        return DishDaoImpl.getInstance().save(dish);
    }

    @Override
    public boolean update(Long id, Dish dish) {
        return DishDaoImpl.getInstance().update(id, dish);
    }

    @Override
    public boolean delete(Long id) {
        return DishDaoImpl.getInstance().delete(id);
    }

    @Override
    public Dish find(Long id) {
        return DishDaoImpl.getInstance().find(id);
    }

}
