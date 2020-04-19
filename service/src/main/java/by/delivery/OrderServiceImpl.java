package by.delivery;

import by.delivery.dao.OrderDaoImpl;
import by.delivery.entity.Order;

public class OrderServiceImpl implements OrderService<Order> {

    @Override
    public boolean save(Order order) {
        return OrderDaoImpl.getInstance().save(order);
    }

    @Override
    public boolean update(Long id, Order order) {
        return OrderDaoImpl.getInstance().update(id, order);
    }

    @Override
    public boolean delete(Long id) {
        return OrderDaoImpl.getInstance().delete(id);
    }

    @Override
    public Order find(Long id) {
        return OrderDaoImpl.getInstance().find(id);
    }

}
