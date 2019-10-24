package com.web.store.service;

import java.util.List;

import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;

public interface ProductService {
	List<BookBean> getAllProduct();

	void updateAllstocks();

	List<String> getAllCategories();

	List<BookBean> getProductByCategory(String category);

	public BookBean getProductById(int productId);

	void addProduct(BookBean product);

	CompanyBean getCompanyById(int companyId);

	List<CompanyBean> getCompanyList();

}
