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
@Table(name = "indemnites")
@NamedQueries({
    @NamedQuery(name = "Indemnite.findAll", query = "SELECT i FROM Indemnite i")})
public class Indemnite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "BASE_HEURE")
    private double baseHeure;
    @Basic(optional = false)
    @Column(name = "ENTRETIEN_JOUR")
    private double entretienJour;
    @Basic(optional = false)
    @Column(name = "INDEMNITES_CP")
    private double indemnitesCp;
    @Basic(optional = false)
    @Column(name = "INDICE")
    private int indice;
    @Basic(optional = false)
    @Column(name = "REPAS_JOUR")
    private double repasJour;
    @Basic(optional = false)
    @Column(name = "VERSION")
    private int version;

    public Indemnite() {
    }

    public Indemnite(Long id) {
        this.id = id;
    }

    public Indemnite(Long id, double baseHeure, double entretienJour, double indemnitesCp, int indice, double repasJour, int version) {
        this.id = id;
        this.baseHeure = baseHeure;
        this.entretienJour = entretienJour;
        this.indemnitesCp = indemnitesCp;
        this.indice = indice;
        this.repasJour = repasJour;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBaseHeure() {
        return baseHeure;
    }

    public void setBaseHeure(double baseHeure) {
        this.baseHeure = baseHeure;
    }

    public double getEntretienJour() {
        return entretienJour;
    }

    public void setEntretienJour(double entretienJour) {
        this.entretienJour = entretienJour;
    }

    public double getIndemnitesCp() {
        return indemnitesCp;
    }

    public void setIndemnitesCp(double indemnitesCp) {
        this.indemnitesCp = indemnitesCp;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public double getRepasJour() {
        return repasJour;
    }

    public void setRepasJour(double repasJour) {
        this.repasJour = repasJour;
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
        if (!(object instanceof Indemnite)) {
            return false;
        }
        Indemnite other = (Indemnite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Indemnite[ id=" + id + " ]";
    }
    
}
