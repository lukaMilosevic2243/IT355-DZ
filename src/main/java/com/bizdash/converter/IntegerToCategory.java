package com.bizdash.converter;

import com.bizdash.dao.ShoppingCartDao;
import com.bizdash.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class IntegerToCategory implements Converter<String , Category>{
    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Override
    public Category convert(String  s) {
        if(s.isEmpty()){
            return null;
        }
        Integer value = Integer.valueOf(s);
        System.out.println("Konvertujem u kategoriju");
        Category cat = shoppingCartDao.getCategoryByID(value);
        return cat;
    }
}
