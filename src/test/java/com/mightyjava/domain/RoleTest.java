package com.mightyjava.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RoleTest {
    /**
     * Method under test: {@link Role#Role()}
     */
    @Test
    void testConstructor() {
        assertNull((new Role()).getName());
        assertEquals("Name", (new Role("Name")).getName());
    }
}

