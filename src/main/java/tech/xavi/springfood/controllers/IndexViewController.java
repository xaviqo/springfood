package tech.xavi.springfood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexViewController {

    public static final String NAV_ADMIN = "Admin Panel";
    public static final String NAV_REGISTER = "Registro";
    public static final String NAV_ORDER = "Simular Pedido";
    public static final String NAV_ABOUT = "Sobre SpringFood";
    public static final String NAV_LINK = "Xavi.Tech";

    private static Model getDefaultModel(Model model){

        model.addAttribute("admin", NAV_ADMIN);
        model.addAttribute("registro", NAV_REGISTER);
        model.addAttribute("pedido", NAV_ORDER);
        model.addAttribute("about", NAV_ABOUT);
        model.addAttribute("xavitech", NAV_LINK);

        return model;
    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        getDefaultModel(model);
        model.addAttribute("subtitle", "Administrador de pedidos online. Desarrollado con Spring Boot por Xavi.Tech");
        return "main/index";
    }

    @RequestMapping(value = "/nav/{param}")
    public String navBar(@PathVariable String param) {
        switch (param) {
            case "admin":
                return param+"/index";
            case "register":
                return param+"/index";
            case "order":
                return param+"/index";
            case "about":
                return param+"/index";
            default:
                return "index";
        }
    }
}
