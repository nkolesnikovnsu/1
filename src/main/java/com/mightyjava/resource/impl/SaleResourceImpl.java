package com.mightyjava.resource.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mightyjava.domain.Sale;
import com.mightyjava.resource.Resource;
import com.mightyjava.service.IPageService;
import com.mightyjava.service.IService;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins="http://localhost:3000")
public class SaleResourceImpl implements Resource<Sale> {
	
	@Autowired
	private IService<Sale> saleIService;
	
	@Autowired
	private IPageService<Sale> saleIPageService;

	@Override
	public ResponseEntity<Page<Sale>> findAll(Pageable pageable, String searchText) {
		return new ResponseEntity<>(saleIPageService.findAll(pageable, searchText), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Page<Sale>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
		return new ResponseEntity<>(saleIPageService.findAll(
				PageRequest.of(
						pageNumber, pageSize,
						sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
				)
		), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Sale> findById(Long id) {
		return new ResponseEntity<>(saleIService.findById(id).get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Sale> save(Sale sale) {
		return new ResponseEntity<>(saleIService.saveOrUpdate(sale), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Sale> update(Sale sale) {
		return new ResponseEntity<>(saleIService.saveOrUpdate(sale), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		return new ResponseEntity<>(saleIService.deleteById(id), HttpStatus.OK);
	}
}
