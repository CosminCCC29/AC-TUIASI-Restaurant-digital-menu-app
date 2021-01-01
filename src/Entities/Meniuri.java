/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cosmi
 */
@Entity
@Table(name = "MENIURI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meniuri.findAll", query = "SELECT m FROM Meniuri m")
    , @NamedQuery(name = "Meniuri.findByNrMeniu", query = "SELECT m FROM Meniuri m WHERE m.nrMeniu = :nrMeniu")
    , @NamedQuery(name = "Meniuri.findByNumeMeniu", query = "SELECT m FROM Meniuri m WHERE m.numeMeniu = :numeMeniu")
    , @NamedQuery(name = "Meniuri.findByDataCrearii", query = "SELECT m FROM Meniuri m WHERE m.dataCrearii = :dataCrearii")})
public class Meniuri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NR_MENIU")
    private Short nrMeniu;
    @Basic(optional = false)
    @Column(name = "NUME_MENIU")
    private String numeMeniu;
    @Basic(optional = false)
    @Column(name = "DATA_CREARII")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCrearii;
    @Lob
    @Column(name = "DETALII_SUPLIMENTARE_MENIU")
    private String detaliiSuplimentareMeniu;
    @JoinColumn(name = "ADMINISTRATORI_ID_ADMIN", referencedColumnName = "ID_ADMIN")
    @ManyToOne(optional = false)
    private Administratori administratoriIdAdmin;

    public Meniuri() {
    }

    public Meniuri(Short nrMeniu) {
        this.nrMeniu = nrMeniu;
    }

    public Meniuri(Short nrMeniu, String numeMeniu, Date dataCrearii) {
        this.nrMeniu = nrMeniu;
        this.numeMeniu = numeMeniu;
        this.dataCrearii = dataCrearii;
    }

    public Short getNrMeniu() {
        return nrMeniu;
    }

    public void setNrMeniu(Short nrMeniu) {
        this.nrMeniu = nrMeniu;
    }

    public String getNumeMeniu() {
        return numeMeniu;
    }

    public void setNumeMeniu(String numeMeniu) {
        this.numeMeniu = numeMeniu;
    }

    public Date getDataCrearii() {
        return dataCrearii;
    }

    public void setDataCrearii(Date dataCrearii) {
        this.dataCrearii = dataCrearii;
    }

    public String getDetaliiSuplimentareMeniu() {
        return detaliiSuplimentareMeniu;
    }

    public void setDetaliiSuplimentareMeniu(String detaliiSuplimentareMeniu) {
        this.detaliiSuplimentareMeniu = detaliiSuplimentareMeniu;
    }

    public Administratori getAdministratoriIdAdmin() {
        return administratoriIdAdmin;
    }

    public void setAdministratoriIdAdmin(Administratori administratoriIdAdmin) {
        this.administratoriIdAdmin = administratoriIdAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrMeniu != null ? nrMeniu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meniuri)) {
            return false;
        }
        Meniuri other = (Meniuri) object;
        if ((this.nrMeniu == null && other.nrMeniu != null) || (this.nrMeniu != null && !this.nrMeniu.equals(other.nrMeniu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Meniuri[ nrMeniu=" + nrMeniu + " ]";
    }
    
}
