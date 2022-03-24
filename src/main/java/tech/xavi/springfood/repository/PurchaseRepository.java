package tech.xavi.springfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.xavi.springfood.models.Purchase;
import tech.xavi.springfood.repository.projection.IPurchaseDashboard;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT pu.purchaseId as purchaseId," +
            "pu.date as date, pu.discount as discount," +
            "pu.purchaseTotal as purchaseTotal," +
            "pu.isDelivered as delivered," +
            "pu.customer.customerName as customerName," +
            "pu.customer.phone as phone," +
            "pu.customer.city as city," +
            "pu.customer.street as street FROM Purchase pu")
    List<IPurchaseDashboard> getAllPurchasesProjection();


}
