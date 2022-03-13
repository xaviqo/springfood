package tech.xavi.springfood.dao;

import tech.xavi.springfood.models.Orders;

import java.util.List;

public interface OrderDao {
    List<Object[]> getOrders();
    List<Object[]> getOrderLines(int id);

}
