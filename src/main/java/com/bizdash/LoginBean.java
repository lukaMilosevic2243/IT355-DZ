package com.bizdash;

import java.io.Serializable;

public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString(){
        return "LoginBean: Username=" + username + ", Password=" + password;
    }

    
    
}
