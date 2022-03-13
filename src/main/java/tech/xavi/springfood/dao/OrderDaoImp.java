package tech.xavi.springfood.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.xavi.springfood.models.Orders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OrderDaoImp implements OrderDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Orders> getOrders() {
        String query = "FROM Orders ord INNER JOIN Client cli ON ord.client = cli.id";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Orders> getOrderLines(int id) {
        String query = "FROM OrderLine WHERE orderid = :id";
        return entityManager.createQuery(query).setParameter("id",id).getResultList();
    }
}
