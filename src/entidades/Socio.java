/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "socio")
@XmlRootElement

public class Socio implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataVence")
    @Temporal(TemporalType.DATE)
    private Date dataVence;
    @Column(name = "dataAprovacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAprovacao;
    @Basic(optional = false)
    @Column(name = "dataMatricula")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMatricula;
    @Basic(optional = false)
    @Column(name = "numeroSocio")
    private int numeroSocio;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNumeroSocio")
    private List<Conta> contaList;
    @JoinColumn(name = "idPessoa", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Pessoa idPessoa;
    @JoinColumn(name = "idCategoriaSocio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoriasocio idCategoriaSocio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCedente")
    private List<Entrada> entradaList;

    public Socio() {
    }

    public Socio(Integer id) {
        this.id = id;
    }

    public Socio(Integer id, Date dataMatricula, int numeroSocio) {
        this.id = id;
        this.dataMatricula = dataMatricula;
        this.numeroSocio = numeroSocio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getDataVence() {
        return dataVence;
    }

    public void setDataVence(Date dataVence) {
        Date oldDataVence = this.dataVence;
        this.dataVence = dataVence;
        changeSupport.firePropertyChange("dataVence", oldDataVence, dataVence);
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        Date oldDataAprovacao = this.dataAprovacao;
        this.dataAprovacao = dataAprovacao;
        changeSupport.firePropertyChange("dataAprovacao", oldDataAprovacao, dataAprovacao);
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        Date oldDataMatricula = this.dataMatricula;
        this.dataMatricula = dataMatricula;
        changeSupport.firePropertyChange("dataMatricula", oldDataMatricula, dataMatricula);
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        int oldNumeroSocio = this.numeroSocio;
        this.numeroSocio = numeroSocio;
        changeSupport.firePropertyChange("numeroSocio", oldNumeroSocio, numeroSocio);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        String oldObservacao = this.observacao;
        this.observacao = observacao;
        changeSupport.firePropertyChange("observacao", oldObservacao, observacao);
    }

    @XmlTransient
    public List<Conta> getContaList() {
        return contaList;
    }

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Categoriasocio getIdCategoriaSocio() {
        return idCategoriaSocio;
    }

    public void setIdCategoriaSocio(Categoriasocio idCategoriaSocio) {
        Categoriasocio oldIdCategoriaSocio = this.idCategoriaSocio;
        this.idCategoriaSocio = idCategoriaSocio;
        changeSupport.firePropertyChange("idCategoriaSocio", oldIdCategoriaSocio, idCategoriaSocio);
    }

    @XmlTransient
    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
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
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Socio[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
