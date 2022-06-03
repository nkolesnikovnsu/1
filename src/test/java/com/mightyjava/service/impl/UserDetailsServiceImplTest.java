package com.mightyjava.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mightyjava.domain.Role;
import com.mightyjava.domain.User;
import com.mightyjava.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserDetailsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setMobile("Mobile");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRole(new Role());
        when(this.userRepository.findByEmail((String) any())).thenReturn(user);
        this.userDetailsServiceImpl.loadUserByUsername("jane.doe@example.org");
    }

    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        User user = mock(User.class);
        when(user.getRole()).thenReturn(new Role("Name"));
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getPassword()).thenReturn("iloveyou");
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setMobile((String) any());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setMobile("Mobile");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRole(new Role());
        when(this.userRepository.findByEmail((String) any())).thenReturn(user);
        UserDetails actualLoadUserByUsernameResult = this.userDetailsServiceImpl.loadUserByUsername("jane.doe@example.org");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepository).findByEmail((String) any());
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getPassword();
        verify(user).setEmail((String) any());
        verify(user).setId((Long) any());
        verify(user).setMobile((String) any());
        verify(user).setName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        User user = mock(User.class);
        when(user.getRole()).thenReturn(null);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getPassword()).thenReturn("iloveyou");
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setMobile((String) any());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setMobile("Mobile");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRole(new Role());
        when(this.userRepository.findByEmail((String) any())).thenReturn(user);
        this.userDetailsServiceImpl.loadUserByUsername("jane.doe@example.org");
    }

    @Test
    void testLoadUserByUsername4() throws UsernameNotFoundException {
        User user = mock(User.class);
        when(user.getRole()).thenReturn(new Role("admin"));
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getPassword()).thenReturn("iloveyou");
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setMobile((String) any());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setMobile("Mobile");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRole(new Role());
        when(this.userRepository.findByEmail((String) any())).thenReturn(user);
        UserDetails actualLoadUserByUsernameResult = this.userDetailsServiceImpl.loadUserByUsername("jane.doe@example.org");
        assertEquals(2, actualLoadUserByUsernameResult.getAuthorities().size());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepository).findByEmail((String) any());
        verify(user).getRole();
        verify(user).getEmail();
        verify(user).getPassword();
        verify(user).setEmail((String) any());
        verify(user).setId((Long) any());
        verify(user).setMobile((String) any());
        verify(user).setName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((Role) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername5() throws UsernameNotFoundException {
        User user = mock(User.class);
        when(user.getRole()).thenReturn(new Role("Name"));
        when(user.getEmail()).thenReturn(null);
        when(user.getPassword()).thenReturn("iloveyou");
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setMobile((String) any());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setMobile("Mobile");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRole(new Role());
        when(this.userRepository.findByEmail((String) any())).thenReturn(user);
        this.userDetailsServiceImpl.loadUserByUsername("jane.doe@example.org");
    }
}

