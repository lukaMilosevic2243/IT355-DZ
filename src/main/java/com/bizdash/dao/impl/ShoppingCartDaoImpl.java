package com.bizdash.dao.impl;

import com.bizdash.dao.ShoppingCartDao;
import com.bizdash.entities.Category;
import com.bizdash.entities.Product;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository("ShoppingCartDao")
@Service
public class ShoppingCartDaoImpl implements ShoppingCartDao {

   @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Product> getProducts() {
        List<Product> results = (List<Product>) getSession().createCriteria(Product.class).list();
        return results;
    }

    @Override
    @Transactional
    public Product getProductByID(int id) {
        
        Product product = (Product) getSession().createCriteria(Product.class).add(Restrictions.eq("id", id)).uniqueResult();
        return product;

    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Category> getCategories() {
        List<Category> results = (List<Category>) getSession().createCriteria(Category.class).list();
        return results;
    }

    @Override
    @Transactional
    public Category getCategoryByID(int id) {
        Category category = (Category) getSession().createCriteria(Category.class).add(Restrictions.eq("id", id)).uniqueResult();
        return category;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Product> getProductsByCategory(Category category) {
        return (List<Product>) getSession().createCriteria(Product.class).add(Restrictions.eq("category", category)).list();
    }

    @Override
    @Transactional
    public void editCategory(Category category) {
        getSession().saveOrUpdate(category);

    }

    @Override
    @Transactional
    public void editProduct(Product product) {
        getSession().saveOrUpdate(product);

    }

    @Override
    @Transactional
    public Category addCategory(Category category) {
        return (Category)getSession().merge(category);
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
       return (Product)getSession().merge(product);
    }

    @Override
    @Transactional
    public int getCountProducts() {
        Number result = (Number) getSession().createSQLQuery("select count(*) from product").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    @Transactional
    public int getCountProductsInCategory(int categoryId) {

        String hql = "select count(*) from product where category_id = :id";
        Number result = (Number) getSession().createSQLQuery(hql).setInteger("id", categoryId).uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Transactional
    @Override
    public void deleteProduct(Product product) {
        getSession().delete(product);
    }

    @Transactional
    @Override
    public void deleteCategory(Category category) {
        getSession().delete(category);
    }
}
