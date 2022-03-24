package tech.xavi.springfood.service;

import tech.xavi.springfood.models.Product;
import tech.xavi.springfood.repository.projection.IProductCart;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProduct(long id);

    List<Product> getProducts();

    IProductCart getProductCartDto(long id);

}
