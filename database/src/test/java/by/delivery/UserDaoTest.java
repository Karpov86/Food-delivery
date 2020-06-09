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
                .setPassword("111")
                .setEmail("some@email")
                .setPhoneNumber("+555-55-55")
                .setHomeAddress(new Address("Minsk", "some street"))
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

    @Test
    @Transactional
    public void testFindUserByNameAndPassword(){
        User user = userRepo.findUserByNameAndPassword("Bill", "111");
        assertNotNull(user);
        assertEquals("Bill 111", user.getName() + " " + user.getPassword());
    }

    @Test
    @Transactional
    public void testFindAllByPhoneNumber(){
        List<User> allByPhoneNumber = userRepo.findAllByPhoneNumber("+555-55-55");
        String phoneNumber = allByPhoneNumber.get(0).getPhoneNumber();
        assertEquals(1, allByPhoneNumber.size());
        assertEquals("+555-55-55", phoneNumber);
    }

    @Test
    @Transactional
    public void testFindAllByHomeAddressCity(){
        List<User> allByHomeAddressCity = userRepo.findAllByHomeAddressCity("Minsk");
        assertTrue(!allByHomeAddressCity.isEmpty());
        String city = allByHomeAddressCity.get(0).getHomeAddress().getCity();
        assertEquals("Minsk", city);
    }

    @Test
    @Transactional
    public void testFindAllByEmail(){
        List<User> allByEmail = userRepo.findAllByEmail("some@email");
        assertTrue(!allByEmail.isEmpty());
        String email = allByEmail.get(0).getEmail();
        assertEquals("some@email", email);
    }
}
