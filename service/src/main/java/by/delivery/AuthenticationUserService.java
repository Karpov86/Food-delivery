package by.delivery;

import by.delivery.dao.UserDaoImpl;

public class AuthenticationUserService {

    public boolean authentication(String name, String surname) {

        return UserDaoImpl.getInstance().authentication(name, surname);
    }
}
