package com.zegates.vozco.entities;


//
//import org.codehaus.jackson.annotate.JsonBackReference;
//import org.codehaus.jackson.annotate.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by sandaruwan on 3/15/16.
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="oid")
public class CustomerOrder {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oid;
    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL)@JsonIdentityReference(alwaysAsId = true) //@JsonManagedReference
    private List<OrderDetail> orderDetails;
    @ManyToOne @JsonIdentityReference(alwaysAsId = true)//@JsonBackReference
    private LogSession logSession;
    private String tpNo;
    private Date dateAdded;
    private Time timeAdded;
    private String address;
    private double total;
    private double discount;
    private double paidAmount;

    private boolean paid;
    @ManyToOne// @JsonBackReference
    private Customer customer;

    public LogSession getLogSession() {
        return logSession;
    }

    public void setLogSession(LogSession logSession) {
        this.logSession = logSession;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

//    public Orders(List<OrderDetail> orderDetails, Long oid, String custName, String tpNo, Date dateAdded, Time timeAdded, String address, double total, double discount, double paidAmount, LogSession logSession) {
//        this.orderDetails = orderDetails;
//        this.oid = oid;
//        this.custName = custName;
//        this.tpNo = tpNo;
//        this.dateAdded = dateAdded;
//        this.timeAdded = timeAdded;
//        this.address = address;
//        this.total = total;
//        this.discount = discount;
//        this.paidAmount = paidAmount;
//        this.logSession = logSession;
//    }
//
//    public Orders() {
//    }


    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getTpNo() {
        return tpNo;
    }

    public void setTpNo(String tpNo) {
        this.tpNo = tpNo;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the oid fields are not set
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }
}
