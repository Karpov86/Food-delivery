package by.delivery;

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


        /*final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        final Session session = sessionFactory.openSession();

        JPAQuery<User> query = new JPAQuery<>(session);
        QUser qUser = QUser.user;
        List<User> results = query.select(qUser).from(qUser).fetchResults().getResults();
        results.forEach(System.out::println);

        List<String> bill = query.select(qUser.phoneNumber).from(qUser).where(qUser.name.eq("Bill")).fetchResults().getResults();
        bill.forEach(System.out::println);*/

    }
}
