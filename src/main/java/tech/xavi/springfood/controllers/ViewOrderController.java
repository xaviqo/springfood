package tech.xavi.springfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.xavi.springfood.models.Product;
import tech.xavi.springfood.service.ProductService;

import java.util.List;

import static tech.xavi.springfood.controllers.ViewController.getDefaultModel;

@Controller
public class ViewOrderController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/makeorder")
    public String makeOrder(Model model) {

        //HTML GENERAL INFO
        getDefaultModel(model);
        String userName = "NOMBRE";
        model.addAttribute("title","SpringFood - Fake Order");
        model.addAttribute("heyUser",
                "Hi "+userName+". Your cart is empty, please select any product.");
        List<Product> productList = productService.getProducts();
        model.addAttribute("products",productList);

        return "order/index";
    }

}
