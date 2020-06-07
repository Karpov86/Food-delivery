package by.delivery.service;

import by.delivery.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUserService {

    @Autowired
    UserRepo userRepo;

    public boolean authentication(String name, String password) {
        return userRepo.findUserByNameAndPassword(name, password) != null;
    }
}
