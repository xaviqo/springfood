package tech.xavi.springfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.xavi.springfood.models.OrderLine;
import tech.xavi.springfood.models.Orders;
import tech.xavi.springfood.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<Orders> getOrders(){
        return orderService.getOrdersWithClient();
    }

    @GetMapping("/{id}")
    public List<OrderLine> getOrderLines(@PathVariable int id){
        return orderService.getOrderLineWithProduct(id);
    }
}
