package com.mightyjava.resource.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mightyjava.domain.Sale;
import com.mightyjava.service.IPageService;
import com.mightyjava.service.IService;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SaleResourceImpl.class})
@ExtendWith(SpringExtension.class)
class SaleResourceImplTest {
    @MockBean
    private IPageService<Sale> iPageService;

    @MockBean
    private IService<Sale> iService;

    @Autowired
    private SaleResourceImpl saleResourceImpl;

    @Test
    void testFindAll() {
        when(this.iPageService.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        ResponseEntity<Page<Sale>> actualFindAllResult = this.saleResourceImpl.findAll(10, 3, "Sort By", "Sort Dir");
        assertTrue(actualFindAllResult.hasBody());
        assertTrue(actualFindAllResult.getBody().toList().isEmpty());
        assertEquals(HttpStatus.OK, actualFindAllResult.getStatusCode());
        assertTrue(actualFindAllResult.getHeaders().isEmpty());
        verify(this.iPageService).findAll((org.springframework.data.domain.Pageable) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testFindAll2() {
        when(this.iPageService.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        this.saleResourceImpl.findAll(-1, 3, "Sort By", "Sort Dir");
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testFindAll3() {
        when(this.iPageService.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        this.saleResourceImpl.findAll(10, 3, "", "Sort Dir");
    }

    @Test
    void testFindAll4() {
        when(this.iPageService.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        ResponseEntity<Page<Sale>> actualFindAllResult = this.saleResourceImpl.findAll(10, 3, "Sort By", "asc");
        assertTrue(actualFindAllResult.hasBody());
        assertTrue(actualFindAllResult.getBody().toList().isEmpty());
        assertEquals(HttpStatus.OK, actualFindAllResult.getStatusCode());
        assertTrue(actualFindAllResult.getHeaders().isEmpty());
        verify(this.iPageService).findAll((org.springframework.data.domain.Pageable) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testFindAll5() {
        when(this.iPageService.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        this.saleResourceImpl.findAll(10, 3, "", "asc");
    }

    @Test
    void testFindAll6() {
        when(this.iPageService.findAll((org.springframework.data.domain.Pageable) any(), (String) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        ResponseEntity<Page<Sale>> actualFindAllResult = this.saleResourceImpl.findAll(null, "Search Text");
        assertTrue(actualFindAllResult.hasBody());
        assertTrue(actualFindAllResult.getBody().toList().isEmpty());
        assertEquals(HttpStatus.OK, actualFindAllResult.getStatusCode());
        assertTrue(actualFindAllResult.getHeaders().isEmpty());
        verify(this.iPageService).findAll((org.springframework.data.domain.Pageable) any(), (String) any());
    }


    @Test
    void testFindById() {
        Sale sale = new Sale();
        sale.setAuthor("JaneDoe");
        sale.setGenre("Genre");
        sale.setId(123L);
        sale.setIsbnNumber(10.0d);
        sale.setLanguage("en");
        sale.setPrice(10.0d);
        sale.setTitle("Dr");
        Optional<Sale> ofResult = Optional.of(sale);
        when(this.iService.findById((Long) any())).thenReturn(ofResult);
        ResponseEntity<Sale> actualFindByIdResult = this.saleResourceImpl.findById(123L);
        assertTrue(actualFindByIdResult.hasBody());
        assertTrue(actualFindByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindByIdResult.getStatusCode());
        verify(this.iService).findById((Long) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testFindById2() {
        when(this.iService.findById((Long) any())).thenReturn(Optional.empty());
        this.saleResourceImpl.findById(123L);
    }

    @Test
    void testSave() {
        Sale sale = new Sale();
        sale.setAuthor("JaneDoe");
        sale.setGenre("Genre");
        sale.setId(123L);
        sale.setIsbnNumber(10.0d);
        sale.setLanguage("en");
        sale.setPrice(10.0d);
        sale.setTitle("Dr");
        when(this.iService.saveOrUpdate((Sale) any())).thenReturn(sale);

        Sale sale1 = new Sale();
        sale1.setAuthor("JaneDoe");
        sale1.setGenre("Genre");
        sale1.setId(123L);
        sale1.setIsbnNumber(10.0d);
        sale1.setLanguage("en");
        sale1.setPrice(10.0d);
        sale1.setTitle("Dr");
        ResponseEntity<Sale> actualSaveResult = this.saleResourceImpl.save(sale1);
        assertTrue(actualSaveResult.hasBody());
        assertTrue(actualSaveResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CREATED, actualSaveResult.getStatusCode());
        verify(this.iService).saveOrUpdate((Sale) any());
    }

    @Test
    void testUpdate() {
        Sale sale = new Sale();
        sale.setAuthor("JaneDoe");
        sale.setGenre("Genre");
        sale.setId(123L);
        sale.setIsbnNumber(10.0d);
        sale.setLanguage("en");
        sale.setPrice(10.0d);
        sale.setTitle("Dr");
        when(this.iService.saveOrUpdate((Sale) any())).thenReturn(sale);

        Sale sale1 = new Sale();
        sale1.setAuthor("JaneDoe");
        sale1.setGenre("Genre");
        sale1.setId(123L);
        sale1.setIsbnNumber(10.0d);
        sale1.setLanguage("en");
        sale1.setPrice(10.0d);
        sale1.setTitle("Dr");
        ResponseEntity<Sale> actualUpdateResult = this.saleResourceImpl.update(sale1);
        assertTrue(actualUpdateResult.hasBody());
        assertTrue(actualUpdateResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateResult.getStatusCode());
        verify(this.iService).saveOrUpdate((Sale) any());
    }

    @Test
    void testDeleteById() {
        when(this.iService.deleteById((Long) any())).thenReturn("42");
        ResponseEntity<String> actualDeleteByIdResult = this.saleResourceImpl.deleteById(123L);
        assertEquals("42", actualDeleteByIdResult.getBody());
        assertEquals(HttpStatus.OK, actualDeleteByIdResult.getStatusCode());
        assertTrue(actualDeleteByIdResult.getHeaders().isEmpty());
        verify(this.iService).deleteById((Long) any());
    }
}

