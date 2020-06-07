package by.delivery;

import by.delivery.config.DataConfig;
import by.delivery.entity.Address;
import by.delivery.entity.User;
import by.delivery.repository.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class UserDaoTest {

    @Autowired
    private UserRepo userRepo;

    @Before
    public void initData() {
        final User user = new User.Builder()
                .setId(1L)
                .setName("Bill")
                .setSurname("Black")
                .setEmail("some@email")
                .setPhoneNumber("+555-55-55")
                .build();
        userRepo.save(user);
    }

    @Test
    @Transactional
    public void testSave() {
        User user = new User();
        user.setName("Bob");
        user.setSurname("Marley");
        User saveUser = userRepo.save(user);
        String fullName = saveUser.getName() + " " + saveUser.getSurname();
        assertEquals("Bob Marley",fullName);
    }

    @Test
    @Transactional
    public void testDelete() {
        User user = new User.Builder()
                .setName("Bill")
                .setSurname("Black")
                .setEmail("some@email")
                .setPhoneNumber("+555-55-55")
                .build();
        userRepo.save(user);
        userRepo.delete(user);
    }

    @Test
    @Transactional
    public void testFindById() {
        User user = userRepo.findUserById(1L);
        
        assertEquals("Bill", user.getName());
    }

    @Test
    @Transactional
    public void testDeleteById(){
        userRepo.deleteById(1L);
        assertEquals(0, userRepo.findAll().size());
    }

    @Test
    @Transactional
    public void testFindAll(){
        List<User> allUsers = userRepo.findAll();
        assertTrue(!allUsers.isEmpty());
        assertEquals(1, allUsers.size());
    }

    @Test
    @Transactional
    public void testUpdate(){
        User user = userRepo.findById(1L).get();
        user.setName("Jack");
        userRepo.save(user);
        String name = userRepo.findById(1L).get().getName();
        assertEquals("Jack", name);
    }
}
