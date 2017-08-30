package com.bizdash;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String validateUser(LoginBean loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        if (username.equals("user") && password.equals("pass")) {
            return "true";
        } else {
            return "false";
        }
    }

}
