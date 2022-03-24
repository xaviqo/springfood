package tech.xavi.springfood.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.xavi.springfood.models.Customer;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerDaoImp implements CustomerDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void register(Customer customer) {
        entityManager.merge(customer);
    }
}
