package com.bizdash;

import com.bizdash.entities.Business;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid credentials!");
        }
        if (logout != null) {
            model.addObject("msg", "You are logged out!");
        }
        model.setViewName("login"); //dodeljujem jsp
        return model;
    }
    
    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public ModelAndView userPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Korisnicka Strana, ovo je poruka prosledjena iz kontrolera!");
        model.setViewName("userPage");
        return model;
    }
    
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Administratorska strana");
        model.setViewName("admin");
        return model;
    }
    
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }
        model.setViewName("403");
        return model;
    }
}
