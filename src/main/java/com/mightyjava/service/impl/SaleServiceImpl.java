package com.mightyjava.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mightyjava.domain.Sale;
import com.mightyjava.repository.SaleRepository;
import com.mightyjava.service.IPageService;
import com.mightyjava.service.IService;

@Service
public class SaleServiceImpl implements IService<Sale>, IPageService<Sale> {

	@Autowired
	private SaleRepository saleRepository;
	
	@Override
	public Collection<Sale> findAll() {
		return (Collection<Sale>) saleRepository.findAll();
	}

	@Override
	public Page<Sale> findAll(Pageable pageable, String searchText) {
		return saleRepository.findAllBooks(pageable, searchText);
	}

	@Override
	public Page<Sale> findAll(Pageable pageable) {
		return saleRepository.findAll(pageable);
	}

	@Override
	public Optional<Sale> findById(Long id) {
		return saleRepository.findById(id);
	}

	@Override
	public Sale saveOrUpdate(Sale sale) {
		return saleRepository.save(sale);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			saleRepository.deleteById(id);
			jsonObject.put("message", "Sale deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}
