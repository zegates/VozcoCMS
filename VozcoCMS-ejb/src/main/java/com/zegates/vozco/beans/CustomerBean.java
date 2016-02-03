package com.zegates.vozco.beans;

import com.zegates.vozco.beans.remote.CustomerBeanRemote;
import com.zegates.vozco.entities.Customer;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sandaruwan on 1/21/16.
 */
@Stateful//(name = "CustomerBeanEJB")
public class CustomerBean implements CustomerBeanRemote{

    @PersistenceContext(unitName = "vozcopersist")
    private EntityManager em;

    public CustomerBean() {

    }


    public boolean createCustomer(Customer customer){
        try {

            System.out.println("Creating the Customer");
            em.persist(customer);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }finally {
//            t.close();
        }
        return true;
    }




}
