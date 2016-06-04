package com.zegates.vozco.beans.remote;

import com.zegates.vozco.entities.Customer;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Sandaruwan on 1/21/16.
 */
@Local
public interface CustomerBeanRemote {

    public boolean createCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

    public Customer authenticate(Customer customer);

    public List<Customer> findCustomers();

    public List<Customer> findCustomers(int maxResults, int firstResult);

    public List<Customer> findCustomers(boolean all, int maxResults, int firstResult) ;

    public List<Customer> findSearchedCustomers(Customer customer);

}
