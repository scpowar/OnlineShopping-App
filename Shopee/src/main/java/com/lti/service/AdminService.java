package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AdminDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Admin;
import com.lti.entity.Cart;
import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private GenericDao dao;

	@Transactional
	public Admin adminLogin(String email, String password) {
		return adminDao.loginValidation(email, password);
	}
	public List <Retailer> displayRetailer(int adminId) {
		return adminDao.displayRetailer(adminId);
	}
	
	@Transactional
	public void removeRetailer(int retailerId)
	{
		Retailer retailer =dao.fetchById(Retailer.class, retailerId);
		dao.delete(retailer);
	}
	
	@Transactional
	public void addRetailer(String password ,String name ,String email ,int adminId) {
		Retailer retailer=new Retailer();
		retailer.setEmail(email);
		retailer.setName(name);
		retailer.setPassword(password);
		Admin admin=dao.fetchById(Admin.class, adminId);
		retailer.setAdmin(admin);
		dao.save(retailer);
	}
}