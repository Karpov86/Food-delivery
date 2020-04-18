package by.delivery;

import by.delivery.dao.HibernateUtil;
import by.delivery.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class Test {


    public static void main(String[] args) {

        User user = new User.Builder().setName("bob")
                .setSurname("marley")
                .setPassword("111")
                .setHomeAddress(new Address("some city", "some street"))
                .build();
        Dish dish = new Dish.Builder()
                .setName("Margarita")
                .setPrice(5.15F)
                .setCategory(Category.PIZZA)
                .build();

        Order order = new Order.Builder().setDateTime(LocalDate.now())
                .setUser(user)
                .setDish(dish)
                .build();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);
        session.save(dish);
        session.save(order);

        transaction.commit();
        session.close();

    }
}
