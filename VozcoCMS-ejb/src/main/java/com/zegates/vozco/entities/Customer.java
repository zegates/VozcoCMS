package com.zegates.vozco.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sandaruwan on 1/12/16.
 */
@Entity
public class Customer {

    @Id
    private String cid;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
