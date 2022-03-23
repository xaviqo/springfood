package tech.xavi.springfood.Repository.dto;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class ProductCartDto {
    private String name;
    private String description;
    private double price;
}
