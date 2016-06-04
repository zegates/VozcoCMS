package com.zegates.vozco.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by sandaruwan on 3/15/16.
 */
@Entity
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private boolean isPrefix;
    private String shortName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
