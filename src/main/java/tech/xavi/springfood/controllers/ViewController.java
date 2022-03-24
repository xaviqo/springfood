package tech.xavi.springfood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    public static final String NAV_TITLE = "SpringFood";
    public static final String NAV_ADMIN = "Orders Dashboard";
    public static final String NAV_STOCK = "Stock Management";
    public static final String NAV_REGISTER = "Sign Up";
    public static final String NAV_LOG_IN = "Log In";
    public static final String NAV_ORDER = "Make an order";
    public static final String NAV_ABOUT = "About SpringFood";
    public static final String NAV_LINK = "Xavi.Tech";

    public static Model getDefaultModel(Model model){

        model.addAttribute("title",NAV_TITLE);
        model.addAttribute("admin_orders", NAV_ADMIN);
        model.addAttribute("admin_stock", NAV_STOCK);
        model.addAttribute("register", NAV_REGISTER);
        model.addAttribute("login", NAV_LOG_IN);
        model.addAttribute("order", NAV_ORDER);
        model.addAttribute("about", NAV_ABOUT);
        model.addAttribute("xavitech", NAV_LINK);

        return model;
    }

    @RequestMapping(value = {"/","/index"})
    public String index(Model model) {
        getDefaultModel(model);
        model.addAttribute("subtitle", "Online delivery shop manager. Developed with SpringBoot by Xavi.Tech");
        return "main/index";
    }

}
