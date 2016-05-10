/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zadanie6_test;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kamil
 */
@Entity
@Table(name = "STOP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stop.findAll", query = "SELECT s FROM Stop s"),
    @NamedQuery(name = "Stop.findById", query = "SELECT s FROM Stop s WHERE s.id = :id"),
    @NamedQuery(name = "Stop.findByArrival", query = "SELECT s FROM Stop s WHERE s.arrival = :arrival"),
    @NamedQuery(name = "Stop.findAfterDate", query = "SELECT s FROM Stop s WHERE s.arrival > :date"),
    @NamedQuery(name = "Stop.findByLatitude", query = "SELECT s FROM Stop s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "Stop.findByLongitude", query = "SELECT s FROM Stop s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "Stop.findByName", query = "SELECT s FROM Stop s WHERE s.name = :name"),
    @NamedQuery(name = "Stop.findByTripid", query = "SELECT s FROM Stop s WHERE s.tripid = :tripid")})
public class Stop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARRIVAL")
    @Temporal(TemporalType.DATE)
    private Date arrival;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LATITUDE")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUDE")
    private double longitude;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRIPID")
    private int tripid;

    public Stop() {
    }

    public Stop(Integer id) {
        this.id = id;
    }

    public Stop(Integer id, Date arrival, double latitude, double longitude, int orderx, int tripid) {
        this.id = id;
        this.arrival = arrival;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tripid = tripid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTripid() {
        return tripid;
    }

    public void setTripid(int tripid) {
        this.tripid = tripid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stop)) {
            return false;
        }
        Stop other = (Stop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.zadanie6_test.Stop[ id=" + id + " ]";
    }
    
}
