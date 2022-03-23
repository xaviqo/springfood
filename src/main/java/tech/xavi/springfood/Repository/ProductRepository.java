package tech.xavi.springfood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.xavi.springfood.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
