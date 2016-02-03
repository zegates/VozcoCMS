package com.zegates.vozco.controller;

import com.zegates.vozco.entities.Customer;

import javax.persistence.*;

/**
 * Created by sandaruwan on 1/12/16.
 */
public class CustomerController {

    @PersistenceContext( unitName = "vozcopersist")
    private EntityManager em;
//    Session session = HibernateFactory.getSession();

    @PersistenceUnit(unitName = "vozcopersist")
    private EntityManagerFactory emf;




    public CustomerController(EntityManager em) {
        this.em = em;
    }

    public boolean createCustomer(Customer customer){

        System.out.println("Created the customer in the CController");
//        try {
//            EntityManager emx = emf.createEntityManager();
//            emx.getTransaction().begin();
//            System.out.println("Creating the Customer");
//            emx.persist(customer);
//            emx.getTransaction().commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }finally {
////            t.close();
//        }
        return true;
    }



}
