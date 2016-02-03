package com.zegates.vozco.factory;

import com.zegates.vozco.controller.CustomerController;

import javax.persistence.EntityManager;

/**
 * Created by sandaruwan on 1/12/16.
 */
public class ControllerFactory {

    private static final CustomerController customerController;

    static {
//        customerController = new CustomerController(EMFactory.getEmf());
        customerController = new CustomerController(null);
    }

//    public static CustomerController getCustomerController(EntityManager em){
    public static CustomerController getCustomerController(){
        return customerController;

    }
    public static CustomerController getCustomerController(EntityManager em){
        return new CustomerController(em);
    }
}
