package by.delivery;

import by.delivery.dao.UserDaoImpl;
import by.delivery.entity.*;

import java.time.LocalDateTime;

public class Test {


    public static void main(String[] args) {

        User user = new User.Builder().setName("bob")
                .setSurname("marley")
                .setPassword("111")
                .setHomeAddress(new Address("some city", "some street"))
                .build();

        User user1 = new User.Builder().setName("Bill")
                .setEmail("email")
                .setPhoneNumber("+555-55-55")
                .build();

        Dish dish = new Dish.Builder()
                .setName("Margarita")
                .setPrice(5.15F)
                .setCategory(Category.PIZZA)
                .build();

        Order order = new Order.Builder().setDateTime(LocalDateTime.now())
                .setUser(user)
                .setDish(dish)
                .build();

        /*if (UserDaoImpl.getInstance().save(user)){
            System.out.println("Success");
        }*/
        /*if (UserDaoImpl.getInstance().update(4L, user1)){
            System.out.println("Success");
        }*/
        /*User user2 = UserDaoImpl.getInstance().find(1L);
        System.out.println(user2);*/
        //UserDaoImpl.getInstance().delete(1L);


       /* SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);
        session.save(dish);
        session.save(order);

        transaction.commit();
        session.close();*/

    }
}
