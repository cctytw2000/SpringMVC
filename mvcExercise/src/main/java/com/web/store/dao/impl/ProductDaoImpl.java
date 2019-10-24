package com.web.store.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.ProductDao;
import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;

@Repository
public class ProductDaoImpl implements ProductDao {
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<BookBean> getAllProduct() {
		List<BookBean> List = new ArrayList<>();
		List = factory.getCurrentSession().createQuery("FROM BookBean").getResultList();
		return List;
	}

	@Override
	public void updateStock(int productId, int newQuantity) {
		Query query = factory.getCurrentSession()
				.createQuery("UPDATE BookBean SET stock = :newQuantity WHERE bookId = :id");
		query.setParameter("newQuantity", newQuantity);
		query.setParameter("id", productId);
		query.executeUpdate();
	}

	@Override
	public List<String> getAllCategories() {
		Query query = factory.getCurrentSession().createQuery("select distinct b.category from BookBean b");
		List<String> list = query.getResultList();
		return list;
	}

	@Override
	public List<BookBean> getProductByCategory(String category) {
		Query query = factory.getCurrentSession().createQuery("from BookBean bb where bb.category = :category");
		query.setParameter("category", category);
		List<BookBean> list = query.getResultList();
		return list;
	}

	@Override
	public BookBean getProductById(int productId) {
		BookBean bb = factory.getCurrentSession().get(BookBean.class, productId);

		return bb;
	}

	@Override
	public void addProduct(BookBean product) {
		Session session = factory.getCurrentSession();
		CompanyBean cb = getCompanyById(product.getCompanyId());
		product.setCompanyBean(cb);
		session.save(product);
	}

	@Override
	public CompanyBean getCompanyById(int companyId) {
		CompanyBean cb = null;
		Session session = factory.getCurrentSession();
		cb = session.get(CompanyBean.class, companyId);
		return cb;
	}

	@Override
	public List<CompanyBean> getCompanyList() {
		Session session = factory.getCurrentSession();
		List<CompanyBean> list = session.createQuery("from CompanyBean").getResultList();
		return list;
	}

}
