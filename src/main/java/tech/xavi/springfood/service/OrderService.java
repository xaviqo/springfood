package tech.xavi.springfood.service;

import tech.xavi.springfood.models.OrderLine;
import tech.xavi.springfood.models.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> getOrdersWithClient();
    List<OrderLine> getOrderLineWithProduct(int id);
}
