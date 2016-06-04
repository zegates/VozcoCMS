package com.zegates.vozco.entities;

import javax.persistence.*;

/**
 * Created by sandaruwan on 3/15/16.
 */
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int odid;
    @ManyToOne
    private CustomerOrder customerOrder;
    @ManyToOne
    private StockDetail stockDetail;

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public int getOdid() {
        return odid;
    }

    public void setOdid(int odid) {
        this.odid = odid;
    }

    public StockDetail getStockDetail() {
        return stockDetail;
    }

    public void setStockDetail(StockDetail stockDetail) {
        this.stockDetail = stockDetail;
    }
}
