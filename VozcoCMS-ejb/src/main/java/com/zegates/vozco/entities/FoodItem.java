package com.zegates.vozco.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import org.codehaus.jackson.annotate.JsonBackReference;
//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by sandaruwan on 3/15/16.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name = "findFoodItemForCategory",
                query = "SELECT fi FROM FoodItem fi WHERE fi.foodCategory=:fcID"
        )
})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="fid")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fid;
    private String itemName;
    @OneToOne @JsonIdentityReference(alwaysAsId = false) //@JsonBackReference
    private Metric metric;
    @ManyToOne @JsonIdentityReference(alwaysAsId = false) //@JsonBackReference
    private FoodCategory foodCategory;
    @OneToMany(mappedBy = "item") @JsonIdentityReference(alwaysAsId = true)//@JsonManagedReference
    private List<StockDetail>  stockDetails;
    @Column(length = 300)
    private String description;

  //  @JsonIgnore
    public List<StockDetail> getStockDetails() {
        return stockDetails;
    }

    public void setStockDetails(List<StockDetail> stockDetails) {
        this.stockDetails = stockDetails;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
