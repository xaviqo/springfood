package tech.xavi.springfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.xavi.springfood.service.CityService;

import static tech.xavi.springfood.controllers.ViewController.getDefaultModel;

@Controller
public class ViewRegisterController {

    @Autowired
    CityService cityService;

    @RequestMapping(value = "/register")
    public String createUser(Model model) {
        //HTML GENERAL INFO
        getDefaultModel(model);
        model.addAttribute("title","SpringFood - Sign In");
        model.addAttribute("cities",cityService.getAllCities());
        return "register/index";
    }

}
