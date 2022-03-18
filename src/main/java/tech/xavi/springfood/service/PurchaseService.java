package tech.xavi.springfood.service;

import tech.xavi.springfood.Repository.dto.PurchaseDto;
import tech.xavi.springfood.models.PurchaseLine;

import java.util.List;

public interface PurchaseService {

    List<PurchaseDto> getPurchaseAndCustomer();

    List<PurchaseLine> getPurchaseLinePurchaseById(Long id);

}
