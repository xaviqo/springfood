package tech.xavi.springfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.xavi.springfood.models.PurchaseLine;
import tech.xavi.springfood.repository.projection.IPurchaseDashboard;
import tech.xavi.springfood.service.PurchaseService;
import java.util.List;

@RestController
@RequestMapping("api/dashboard")
public class DashboardController {

    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/getAllPurchaseDto")
    private List<IPurchaseDashboard> getPurchaseAndCostumer(){
        return purchaseService.getPurchaseAndCustomer();
    }

    @GetMapping("/purchaseLineBy/{id}")
    private List<PurchaseLine> getPurchaseLinePurchaseById(@PathVariable long id){
        return purchaseService.getPurchaseLinePurchaseById(id);
    }

}
