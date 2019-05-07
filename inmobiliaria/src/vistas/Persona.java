/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "persona", catalog = "inmobiliaria2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findById", query = "SELECT p FROM Persona p WHERE p.id = :id")
    , @NamedQuery(name = "Persona.findByNombreCompleto", query = "SELECT p FROM Persona p WHERE p.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Persona.findByDocumento", query = "SELECT p FROM Persona p WHERE p.documento = :documento")
    , @NamedQuery(name = "Persona.findByCelular", query = "SELECT p FROM Persona p WHERE p.celular = :celular")})
public class Persona implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombreCompleto")
    private String nombreCompleto;
    @Basic(optional = false)
    @Column(name = "documento")
    private long documento;
    @Basic(optional = false)
    @Column(name = "celular")
    private long celular;

    public Persona() {
    }

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(Integer id, String nombreCompleto, long documento, long celular) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.celular = celular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        String oldNombreCompleto = this.nombreCompleto;
        this.nombreCompleto = nombreCompleto;
        changeSupport.firePropertyChange("nombreCompleto", oldNombreCompleto, nombreCompleto);
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        long oldDocumento = this.documento;
        this.documento = documento;
        changeSupport.firePropertyChange("documento", oldDocumento, documento);
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        long oldCelular = this.celular;
        this.celular = celular;
        changeSupport.firePropertyChange("celular", oldCelular, celular);
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vistas.Persona[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
