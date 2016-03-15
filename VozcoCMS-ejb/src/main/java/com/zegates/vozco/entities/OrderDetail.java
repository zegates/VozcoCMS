package com.zegates.vozco.entities;

/**
 * Created by sandaruwan on 3/15/16.
 */
public class OrderDetail {

    private CustomerOrder customerOrder;
    private StockDetail stockDetail;

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}
