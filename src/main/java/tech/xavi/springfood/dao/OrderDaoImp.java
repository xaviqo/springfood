package tech.xavi.springfood.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.xavi.springfood.models.OrderLine;
import tech.xavi.springfood.models.Orders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OrderDaoImp implements OrderDao{

    @PersistenceContext
    private EntityManager ordersEntityManager;

    @Override
    public List<Object[]> getOrders() {
        String query = "FROM Orders ord INNER JOIN ord.client";
        return ordersEntityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Object[]> getOrderLines(int id) {
        String query = "FROM OrderLine orl INNER JOIN orl.product WHERE orderid = :id";
        return ordersEntityManager.createQuery(query).setParameter("id",id).getResultList();
    }
}
