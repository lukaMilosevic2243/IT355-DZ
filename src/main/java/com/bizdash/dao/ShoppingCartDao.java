package com.bizdash.dao;

import com.bizdash.entities.Category;
import com.bizdash.entities.Product;
import java.util.List;

public interface ShoppingCartDao {

    public List<Category> getCategories();

    public Category getCategoryByID(int id);
    
    public List<Product> getProductsByCategory(Category category);
    
    public void editCategory(Category category);
    
    public Category addCategory(Category category);
    
    public int getCountProductsInCategory(int categoryId);
    
    public void deleteCategory(Category category);

    public List<Product> getProducts();

    public Product getProductByID(int productID);

    public void editProduct(Product product);

    public Product addProduct(Product product);

    public void deleteProduct(Product product);

    public int getCountProducts();

}
