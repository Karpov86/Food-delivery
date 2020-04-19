package by.delivery.dao;

import by.delivery.entity.Dish;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DishDaoImpl implements DishDao<Dish> {

    private static DishDaoImpl INSTANCE;

    public static DishDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (DishDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DishDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    public boolean save(Dish dish) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        session.persist(dish);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(Long id, Dish updateData) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        Dish dish = session.get(Dish.class, id);

        if (updateData.getPrice() != null) {
            dish.setPrice(updateData.getPrice());
        }
        if (updateData.getIsSale() != null) {
            dish.setIsSale(updateData.getIsSale());
        }
        if (updateData.getName() != null) {
            dish.setName(updateData.getName());
        }
        if (updateData.getName() != null) {
            dish.setName(updateData.getName());
        }
        if (updateData.getCategory() != null) {
            dish.setCategory(updateData.getCategory());
        }
        if (updateData.getOrders() != null) {
            dish.setOrders(updateData.getOrders());
        }

        session.merge(dish);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Dish find(Long id) {
        return null;
    }
}
