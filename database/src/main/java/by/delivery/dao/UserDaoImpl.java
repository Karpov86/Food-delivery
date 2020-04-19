package by.delivery.dao;

import by.delivery.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class UserDaoImpl implements UserDao<User> {

    private static UserDaoImpl INSTANCE;

    public static UserDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    public boolean save(User user) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        if (session.save(user) != null) {
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    public boolean update(Long id, User updateData) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, id);

        if (updateData.getPhoneNumber() != null) {
            user.setPhoneNumber(updateData.getPhoneNumber());
        }
        if (updateData.getName() != null) {
            user.setName(updateData.getName());
        }
        if (updateData.getSurname() != null) {
            user.setSurname(updateData.getSurname());
        }
        if (updateData.getEmail() != null) {
            user.setEmail(updateData.getEmail());
        }
        if (updateData.getPassword() != null) {
            user.setPassword(updateData.getPassword());
        }
        if (updateData.getHomeAddress() != null) {
            user.setHomeAddress(updateData.getHomeAddress());
        }
        if (updateData.getWorkAddress() != null) {
            user.setWorkAddress(updateData.getWorkAddress());
        }

        if (session.merge(user) != null) {
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {

        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, id);

        if (user != null) {
            session.delete(user);

            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    public User find(Long id) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();

        User user = session.get(User.class, id);

        session.close();
        return user;
    }
}
