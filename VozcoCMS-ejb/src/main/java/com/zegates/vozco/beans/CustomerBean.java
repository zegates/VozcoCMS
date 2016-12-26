package com.zegates.vozco.beans;

import com.zegates.vozco.beans.remote.CustomerBeanRemote;
import com.zegates.vozco.entities.Customer;
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
 * Created by Sandaruwan on 1/21/16.
 */

@Stateful//(name = "CustomerBeanEJB")
public class CustomerBean implements CustomerBeanRemote{

    @PersistenceContext(unitName = "vozcopersist")
    private EntityManager em;

    public CustomerBean() {

    }

    @PostConstruct
    void init (){

    }

    public boolean createCustomer(Customer customer){
        try {
            Logger.log(Level.INFO, "Create Customer");
            em.persist(customer);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateCustomer(Customer customer){
        try {
            Logger.log(Level.INFO, "Updating the Customer");
            em.merge(customer);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public Customer authenticate(Customer customer){
        try {
            Logger.log(Level.INFO, "Customer Authenticating...");
            List results = em.createNamedQuery("authenticateCustomer")
                    .setParameter("uname", customer.getUsername())
                    .setParameter("pw", customer.getPassword())
                    .getResultList();
            if(results.size() > 0){
                return (Customer) results.get(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public List<Customer> findCustomers() {
        return findCustomers(true, -1, -1);
    }

    public List<Customer> findCustomers(int maxResults, int firstResult) {
        return findCustomers(false, maxResults, firstResult);
    }

    @Override
    public List<Customer> findCustomers(boolean all, int maxResults, int firstResult)  {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Customer.class));
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

    public List<Customer> findSearchedCustomers(Customer customer){
        try {
            Logger.log(Level.INFO, "Customer Searching...");
//            List<Customer> results = (List<Customer>) em.createNamedQuery("findCustomerFnameLname")
//                    .setParameter("fname", customer.getFname())
////                    .setParameter("lname", customer.getLname())
//                    .getResultList();
            List<Customer> results = (List<Customer>) em.createNamedQuery("findCustomerFname")
                    .setParameter("fname", customer.getFname()+"%")
                    .getResultList();
           return results;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getCustomerCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Customer> rt = cq.from(Customer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public long getLatesOrdersID() {
        int customerCount = getCustomerCount();

        List<Customer> os = findCustomers(customerCount, customerCount - 1);
        if (os != null && os.size() > 0) {
            Collections.reverse(os);
            Customer get = os.get(0);
            if (get != null) {
                return get.getCid() + 1;
            }
        }else{
            return 1L;
        }
        return 1L;
    }

}
