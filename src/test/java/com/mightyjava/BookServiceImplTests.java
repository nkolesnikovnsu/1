package com.mightyjava.tests;

import com.mightyjava.service.impl.BookServiceImpl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class BookServiceImplTests {
    private final BookServiceImpl bookService = new BookServiceImpl();

    @Test
    public void findAllTest(){
        String searchText = "TEXT TO SEARCH, NE DOLZHEN NAJTI TAKOGO, ESLI NAJDET YA POVESHUS'";
        Pageable pageable = PageRequest.of(0, 5);

        assertEquals(bookService.findAll(pageable, searchText).isEmpty(), true);

        searchText = "РћРіСѓСЂРµС† Р·РµР»РµРЅС‹Р№";

        assertEquals(bookService.findAll(pageable, searchText).isEmpty(), false);
    }

    @Test
    public void deleteByIdTest(){
        Long id = 1000L;
        String message = bookService.deleteById(id);

        assertEquals(message, "{\n\t\"message\": \"Book deleted successfully\"\n}");
    }
}
