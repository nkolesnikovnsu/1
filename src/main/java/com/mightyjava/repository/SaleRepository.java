package com.mightyjava.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mightyjava.domain.Sale;

@Repository
public interface SaleRepository extends PagingAndSortingRepository<Sale, Long> {
    @Query("FROM Sale b WHERE b.title LIKE %:searchText% OR b.author LIKE %:searchText% OR b.language LIKE %:searchText% OR b.genre LIKE %:searchText% ORDER BY b.price ASC")
    Page<Sale> findAllBooks(Pageable pageable, @Param("searchText") String searchText);
}
