package com.zegates.vozco.beans.remote;

import com.zegates.vozco.entities.CustomerOrder;

import java.util.List;

/**
 * Created by sandaruwan on 8/9/16.
 */
public interface CustomerOrderBeanRemote {

    public boolean createCustomerOrder(CustomerOrder customerOrder);

    public boolean updateCustomerOrder(CustomerOrder customerOrder);

    public List<CustomerOrder> findCustomerOrders();

    public List<CustomerOrder> findCustomerOrders(int maxResults, int firstResult);

    public List<CustomerOrder> findCustomerOrders(boolean all, int maxResults, int firstResult) ;

    public int getCustomerOrderCount();

    public long getLatestCustomerOrderID();
}
