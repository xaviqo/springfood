package tech.xavi.springfood.controllers.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.xavi.springfood.models.Order;
import tech.xavi.springfood.models.OrderLine;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    @RequestMapping("/getorders")
    public Order getOrder(){


        Order order = new Order();
        order.setId(1);
        order.setClient(1);
        order.setLines(3);
        order.setDate(LocalDateTime.now());
        order.setCity("Barcelona");
        order.setStreet("Figuera 48");
        order.setTotal(13.37);
        order.setSale(0);
        order.setState(true);

        return order;
    }
}
