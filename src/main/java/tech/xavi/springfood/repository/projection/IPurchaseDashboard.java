package tech.xavi.springfood.repository.projection;

import tech.xavi.springfood.models.City;

import java.time.LocalDateTime;

public interface IPurchaseDashboard {
    long getPurchaseId();
    LocalDateTime getDate();
    short getDiscount();
    double getPurchaseTotal();
    boolean isDelivered();
    String getCustomerName();
    String getPhone();
    City getCity();
    String getStreet();
}
