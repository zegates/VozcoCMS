package com.zegates.vozco.entities;

import java.sql.Date;

/**
 * Created by sandaruwan on 3/15/16.
 */
public class CustomerOrder {

    private Customer customer;
    private Date addedDated;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
