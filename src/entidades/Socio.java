/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "socio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s"),
    @NamedQuery(name = "Socio.findById", query = "SELECT s FROM Socio s WHERE s.id = :id"),
    @NamedQuery(name = "Socio.findByDataVence", query = "SELECT s FROM Socio s WHERE s.dataVence = :dataVence"),
    @NamedQuery(name = "Socio.findByDataAprovacao", query = "SELECT s FROM Socio s WHERE s.dataAprovacao = :dataAprovacao"),
    @NamedQuery(name = "Socio.findByDataMatricula", query = "SELECT s FROM Socio s WHERE s.dataMatricula = :dataMatricula"),
    @NamedQuery(name = "Socio.findByNumeroSocio", query = "SELECT s FROM Socio s WHERE s.numeroSocio = :numeroSocio")})
public class Socio implements Serializable {
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
    @JoinColumn(name = "idCategoriaSocio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoriaSocio idCategoriaSocio;
    @JoinColumn(name = "idPessoa", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Pessoa idPessoa;
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
        this.id = id;
    }

    public Date getDataVence() {
        return dataVence;
    }

    public void setDataVence(Date dataVence) {
        this.dataVence = dataVence;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @XmlTransient
    public List<Conta> getContaList() {
        return contaList;
    }

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }

    public CategoriaSocio getIdCategoriaSocio() {
        return idCategoriaSocio;
    }

    public void setIdCategoriaSocio(CategoriaSocio idCategoriaSocio) {
        this.idCategoriaSocio = idCategoriaSocio;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
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
    
}
