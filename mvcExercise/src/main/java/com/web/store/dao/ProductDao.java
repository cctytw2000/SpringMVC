package com.web.store.dao;

import java.util.List;

import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;

public interface ProductDao {
	List<BookBean> getAllProduct();

	void updateStock(int productId, int newQuantity);

	List<String> getAllCategories();

	List<BookBean> getProductByCategory(String category);

	public BookBean getProductById(int productId);

	void addProduct(BookBean product);

	CompanyBean getCompanyById(int companyId);

	List<CompanyBean> getCompanyList();
}
