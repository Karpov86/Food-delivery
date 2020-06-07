package by.delivery.service;

import by.delivery.entity.User;
import by.delivery.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService<User> {

    @Autowired
    UserRepo userRepo;

    @Override
    public boolean saveUser(User user) {
        userRepo.save(user);
        return true;
    }

    @Override
    public boolean updateUser(Long id, User user) {
        user.setId(id);
        return userRepo.save(user) != null;
    }

    @Override
    public boolean deleteUser(Long id) {
        userRepo.deleteById(id);
        return true;
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findUserById(id);

    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }
}
