package tech.xavi.springfood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static tech.xavi.springfood.controllers.ViewController.getDefaultModel;

@Controller
public class ViewRegisterController {

    @RequestMapping(value = "/register")
    public String makeOrder(Model model) {

        //HTML GENERAL INFO
        getDefaultModel(model);
        model.addAttribute("title","SpringFood - Sign In");

        return "register/index";
    }

}
