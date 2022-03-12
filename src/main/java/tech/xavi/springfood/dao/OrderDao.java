package tech.xavi.springfood.dao;

import tech.xavi.springfood.models.Orders;

import java.util.List;

public interface OrderDao {
    List<Orders> getOrders();

    List<Orders> getOrderLines(int id);

}
