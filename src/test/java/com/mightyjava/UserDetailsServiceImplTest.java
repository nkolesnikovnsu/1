//package com.mightyjava;
//import com.mightyjava.utils.ConstantUtils;
//import org.junit.jupiter.api.Test;
//import com.mightyjava.domain.User;
//import com.mightyjava.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.mightyjava.domain.User;
//import com.mightyjava.repository.UserRepository;
//import java.util.ArrayList;
//import java.util.Collection;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class UserDetailsServiceImplTest {
//    @Autowired
//    UserRepository userRepository;
//
//
//    @Test
//    public void loadUserByUsernameTest() {
//        String email = "v.pupkin@gmail.com";
//        User user = userRepository.findByEmail(email);
//        assertEquals(new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
//                getGrantedAuthorityTest(user)));
//    }
//
////    private Collection<GrantedAuthority> getGrantedAuthority(User user) {
////        Collection<GrantedAuthority> authorities = new ArrayList<>();
////        if (user.getRole().getName().equalsIgnoreCase("admin")) {
////            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
////        }
////        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
////        return authorities;
////    }
//    @Test
//    public Collection<GrantedAuthority> getGrantedAuthorityTest(User user) {
//        User user2 = new User();
//        user2.setEmail("test2@admin.com");
//        user2.setName("Test Admin");
//        user2.setMobile("1111111111");
//        user2.setRole(roleService.findByName(ConstantUtils.ADMIN.toString()));
//        user2.setPassword(new BCryptPasswordEncoder().encode("testadmin"));
//        userService.saveOrUpdate(user2);
//
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        if (user2.getRole().getName().equalsIgnoreCase("admin")) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        }
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//
//        assertNotNull(authorities);
//    }
//}
