package com.zegates.vozco.entities;

import javassist.compiler.ast.StringL;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sandaruwan on 1/12/16.
 */
@Entity
@NamedQuery(
        name="authenticateCustomer",
        query="SELECT c FROM Customer c WHERE c.username=:uname AND c.password=:pw"
)
public class Customer {

    @Id
    private String cid;

    private String fname;
    private String lname;
    private String address;
    private String telephone;
    private String password;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getTelephone() { return telephone; }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
