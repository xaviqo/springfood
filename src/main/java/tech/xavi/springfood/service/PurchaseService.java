package tech.xavi.springfood.service;

import tech.xavi.springfood.Repository.dto.PurchaseDashboardDto;
import tech.xavi.springfood.models.PurchaseLine;

import java.util.List;

public interface PurchaseService {

    List<PurchaseDashboardDto> getPurchaseAndCustomer();

    List<PurchaseLine> getPurchaseLinePurchaseById(long id);

}
