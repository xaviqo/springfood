package tech.xavi.springfood.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexViewController {

    public static final String NAV_TITLE = "SpringFood";
    public static final String NAV_ADMIN = "Admin Panel";
    public static final String NAV_REGISTER = "Registro";
    public static final String NAV_ORDER = "Simular Pedido";
    public static final String NAV_ABOUT = "Sobre SpringFood";
    public static final String NAV_LINK = "Xavi.Tech";

    static Model getDefaultModel(Model model){

        model.addAttribute("title",NAV_TITLE);
        model.addAttribute("admin", NAV_ADMIN);
        model.addAttribute("registro", NAV_REGISTER);
        model.addAttribute("pedido", NAV_ORDER);
        model.addAttribute("about", NAV_ABOUT);
        model.addAttribute("xavitech", NAV_LINK);

        return model;
    }

    @RequestMapping(value = {"/","/index"})
    public String index(Model model) {
        getDefaultModel(model);
        model.addAttribute("subtitle", "Administrador de pedidos online. Desarrollado con Spring Boot por Xavi.Tech");
        return "main/index";
    }

}
