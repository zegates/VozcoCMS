package com.zegates.vozco.beans;

import com.zegates.vozco.beans.remote.CustomerOrderBeanRemote;
import com.zegates.vozco.entities.CustomerOrder;
import com.zegates.vozco.util.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by sandaruwan on 8/9/16.
 */
@Stateful //(name = "CustomerOrderBeanEJB")
public class CustomerOrderBean implements CustomerOrderBeanRemote {
    @PersistenceContext(unitName = "vozcopersist")
    private EntityManager em;
    

    @PostConstruct
    void init (){

    }

    public boolean createCustomerOrder(CustomerOrder customerOrder){
        try {
            Logger.log(Level.INFO, "Create CustomerOrder");
            em.persist(customerOrder);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateCustomerOrder(CustomerOrder customerOrder){
        try {
            Logger.log(Level.INFO, "Updating the CustomerOrder");
            em.merge(customerOrder);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }


    public List<CustomerOrder> findCustomerOrders() {
        return findCustomerOrders(true, -1, -1);
    }

    public List<CustomerOrder> findCustomerOrders(int maxResults, int firstResult) {
        return findCustomerOrders(false, maxResults, firstResult);
    }

    @Override
    public List<CustomerOrder> findCustomerOrders(boolean all, int maxResults, int firstResult)  {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CustomerOrder.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

//    public List<CustomerOrder> findSearchedCustomerOrders(CustomerOrder customerOrder){
//        try {
//            Logger.log(Level.INFO, "CustomerOrder Searching...");
//            List<CustomerOrder> results = (List<CustomerOrder>) em.createNamedQuery("findCustomerOrderFname")
//                    .setParameter("fname", customerOrder.getFname()+"%")
//                    .getResultList();
//            return results;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }

    public int getCustomerOrderCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CustomerOrder> rt = cq.from(CustomerOrder.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public long getLatestCustomerOrderID() {
        int customerOrderCount = getCustomerOrderCount();
        List<CustomerOrder> os = findCustomerOrders(customerOrderCount, customerOrderCount - 1);
        if (os != null && os.size() > 0) {
            Collections.reverse(os);
            CustomerOrder get = os.get(0);
            if (get != null) {
                return get.getOid() + 1;
            }
        }else{
            return 1L;
        }
        return 1L;
    }

}
