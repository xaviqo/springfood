package tech.xavi.springfood.Repository.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import tech.xavi.springfood.models.City;

import java.time.LocalDateTime;

@Component
@Data
public class PurchaseDto {

    private long id;
    private LocalDateTime date;
    private short discount;
    private double total;
    private boolean isDelivered;
    private String customerName;
    private String phone;
    private City city;
    private String street;

}
