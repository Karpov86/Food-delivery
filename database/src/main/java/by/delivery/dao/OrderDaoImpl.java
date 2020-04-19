package by.delivery.dao;

import by.delivery.entity.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDaoImpl implements OrderDao<Order> {

    private static OrderDaoImpl INSTANCE;

    public static OrderDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (OrderDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OrderDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    public boolean save(Order order) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        session.persist(order);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(Long id, Order updateData) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        Order order = session.get(Order.class, id);

        if (updateData.getLocalDate() != null) {
            order.setLocalDate(updateData.getLocalDate());
        }
        if (updateData.getUser() != null) {
            order.setUser(updateData.getUser());
        }
        if (updateData.getDish() != null) {
            order.setDish(updateData.getDish());
        }

        session.merge(order);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(Long id) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        Order order = session.get(Order.class, id);

        session.delete(order);

        transaction.commit();
        session.close();
        return true;
    }

    public Order find(Long id) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();

        Order order = session.get(Order.class, id);

        session.close();
        return order;
    }
}
