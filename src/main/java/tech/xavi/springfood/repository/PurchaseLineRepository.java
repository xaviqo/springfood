package tech.xavi.springfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.xavi.springfood.models.PurchaseLine;

import java.util.List;

public interface PurchaseLineRepository extends JpaRepository<PurchaseLine, Long> {

    List<PurchaseLine> getPurchaseLinesByPurchase(long id);
}
