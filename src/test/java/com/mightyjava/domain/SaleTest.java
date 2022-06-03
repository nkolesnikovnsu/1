package com.mightyjava.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SaleTest {
    @Test
    void testConstructor() {
        Sale actualSale = new Sale();
        actualSale.setAuthor("JaneDoe");
        actualSale.setGenre("Genre");
        actualSale.setId(123L);
        actualSale.setIsbnNumber(10.0d);
        actualSale.setLanguage("en");
        actualSale.setPrice(10.0d);
        actualSale.setTitle("Dr");
        assertEquals("JaneDoe", actualSale.getAuthor());
        assertNull(actualSale.getCoverPhotoURL());
        assertEquals("Genre", actualSale.getGenre());
        assertEquals(123L, actualSale.getId().longValue());
        assertEquals(10.0d, actualSale.getIsbnNumber().doubleValue());
        assertEquals("en", actualSale.getLanguage());
        assertEquals(10.0d, actualSale.getPrice().doubleValue());
        assertEquals("Dr", actualSale.getTitle());
    }
}

