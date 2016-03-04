package com.zegates.vozco.beans.remote;

import com.zegates.vozco.entities.Customer;

import javax.ejb.Local;

/**
 * Created by sandaruwan on 1/21/16.
 */
@Local
public interface CustomerBeanRemote {

    public boolean createCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

}
