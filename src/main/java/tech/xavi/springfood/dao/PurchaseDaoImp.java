package tech.xavi.springfood.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PurchaseDaoImp implements PurchaseDao{

    @PersistenceContext
    private EntityManager purchaseEntityManager;

    @Override
    public double sumPurchaseTotalByDate(){
        String query = "SELECT sum(p.total) FROM Purchase p";
        return purchaseEntityManager.createQuery(query).getFirstResult();
    }
}
