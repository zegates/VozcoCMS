package com.zegates.vozco.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by sandaruwan on 3/15/16.
 */
public class StockOrder {

    public List<StockDetail> getSupplyOrderDetails() {
        return supplyOrderDetails;
    }

    public void setSupplyOrderDetails(List<StockDetail> supplyOrderDetails) {
        this.supplyOrderDetails = supplyOrderDetails;
    }

    @OneToMany(mappedBy = "supplyOrder", cascade = CascadeType.ALL)
    private List<StockDetail> supplyOrderDetails;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long soid;
    private Date dateAdded;
    private Time timeAdded;
    private double discount;
    private double total;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne
    private LogSession logSession;

}
