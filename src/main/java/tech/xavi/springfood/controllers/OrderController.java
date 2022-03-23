package tech.xavi.springfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.xavi.springfood.Repository.ProductRepository;
import tech.xavi.springfood.Repository.dto.ProductCartDto;
import tech.xavi.springfood.service.ProductService;


@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/getProductDto/{id}")
    private ProductCartDto getPurchaseAndCostumer(@PathVariable long id){
        return productService.getProductCartDto(id);
    }

}
