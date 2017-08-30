package com.bizdash;

import com.bizdash.entities.Business;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String printHello(ModelMap model){
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/addBusiness")
    public String addBusiness(ModelMap model){
        model.addAttribute("addBusiness", new Business());
        return "addBusiness";
    }
    
    @RequestMapping(value = "/business", method = RequestMethod.POST)
    public String newBusiness(@ModelAttribute Business business, ModelMap model) {
        model.addAttribute("name", business.getName());
        model.addAttribute("location", business.getLocation());
        model.addAttribute("pib", business.getPib());
        return "business";
    }
}
