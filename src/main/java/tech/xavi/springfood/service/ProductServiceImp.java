package tech.xavi.springfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.xavi.springfood.Repository.ProductRepository;
import tech.xavi.springfood.Repository.dto.ProductCartDto;
import tech.xavi.springfood.models.Product;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Override
    public ProductCartDto getProductCartDto(long id){

        Optional<Product> product = productRepository.findById(id);
        ProductCartDto productCartDto = new ProductCartDto();

        productCartDto.setName(product.get().getName());
        productCartDto.setPrice(product.get().getPrice());
        productCartDto.setDescription(product.get().getDescription());

        return productCartDto;

    }
}
