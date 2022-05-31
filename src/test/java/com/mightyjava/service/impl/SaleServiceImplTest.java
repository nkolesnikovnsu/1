package com.mightyjava.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mightyjava.domain.Sale;
import com.mightyjava.repository.SaleRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SaleServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SaleServiceImplTest {
    @MockBean
    private SaleRepository saleRepository;

    @Autowired
    private SaleServiceImpl saleServiceImpl;

    /**
     * Method under test: {@link SaleServiceImpl#findAll()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindAll() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.mightyjava.repository.SaleRepository.findAll()" because "this.saleRepository" is null
        //       at com.mightyjava.service.impl.SaleServiceImpl.findAll(SaleServiceImpl.java:26)
        //   In order to prevent findAll()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findAll().
        //   See https://diff.blue/R013 to resolve this issue.

        (new SaleServiceImpl()).findAll();
    }

    /**
     * Method under test: {@link SaleServiceImpl#findAll(org.springframework.data.domain.Pageable)}
     */
    @Test
    void testFindAll2() {
        PageImpl<Sale> pageImpl = new PageImpl<>(new ArrayList<>());
        when(this.saleRepository.findAll((org.springframework.data.domain.Pageable) any())).thenReturn(pageImpl);
        Page<Sale> actualFindAllResult = this.saleServiceImpl.findAll(null);
        assertSame(pageImpl, actualFindAllResult);
        assertTrue(actualFindAllResult.toList().isEmpty());
        verify(this.saleRepository).findAll((org.springframework.data.domain.Pageable) any());
    }

    /**
     * Method under test: {@link SaleServiceImpl#findAll(org.springframework.data.domain.Pageable, String)}
     */
    @Test
    void testFindAll3() {
        PageImpl<Sale> pageImpl = new PageImpl<>(new ArrayList<>());
        when(this.saleRepository.findAllBooks((org.springframework.data.domain.Pageable) any(), (String) any()))
                .thenReturn(pageImpl);
        Page<Sale> actualFindAllResult = this.saleServiceImpl.findAll(null, "Search Text");
        assertSame(pageImpl, actualFindAllResult);
        assertTrue(actualFindAllResult.toList().isEmpty());
        verify(this.saleRepository).findAllBooks((org.springframework.data.domain.Pageable) any(), (String) any());
    }

    /**
     * Method under test: {@link SaleServiceImpl#findById(Long)}
     */
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
        when(this.saleRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Sale> actualFindByIdResult = this.saleServiceImpl.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.saleRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link SaleServiceImpl#saveOrUpdate(Sale)}
     */
    @Test
    void testSaveOrUpdate() {
        Sale sale = new Sale();
        sale.setAuthor("JaneDoe");
        sale.setGenre("Genre");
        sale.setId(123L);
        sale.setIsbnNumber(10.0d);
        sale.setLanguage("en");
        sale.setPrice(10.0d);
        sale.setTitle("Dr");
        when(this.saleRepository.save((Sale) any())).thenReturn(sale);

        Sale sale1 = new Sale();
        sale1.setAuthor("JaneDoe");
        sale1.setGenre("Genre");
        sale1.setId(123L);
        sale1.setIsbnNumber(10.0d);
        sale1.setLanguage("en");
        sale1.setPrice(10.0d);
        sale1.setTitle("Dr");
        assertSame(sale, this.saleServiceImpl.saveOrUpdate(sale1));
        verify(this.saleRepository).save((Sale) any());
    }

    /**
     * Method under test: {@link SaleServiceImpl#deleteById(Long)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(this.saleRepository).deleteById((Long) any());
        assertEquals("{\"message\":\"Sale deleted successfully\"}", this.saleServiceImpl.deleteById(123L));
        verify(this.saleRepository).deleteById((Long) any());
    }
}

