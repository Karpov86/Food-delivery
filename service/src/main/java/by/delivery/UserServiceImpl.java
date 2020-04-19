package by.delivery;

import by.delivery.dao.UserDaoImpl;
import by.delivery.entity.User;

public class UserServiceImpl implements UserService<User> {
    @Override
    public boolean save(User user) {
        return UserDaoImpl.getInstance().save(user);
    }

    @Override
    public boolean update(Long id, User user) {
        return UserDaoImpl.getInstance().update(id, user);
    }

    @Override
    public boolean delete(Long id) {
        return UserDaoImpl.getInstance().delete(id);
    }

    @Override
    public User find(Long id) {
        return UserDaoImpl.getInstance().find(id);
    }
}
