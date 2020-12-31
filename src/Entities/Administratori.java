/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cosmi
 */
@Entity
@Table(name = "ADMINISTRATORI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administratori.findAll", query = "SELECT a FROM Administratori a")
    , @NamedQuery(name = "Administratori.findByIdAdmin", query = "SELECT a FROM Administratori a WHERE a.idAdmin = :idAdmin")
    , @NamedQuery(name = "Administratori.findByNumePrenumeCont", query = "SELECT a FROM Administratori a WHERE a.numePrenumeCont = :numePrenumeCont")
    , @NamedQuery(name = "Administratori.findByParolaCont", query = "SELECT a FROM Administratori a WHERE a.parolaCont = :parolaCont")})
public class Administratori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ADMIN")
    private Short idAdmin;
    @Basic(optional = false)
    @Column(name = "NUME_PRENUME_CONT")
    private String numePrenumeCont;
    @Basic(optional = false)
    @Column(name = "PAROLA_CONT")
    private String parolaCont;

    public Administratori() {
    }

    public Administratori(Short idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Administratori(Short idAdmin, String numePrenumeCont, String parolaCont) {
        this.idAdmin = idAdmin;
        this.numePrenumeCont = numePrenumeCont;
        this.parolaCont = parolaCont;
    }

    public Short getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Short idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNumePrenumeCont() {
        return numePrenumeCont;
    }

    public void setNumePrenumeCont(String numePrenumeCont) {
        this.numePrenumeCont = numePrenumeCont;
    }

    public String getParolaCont() {
        return parolaCont;
    }

    public void setParolaCont(String parolaCont) {
        this.parolaCont = parolaCont;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdmin != null ? idAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administratori)) {
            return false;
        }
        Administratori other = (Administratori) object;
        if ((this.idAdmin == null && other.idAdmin != null) || (this.idAdmin != null && !this.idAdmin.equals(other.idAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Administratori[ idAdmin=" + idAdmin + " ]";
    }
    
}
