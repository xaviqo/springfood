package tech.xavi.springfood.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.xavi.springfood.models.Purchase;


public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
