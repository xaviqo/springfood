package tech.xavi.springfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.xavi.springfood.Repository.PurchaseLineRepository;
import tech.xavi.springfood.Repository.PurchaseRepository;
import tech.xavi.springfood.Repository.dto.PurchaseDashboardDto;
import tech.xavi.springfood.models.Purchase;
import tech.xavi.springfood.models.PurchaseLine;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseServiceImp implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseLineRepository purchaseLineRepository;

    @Override
    public List<PurchaseDashboardDto> getPurchaseAndCustomer() {

        ArrayList<PurchaseDashboardDto> purchaseDashboardDtoList = new ArrayList<>();

        for (Purchase purchase : purchaseRepository.findAll()) {

            PurchaseDashboardDto purchaseDashboardDto = new PurchaseDashboardDto();

            purchaseDashboardDto.setId(purchase.getId());
            purchaseDashboardDto.setDate(purchase.getDate());
            purchaseDashboardDto.setDiscount(purchase.getDiscount());
            purchaseDashboardDto.setTotal(purchase.getTotal());
            purchaseDashboardDto.setDelivered(purchase.isDelivered());
            purchaseDashboardDto.setCustomerName(purchase.getCustomer().getCustomerName());
            purchaseDashboardDto.setPhone(purchase.getCustomer().getPhone());
            purchaseDashboardDto.setCity(purchase.getCustomer().getCity());
            purchaseDashboardDto.setStreet(purchase.getCustomer().getStreet());

            purchaseDashboardDtoList.add(purchaseDashboardDto);

        }

        return purchaseDashboardDtoList;

    }

    @Override
    public List<PurchaseLine> getPurchaseLinePurchaseById(long id) {
        return purchaseLineRepository.getPurchaseLinesByPurchase(id);
    }


}
