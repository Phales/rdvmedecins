/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author j.fasquel
 */
@Entity
@Table(name = "cotisations")
@NamedQueries({
    @NamedQuery(name = "Cotisation.findAll", query = "SELECT c FROM Cotisation c")})
public class Cotisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "CSGD")
    private double csgd;
    @Basic(optional = false)
    @Column(name = "CSGRDS")
    private double csgrds;
    @Basic(optional = false)
    @Column(name = "RETRAITE")
    private double retraite;
    @Basic(optional = false)
    @Column(name = "SECU")
    private double secu;
    @Basic(optional = false)
    @Column(name = "VERSION")
    private int version;

    public Cotisation() {
    }

    public Cotisation(Long id) {
        this.id = id;
    }

    public Cotisation(Long id, double csgd, double csgrds, double retraite, double secu, int version) {
        this.id = id;
        this.csgd = csgd;
        this.csgrds = csgrds;
        this.retraite = retraite;
        this.secu = secu;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCsgd() {
        return csgd;
    }

    public void setCsgd(double csgd) {
        this.csgd = csgd;
    }

    public double getCsgrds() {
        return csgrds;
    }

    public void setCsgrds(double csgrds) {
        this.csgrds = csgrds;
    }

    public double getRetraite() {
        return retraite;
    }

    public void setRetraite(double retraite) {
        this.retraite = retraite;
    }

    public double getSecu() {
        return secu;
    }

    public void setSecu(double secu) {
        this.secu = secu;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
        if (!(object instanceof Cotisation)) {
            return false;
        }
        Cotisation other = (Cotisation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Cotisation[ id=" + id + " ]";
    }
    
}
