package com.mightyjava.resource.impl;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mightyjava.config.JwtTokenProvider;
import com.mightyjava.domain.Role;
import com.mightyjava.domain.User;
import com.mightyjava.repository.RoleRepository;
import com.mightyjava.repository.UserRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserResourceImpl.class})
@ExtendWith(SpringExtension.class)
class UserResourceImplTest {
    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserResourceImpl userResourceImpl;

    @Test
    void testAuthenticate() throws Exception {
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setMobile("Mobile");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRole(new Role());
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userResourceImpl)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testAuthenticate2() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setMobile("Mobile");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRole(new Role());
        when(this.userRepository.findByEmail((String) any())).thenReturn(user);
        when(this.jwtTokenProvider.createToken((String) any(), (Role) any())).thenReturn("ABC123");

        ArrayList<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("?"));
        RunAsUserToken runAsUserToken = new RunAsUserToken("?", "Principal", "Credentials", grantedAuthorityList,
                Authentication.class);
        when(this.authenticationManager.authenticate((Authentication) any())).thenReturn(runAsUserToken);
        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setMobile("Mobile");
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRole(new Role());
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userResourceImpl)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"name\":\"Principal\",\"authorities\":[\"?\"],\"token\":\"ABC123\"}"));
    }

    @Test
    void testRegister() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setMobile("Mobile");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRole(new Role());
        when(this.userRepository.saveAndFlush((User) any())).thenReturn(user);
        when(this.roleRepository.findByName((String) any())).thenReturn(new Role());

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setMobile("Mobile");
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRole(new Role());
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userResourceImpl)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Name saved succesfully\"}"));
    }
}

