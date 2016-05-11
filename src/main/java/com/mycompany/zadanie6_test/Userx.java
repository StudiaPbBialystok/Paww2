/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zadanie6_test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kamil
 */
@Entity
@Table(name = "USERX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userx.findAll", query = "SELECT u FROM Userx u"),
    @NamedQuery(name = "Userx.findById", query = "SELECT u FROM Userx u WHERE u.id = :id"),
    @NamedQuery(name = "Userx.findByEmail", query = "SELECT u FROM Userx u WHERE u.email = :email"),
    @NamedQuery(name = "Userx.findByFirstname", query = "SELECT u FROM Userx u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Userx.findByLastname", query = "SELECT u FROM Userx u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Userx.findByLastChristmas", query = "SELECT u FROM Userx u WHERE u.email = :email and u.password=:password"),
    @NamedQuery(name = "Userx.findByPassword", query = "SELECT u FROM Userx u WHERE u.password = :password")})
public class Userx implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 30)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(min = 6, max = 30)
    @Column(name = "PASSWORD")
    private String password;

    public Userx() {
    }

    public Userx(Integer id) {
        this.id = id;
    }

    public Userx(Integer id, String email, String lastname) {
        this.id = id;
        this.email = email;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Userx)) {
            return false;
        }
        Userx other = (Userx) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.zadanie6_test.Userx[ id=" + id + " ]";
    }

}
