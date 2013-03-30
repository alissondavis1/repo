/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c"),
    @NamedQuery(name = "Conta.findById", query = "SELECT c FROM Conta c WHERE c.id = :id"),
    @NamedQuery(name = "Conta.findByDataPag", query = "SELECT c FROM Conta c WHERE c.dataPag = :dataPag"),
    @NamedQuery(name = "Conta.findByDataVence", query = "SELECT c FROM Conta c WHERE c.dataVence = :dataVence"),
    @NamedQuery(name = "Conta.findByTaxaSocio", query = "SELECT c FROM Conta c WHERE c.taxaSocio = :taxaSocio"),
    @NamedQuery(name = "Conta.findByTaxaRelogio", query = "SELECT c FROM Conta c WHERE c.taxaRelogio = :taxaRelogio")})
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataPag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPag;
    @Basic(optional = false)
    @Column(name = "dataVence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVence;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxaSocio")
    private BigDecimal taxaSocio;
    @Column(name = "taxaRelogio")
    private Double taxaRelogio;
    @JoinColumn(name = "idNumeroSocio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Socio idNumeroSocio;

    public Conta() {
    }

    public Conta(Integer id) {
        this.id = id;
    }

    public Conta(Integer id, Date dataVence) {
        this.id = id;
        this.dataVence = dataVence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPag() {
        return dataPag;
    }

    public void setDataPag(Date dataPag) {
        this.dataPag = dataPag;
    }

    public Date getDataVence() {
        return dataVence;
    }

    public void setDataVence(Date dataVence) {
        this.dataVence = dataVence;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public BigDecimal getTaxaSocio() {
        return taxaSocio;
    }

    public void setTaxaSocio(BigDecimal taxaSocio) {
        this.taxaSocio = taxaSocio;
    }

    public Double getTaxaRelogio() {
        return taxaRelogio;
    }

    public void setTaxaRelogio(Double taxaRelogio) {
        this.taxaRelogio = taxaRelogio;
    }

    public Socio getIdNumeroSocio() {
        return idNumeroSocio;
    }

    public void setIdNumeroSocio(Socio idNumeroSocio) {
        this.idNumeroSocio = idNumeroSocio;
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
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Conta[ id=" + id + " ]";
    }
    
}
