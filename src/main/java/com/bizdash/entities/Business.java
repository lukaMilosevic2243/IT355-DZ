package com.bizdash.entities;

public class Business {
    private String name;
    private String location;
    private String pib;
//    private User owner;
//    private ArrayList<Product> products;
    
    public Business(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }
    
    
    
    
}
