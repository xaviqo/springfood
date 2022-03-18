package tech.xavi.springfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.xavi.springfood.Repository.PurchaseLineRepository;
import tech.xavi.springfood.Repository.PurchaseRepository;
import tech.xavi.springfood.Repository.dto.PurchaseDto;
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
    public List<PurchaseDto> getPurchaseAndCustomer() {

        ArrayList<PurchaseDto> purchaseDtoList = new ArrayList<>();

        for (Purchase purchase : purchaseRepository.findAll()) {

            PurchaseDto purchaseDto = new PurchaseDto();

            purchaseDto.setId(purchase.getId());
            purchaseDto.setDate(purchase.getDate());
            purchaseDto.setDiscount(purchase.getDiscount());
            purchaseDto.setTotal(purchase.getTotal());
            purchaseDto.setDelivered(purchase.isDelivered());
            purchaseDto.setCustomerName(purchase.getCustomer().getCustomerName());
            purchaseDto.setPhone(purchase.getCustomer().getPhone());
            purchaseDto.setCity(purchase.getCustomer().getCity());
            purchaseDto.setStreet(purchase.getCustomer().getStreet());

            purchaseDtoList.add(purchaseDto);

        }

        return purchaseDtoList;

    }

    @Override
    public List<PurchaseLine> getPurchaseLinePurchaseById(Long id) {
        return purchaseLineRepository.getPurchaseLinesByPurchase(id);
    }


}
