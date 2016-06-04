/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.vozco.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Sandaruwan
 */
@Entity
public class LogUser implements Serializable {

    @OneToMany(mappedBy = "logUser")
    private List<LogSession> logSessions;

    public List<LogSession> getLogSessions() {
        return logSessions;
    }

    public void setLogSessions(List<LogSession> logSessions) {
        this.logSessions = logSessions;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    private String name;
    private String address;
    private String tpno;
    private String username;
    private String pw;
    private Date dateAdded;
    private Time timeAdded;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTpno() {
        return tpno;
    }

    public void setTpno(String tpno) {
        this.tpno = tpno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the uid fields are not set
        if (!(object instanceof LogUser)) {
            return false;
        }
        LogUser other = (LogUser) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.User[ uid=" + uid + " ]";
    }
}
