package com.zegates.vozco.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by sandaruwan on 3/15/16.
 */
@Entity
public class Supplier {

    public List<StockOrder> getStockOrders() {
        return stockOrders;
    }

    public void setStockOrders(List<StockOrder> stockOrders) {
        this.stockOrders = stockOrders;
    }

    @OneToMany(mappedBy = "supplier")
    private List<StockOrder> stockOrders;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long suid;
    private String name;
    private Date dateAdded;
    private Time timeAdded;
    private String address;
    private String tpno;
    private String compName;
    private String email;


}
