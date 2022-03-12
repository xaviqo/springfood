package tech.xavi.springfood.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.xavi.springfood.dao.OrderDao;
import tech.xavi.springfood.models.Orders;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderDao orderDao;


//    @GetMapping("/getOrder/{id}")
//    public Order getOrder(@PathVariable int id){
//
//        Order order = new Order();
//        order.setId(1);
//        order.setClient(1);
//        order.setLines(3);
//        order.setDate(LocalDateTime.now());
//        order.setCity("Barcelona");
//        order.setStreet("Figuera 48");
//        order.setTotal(13.37);
//        order.setSale(0);
//        order.setState(true);
//
//        return order;
//    }

    @GetMapping("/getOrders")
    public List<Orders> getOrders(){
        return orderDao.getOrders();
    }

    @GetMapping("/getOrderLines/{id}")
    public List<Orders> getOrderLines(@PathVariable int id){
        return orderDao.getOrderLines(id);
    }
}
