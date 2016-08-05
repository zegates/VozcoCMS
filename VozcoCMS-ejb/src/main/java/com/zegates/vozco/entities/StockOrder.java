package com.zegates.vozco.entities;

//import org.codehaus.jackson.annotate.JsonBackReference;
//import org.codehaus.jackson.annotate.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by sandaruwan on 3/15/16.
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="soid")
public class StockOrder {

    @OneToMany(mappedBy = "stockOrder", cascade = CascadeType.ALL) @JsonIdentityReference(alwaysAsId = true) // @JsonManagedReference
    private List<StockDetail> supplyOrderDetails;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long soid;
    private Date dateAdded;
    private Time timeAdded;
    private double discount;
    private double total;
    @ManyToOne @JsonIdentityReference(alwaysAsId = true) // @JsonBackReference
    private Supplier supplier;
    @ManyToOne @JsonIdentityReference(alwaysAsId = true) // @JsonBackReference
    private LogSession logSession;
    private static final long serialVersionUID = 1L;



    public List<StockDetail> getSupplyOrderDetails() {
        return supplyOrderDetails;
    }

    public void setSupplyOrderDetails(List<StockDetail> supplyOrderDetails) {
        this.supplyOrderDetails = supplyOrderDetails;
    }

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Time getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Time timeAdded) {
        this.timeAdded = timeAdded;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public LogSession getLogSession() {
        return logSession;
    }

    public void setLogSession(LogSession logSession) {
        this.logSession = logSession;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
