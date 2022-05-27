package com.mightyjava;
import com.mightyjava.domain.Role;
import com.mightyjava.service.IRoleService;
import com.mightyjava.service.IService;
import com.mightyjava.utils.ConstantUtils;
import org.junit.jupiter.api.Test;
import com.mightyjava.domain.User;
import com.mightyjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*; //вот это в предудыщий файл добавить
@SpringBootTest
public class UserServiceImplTest{
    @Autowired
    private IService<User> userService;

    @Autowired
    private IRoleService<Role> roleService;

    @Autowired
    private UserRepository userRepository;

//    @Test
//    public void findByIdtest() {
//            User user1 = new User();
//            user1.setEmail("test@user.com");
//            user1.setName("Test User");
//            user1.setMobile("9787456545");
//            user1.setRole(roleService.findByName(ConstantUtils.USER.toString()));
//            user1.setPassword(new BCryptPasswordEncoder().encode("testuser"));
//            userService.saveOrUpdate(user1);
//            User user2 = new User();
//            user2.setEmail("test@admin.com");
//            user2.setName("Test Admin");
//            user2.setMobile("9787456545");
//            user2.setRole(roleService.findByName(ConstantUtils.ADMIN.toString()));
//            user2.setPassword(new BCryptPasswordEncoder().encode("testadmin"));
//            userService.saveOrUpdate(user2);
//            Long id2 = user2.getId();
//            User user3 = userRepository.findByEmail("test@user.com");
//            //assertNotEquals(userRepository.findById(id1), userRepository.findById(id2));
//            //assertNotEquals(id1, 1);
//            //assertNotNull(user3);
//    }

    @Test
    public void findAllTest() {
        assertNotNull(userRepository.findAll());
    }

//    @Test
//    public void deleteByIdTest() {
//        User user1 = new User();
//        user1.setEmail("test@user.com");
//        user1.setName("Test User");
//        user1.setMobile("9787456545");
//        user1.setRole(roleService.findByName(ConstantUtils.USER.toString()));
//        user1.setPassword(new BCryptPasswordEncoder().encode("testuser"));
//        userService.saveOrUpdate(user1);
//        Optional<User> id1 = userRepository.findById((long) 1);
//        userRepository.deleteById((long) 1);
//        Optional<User> id2 = userRepository.findById((long) 2);
//        assertNotEquals(id1, id2);
//    }
//    //

    @Test
    public void saveOrUpdate() {
        User user1 = new User();
        user1.setEmail("test1@user.com");
        user1.setName("Test User");
        user1.setMobile("1111111111");
        user1.setRole(roleService.findByName(ConstantUtils.USER.toString()));
        user1.setPassword(new BCryptPasswordEncoder().encode("testuser"));
        userService.saveOrUpdate(user1);
        roleService.saveOrUpdate(new Role(ConstantUtils.ADMIN.toString()));
        User savedUser = userRepository.saveAndFlush(user1);
        userService.saveOrUpdate(user1);
        assertNotEquals(user1, savedUser);
    }
}
