package by.delivery;

import by.delivery.config.ServiceConfig;
import by.delivery.entity.Address;
import by.delivery.entity.User;
import by.delivery.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService<User> userService;

    @Before
    public void initData() {
        final User user = new User.Builder()
                .setName("Bill")
                .setSurname("Black")
                .setEmail("some@email")
                .setPhoneNumber("+555-55-55")
                .build();
        userService.saveUser(user);
    }

    @Test
    public void saveUserServiceTest() {
        boolean isSave = userService.saveUser(new User.Builder().setName("bob")
                .setSurname("marley")
                .setPassword("111")
                .setHomeAddress(new Address("some city", "some street"))
                .build());
        assertTrue(isSave);
    }

    @Test
    @Transactional
    public void updateUserTest() {
        User user = new User.Builder()
                .setName("Bill")
                .setSurname("Black")
                .setEmail("some@email")
                .setPhoneNumber("+555-55-55")
                .build();
        boolean isUpdate = userService.updateUser(1L, user);
        assertTrue(isUpdate);
    }

    @Test
    @Transactional
    public void deleteUserTest() {
        boolean isDelete = userService.deleteUser(1L);
        assertTrue(isDelete);
    }

    @Test
    @Transactional
    public void findUserByIdTest() {
        String name = userService.findUserById(1L).getName();
        assertEquals("Bill", name);
    }

    @Test
    public void findAllUsersTest() {
        List<User> allUsers = userService.findAllUsers();
        assertTrue(!allUsers.isEmpty());
    }
}
