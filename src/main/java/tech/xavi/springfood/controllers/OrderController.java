package tech.xavi.springfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.xavi.springfood.models.Product;
import tech.xavi.springfood.repository.ProductRepository;
import tech.xavi.springfood.repository.projection.IProductCart;
import tech.xavi.springfood.service.ProductService;

import java.util.Optional;


@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/getProductCart/{id}")
    public IProductCart getPurchaseAndCostumer(@PathVariable long id){
        return productService.getProductCartDto(id);
    }

    @GetMapping("/getProduct/{id}")
    public Optional<Product> getProductById(@PathVariable long id){
        return productService.getProduct(id);
    }

//    @PostMapping("/postProductCart/")
//    public void createOrder

}
