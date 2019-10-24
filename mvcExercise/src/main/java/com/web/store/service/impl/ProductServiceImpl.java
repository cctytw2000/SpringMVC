package com.web.store.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.web.store.dao.ProductDao;
import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;
import com.web.store.service.ProductService;

@Service

public class ProductServiceImpl implements ProductService {
	ProductDao dao;

	@Autowired
	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public List<BookBean> getAllProduct() {
		dao.getAllProduct();
		return dao.getAllProduct();
	}

	@Transactional
	@Override
	public void updateAllstocks() {
		List<BookBean> addProducts = dao.getAllProduct();
		for (BookBean bb : addProducts) {
			if (bb.getStock() != null && bb.getStock() < 50) {
				dao.updateStock(bb.getBookId(), bb.getStock() + 50);
			}
		}
	}

	@Transactional
	@Override
	public List<String> getAllCategories() {
		// TODO Auto-generated method stub
		return dao.getAllCategories();
	}

	@Transactional
	@Override
	public List<BookBean> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return dao.getProductByCategory(category);
	}

	@Transactional
	@Override
	public BookBean getProductById(int productId) {
		// TODO Auto-generated method stub
		return dao.getProductById(productId);
	}

	@Transactional
	@Override
	public void addProduct(BookBean product) {
		dao.addProduct(product);

	}

	@Transactional
	@Override
	public CompanyBean getCompanyById(int companyId) {

		return dao.getCompanyById(companyId);
	}

	@Transactional
	@Override
	public List<CompanyBean> getCompanyList() {

		return dao.getCompanyList();
	}

}
