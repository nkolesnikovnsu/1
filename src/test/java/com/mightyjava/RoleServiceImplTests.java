package com.mightyjava.tests;

import com.mightyjava.domain.Role;
import com.mightyjava.service.impl.RoleServiceImpl;
import com.mightyjava.utils.ConstantUtils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class RoleServiceImplTests {
    private final RoleServiceImpl roleService = new RoleServiceImpl();

    @Test
    public void findByNameTest(){
        String name = "Boris";
        Role adminRole = new Role(ConstantUtils.ADMIN.toString());
        Role userRole =  new Role(ConstantUtils.USER.toString());

        assertEquals(roleService.findByName(name), adminRole);
        assertNotEquals(roleService.findByName(name), userRole);
    }

    @Test
    public void deleteByIdTest(){
        Long id = 1000L;
        String message = roleService.deleteById(id);

        assertEquals(message, "{\n\t\"message\": \"Book deleted successfully\"\n}");
    }
}