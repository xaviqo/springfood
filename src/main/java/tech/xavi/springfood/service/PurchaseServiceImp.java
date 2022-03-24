package tech.xavi.springfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.xavi.springfood.repository.PurchaseLineRepository;
import tech.xavi.springfood.repository.PurchaseRepository;
import tech.xavi.springfood.models.PurchaseLine;
import tech.xavi.springfood.repository.projection.IPurchaseDashboard;
import java.util.List;

@Component
public class PurchaseServiceImp implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseLineRepository purchaseLineRepository;

    @Override
    public List<IPurchaseDashboard> getPurchaseAndCustomer() {
        return purchaseRepository.getAllPurchasesProjection();
    }
    @Override
    public List<PurchaseLine> getPurchaseLinePurchaseById(long id) {
        return purchaseLineRepository.getPurchaseLinesByPurchase(id);
    }


}
