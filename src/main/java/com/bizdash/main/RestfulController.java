package com.bizdash.main;

import com.bizdash.dao.ShoppingCartDao;
import com.bizdash.entities.Category;
import com.bizdash.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProducts() {
        System.out.println("Fetching products");
        List<Product> products = shoppingCartDao.getProducts();
        if (products.size() == 0) {
            System.out.println("Product list empty");
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        System.out.println("Fetching product with id " + id);
        Product product = shoppingCartDao.getProductByID(id);
        if (product == null) {
            System.out.println("Product with " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getCategories() {
        System.out.println("Fetching categories");
        List<Category> categories = shoppingCartDao.getCategories();
        if (categories.size() == 0) {
            System.out.println("Category list empty");
            return new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable("id") int id) {
        System.out.println("Fetching category with id " + id);
        Category c = shoppingCartDao.getCategoryByID(id);
        if (c == null) {
            System.out.println("Category with " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(c, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
        System.out.println("Adding product " + product.toString());
        shoppingCartDao.addProduct(product);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        System.out.println("Updating product " + id);

        product.setId(id);
        shoppingCartDao.editProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting product with id " + id);

        Product produc = shoppingCartDao.getProductByID(id);
        if (produc == null) {
            System.out.println("Unable to delete. Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        shoppingCartDao.deleteProduct(produc);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @RequestMapping(value = "/category/", method = RequestMethod.POST)
    public ResponseEntity<Void> addCategory(@RequestBody Category c) {
        System.out.println("Adding category " + c.toString());
        shoppingCartDao.addCategory(c);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category c) {
        System.out.println("Updating category " + id);

        c.setId(id);
        shoppingCartDao.editCategory(c);
        return new ResponseEntity<Category>(c, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting category with id " + id);

        Category c = shoppingCartDao.getCategoryByID(id);
        if (c == null) {
            System.out.println("Unable to delete. Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        shoppingCartDao.deleteCategory(c);
        return new ResponseEntity<Category>(HttpStatus.OK);
    }

}
