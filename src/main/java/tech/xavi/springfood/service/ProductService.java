package tech.xavi.springfood.service;

import tech.xavi.springfood.Repository.dto.ProductCartDto;
import tech.xavi.springfood.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    ProductCartDto getProductCartDto(long id);
}
