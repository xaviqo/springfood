package tech.xavi.springfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.xavi.springfood.models.Product;
import tech.xavi.springfood.repository.projection.IProductCart;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT pr.id as productId, pr.productName as productName," +
            "pr.price as price FROM Product pr " +
            "WHERE pr.id = :userId")
    IProductCart findProductCartById(@Param("userId") Long productId);

}
