package tech.xavi.springfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.xavi.springfood.repository.ProductRepository;
import tech.xavi.springfood.models.Product;
import tech.xavi.springfood.repository.projection.IProductCart;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> getProduct(long id){
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Override
    public IProductCart getProductCartDto(long id){
        return productRepository.findProductCartById(id);
    }

}
