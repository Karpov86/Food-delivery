package by.delivery.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        final Configuration cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
        final Session session = sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory() throws HibernateException {
        return sessionFactory;
    }
}
