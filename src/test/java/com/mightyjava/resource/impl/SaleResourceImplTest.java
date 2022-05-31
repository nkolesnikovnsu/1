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

    /**
     * Method under test: {@link SaleResourceImpl#findAll(int, int, String, String)}
     */
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

    /**
     * Method under test: {@link SaleResourceImpl#findAll(int, int, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindAll2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Page index must not be less than zero!
        //       at org.springframework.data.domain.AbstractPageRequest.<init>(AbstractPageRequest.java:44)
        //       at org.springframework.data.domain.PageRequest.<init>(PageRequest.java:43)
        //       at org.springframework.data.domain.PageRequest.of(PageRequest.java:70)
        //       at com.mightyjava.resource.impl.SaleResourceImpl.findAll(SaleResourceImpl.java:38)
        //   In order to prevent findAll(int, int, String, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findAll(int, int, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.iPageService.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        this.saleResourceImpl.findAll(-1, 3, "Sort By", "Sort Dir");
    }

    /**
     * Method under test: {@link SaleResourceImpl#findAll(int, int, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindAll3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Property must not null or empty!
        //       at org.springframework.data.domain.Sort$Order.<init>(Sort.java:452)
        //       at org.springframework.data.domain.Sort$Order.<init>(Sort.java:391)
        //       at org.springframework.data.domain.Sort.lambda$new$0(Sort.java:71)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:992)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //       at org.springframework.data.domain.Sort.<init>(Sort.java:72)
        //       at org.springframework.data.domain.Sort.by(Sort.java:87)
        //       at com.mightyjava.resource.impl.SaleResourceImpl.findAll(SaleResourceImpl.java:40)
        //   In order to prevent findAll(int, int, String, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findAll(int, int, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.iPageService.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        this.saleResourceImpl.findAll(10, 3, "", "Sort Dir");
    }

    /**
     * Method under test: {@link SaleResourceImpl#findAll(int, int, String, String)}
     */
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

    /**
     * Method under test: {@link SaleResourceImpl#findAll(int, int, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindAll5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Property must not null or empty!
        //       at org.springframework.data.domain.Sort$Order.<init>(Sort.java:452)
        //       at org.springframework.data.domain.Sort$Order.<init>(Sort.java:391)
        //       at org.springframework.data.domain.Sort.lambda$new$0(Sort.java:71)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:992)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //       at org.springframework.data.domain.Sort.<init>(Sort.java:72)
        //       at org.springframework.data.domain.Sort.by(Sort.java:87)
        //       at com.mightyjava.resource.impl.SaleResourceImpl.findAll(SaleResourceImpl.java:40)
        //   In order to prevent findAll(int, int, String, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findAll(int, int, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.iPageService.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        this.saleResourceImpl.findAll(10, 3, "", "asc");
    }

    /**
     * Method under test: {@link SaleResourceImpl#findAll(org.springframework.data.domain.Pageable, String)}
     */
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

    /**
     * Method under test: {@link SaleResourceImpl#findById(Long)}
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
        when(this.iService.findById((Long) any())).thenReturn(ofResult);
        ResponseEntity<Sale> actualFindByIdResult = this.saleResourceImpl.findById(123L);
        assertTrue(actualFindByIdResult.hasBody());
        assertTrue(actualFindByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindByIdResult.getStatusCode());
        verify(this.iService).findById((Long) any());
    }

    /**
     * Method under test: {@link SaleResourceImpl#findById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.mightyjava.resource.impl.SaleResourceImpl.findById(SaleResourceImpl.java:47)
        //   In order to prevent findById(Long)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findById(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.iService.findById((Long) any())).thenReturn(Optional.empty());
        this.saleResourceImpl.findById(123L);
    }

    /**
     * Method under test: {@link SaleResourceImpl#save(Sale)}
     */
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

    /**
     * Method under test: {@link SaleResourceImpl#update(Sale)}
     */
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

    /**
     * Method under test: {@link SaleResourceImpl#deleteById(Long)}
     */
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

