package tech.xavi.springfood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.xavi.springfood.models.PurchaseLine;

import java.util.List;
import java.util.Optional;

public interface PurchaseLineRepository extends JpaRepository<PurchaseLine, Long> {

    List<PurchaseLine> getPurchaseLinesByPurchase(long id);
}
