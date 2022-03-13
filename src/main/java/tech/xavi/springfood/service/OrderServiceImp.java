package tech.xavi.springfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.xavi.springfood.dao.OrderDao;
import tech.xavi.springfood.models.Client;
import tech.xavi.springfood.models.OrderLine;
import tech.xavi.springfood.models.Orders;
import tech.xavi.springfood.models.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> getOrdersWithClient() {

        Orders orders = null;
        Client client = null;
        ArrayList<Orders> ordersArrayList = new ArrayList<>();

        for (Object[] obj : orderDao.getOrders()) {

            orders = (Orders) obj[0];
            client = (Client) obj[1];
            client.setEmail(null);
            client.setPassword(null);
            orders.setClient(client);
            ordersArrayList.add(orders);
        }

        return ordersArrayList;
    }

    @Override
    public List<OrderLine> getOrderLineWithProduct(int id) {

        OrderLine orderLine = null;
        Product product = null;
        ArrayList<OrderLine> orderLineArrayList = new ArrayList<>();

        for (Object[] obj : orderDao.getOrderLines(id)) {

            orderLine = (OrderLine) obj[0];
            orderLine.setProduct((Product) obj[1]);
            orderLineArrayList.add(orderLine);
        }

        return orderLineArrayList;
    }
}
