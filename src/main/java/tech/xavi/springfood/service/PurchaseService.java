package tech.xavi.springfood.service;

import tech.xavi.springfood.models.PurchaseLine;
import tech.xavi.springfood.repository.projection.IPurchaseDashboard;

import java.util.List;

public interface PurchaseService {

    List<IPurchaseDashboard> getPurchaseAndCustomer();
    List<PurchaseLine> getPurchaseLinePurchaseById(long id);

}
