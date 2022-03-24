package tech.xavi.springfood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static tech.xavi.springfood.controllers.ViewController.getDefaultModel;

@Controller
public class ViewDashboardController {

    @RequestMapping(value = "/manager")
    public String admin(Model model) {
        getDefaultModel(model);
        model.addAttribute("title","SpringFood - Orders Dashboard");
        return "admin/index";
    }

}
