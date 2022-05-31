package com.mightyjava.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link User}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setId(Long)}
     *   <li>{@link User#setMobile(String)}
     *   <li>{@link User#setName(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setRole(Role)}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setId(123L);
        actualUser.setMobile("Mobile");
        actualUser.setName("Name");
        actualUser.setPassword("iloveyou");
        Role role = new Role();
        actualUser.setRole(role);
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals(123L, actualUser.getId().longValue());
        assertEquals("Mobile", actualUser.getMobile());
        assertEquals("Name", actualUser.getName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(role, actualUser.getRole());
    }
}

