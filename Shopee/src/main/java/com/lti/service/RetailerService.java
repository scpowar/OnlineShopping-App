package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.dao.RetailerDao;
import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
@Service
public class RetailerService {

	@Autowired
	private GenericDao dao;
	
	@Autowired
	private RetailerDao retailerDao;

	@Transactional
	public void addProducts(String name, String brand, String description, double price, int stock, int retailerId, int categoryId) {
		Product product=new Product();
		Retailer retailer=dao.fetchById(Retailer.class, retailerId);
		Category category=dao.fetchById(Category.class, categoryId);
		product.setName(name);
		product.setBrand(brand);
		product.setDescription(description);
		product.setPrice(price);
		product.setStock(stock);
		product.setRetailer(retailer);
		product.setCategory(category);
		dao.save(product);
	}
	@Transactional
	public Retailer retailerLogin(String email, String password) {
		return retailerDao.loginValidation(email, password);
	}
	
}