package tech.xavi.springfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.xavi.springfood.Repository.ProductRepository;
import tech.xavi.springfood.models.Product;

import java.util.List;

@Component
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
