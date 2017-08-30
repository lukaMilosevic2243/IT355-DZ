package com.bizdash.dao;

import com.bizdash.entities.Business;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BusinessDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Business p) {
        String sql = "INSERT INTO business(name, location, pib) VALUES ('" + p.getName()+ "', '" + p.getLocation()+ "', '" + p.getPib()+ "')";
        return template.update(sql);
    }

    public int update(Business p) {
        String sql = "UPDATE business SET name='" + p.getName()+ "', location='" + p.getLocation()+ "', pib='" + p.getPib()+ "' where id='" + p.getId() + "'";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "DELETE FROM product WHERE product_id=" + id + "";
        return template.update(sql);
    }

    public Product getProductByID(int id) {
        String sql = "SELECT * FROM product WHERE product_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Product>(Product.class));
    }

    public List<Product> getProducts() {
        return template.query("SELECT * FROM product", new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int row) throws SQLException {
                Product e = new Product();
                e.setId(rs.getInt(1));
                e.setProductName(rs.getString(2));
                e.setProductPrice(rs.getDouble(3));
                e.setProductDescription(rs.getString(4));
                return e;
            }
        });
    }
}
