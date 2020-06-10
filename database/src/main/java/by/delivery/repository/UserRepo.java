package by.delivery.repository;

import by.delivery.entity.Address;
import by.delivery.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    User findUserById(Long id);

    @Override
    List<User> findAll();

    User findUserByNameAndPassword(String name, String password);

}
