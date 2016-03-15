package com.zegates.vozco.beans;

import com.zegates.vozco.beans.remote.CustomerBeanRemote;
import com.zegates.vozco.entities.Customer;
import com.zegates.vozco.util.Logger;
import org.hibernate.annotations.NamedQuery;
import sun.rmi.runtime.Log;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
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


    public List<Customer> findOrdersEntities() {
        return findCustomers(true, -1, -1);
    }

    public List<Customer> findOrdersEntities(int maxResults, int firstResult) {
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


}
