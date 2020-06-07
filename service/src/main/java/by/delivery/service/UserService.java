package by.delivery.service;

import by.delivery.entity.User;

import java.util.List;

public interface UserService<T> {

    boolean saveUser(T user);

    boolean updateUser(Long id, T user);

    boolean deleteUser(Long id);

    T findUserById(Long id);

    List<User> findAllUsers();
}
