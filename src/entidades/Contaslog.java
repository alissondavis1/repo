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
import javax.persistence.Lob;
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
@Table(name = "contaslog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contaslog.findAll", query = "SELECT c FROM Contaslog c"),
    @NamedQuery(name = "Contaslog.findById", query = "SELECT c FROM Contaslog c WHERE c.id = :id"),
    @NamedQuery(name = "Contaslog.findByIdOriginal", query = "SELECT c FROM Contaslog c WHERE c.idOriginal = :idOriginal"),
    @NamedQuery(name = "Contaslog.findByDataPag", query = "SELECT c FROM Contaslog c WHERE c.dataPag = :dataPag"),
    @NamedQuery(name = "Contaslog.findByDataVence", query = "SELECT c FROM Contaslog c WHERE c.dataVence = :dataVence"),
    @NamedQuery(name = "Contaslog.findByTaxaSocio", query = "SELECT c FROM Contaslog c WHERE c.taxaSocio = :taxaSocio"),
    @NamedQuery(name = "Contaslog.findByTaxaRelogio", query = "SELECT c FROM Contaslog c WHERE c.taxaRelogio = :taxaRelogio"),
    @NamedQuery(name = "Contaslog.findByIdNumeroSocio", query = "SELECT c FROM Contaslog c WHERE c.idNumeroSocio = :idNumeroSocio"),
    @NamedQuery(name = "Contaslog.findByHoraAlteracao", query = "SELECT c FROM Contaslog c WHERE c.horaAlteracao = :horaAlteracao"),
    @NamedQuery(name = "Contaslog.findByTipo", query = "SELECT c FROM Contaslog c WHERE c.tipo = :tipo")})
public class Contaslog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idOriginal")
    private Integer idOriginal;
    @Column(name = "dataPag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPag;
    @Column(name = "dataVence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVence;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "taxaSocio")
    private Integer taxaSocio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxaRelogio")
    private BigDecimal taxaRelogio;
    @Column(name = "idNumeroSocio")
    private Integer idNumeroSocio;
    @Column(name = "horaAlteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaAlteracao;
    @Column(name = "tipo")
    private String tipo;

    public Contaslog() {
    }

    public Contaslog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOriginal() {
        return idOriginal;
    }

    public void setIdOriginal(Integer idOriginal) {
        this.idOriginal = idOriginal;
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

    public Integer getTaxaSocio() {
        return taxaSocio;
    }

    public void setTaxaSocio(Integer taxaSocio) {
        this.taxaSocio = taxaSocio;
    }

    public BigDecimal getTaxaRelogio() {
        return taxaRelogio;
    }

    public void setTaxaRelogio(BigDecimal taxaRelogio) {
        this.taxaRelogio = taxaRelogio;
    }

    public Integer getIdNumeroSocio() {
        return idNumeroSocio;
    }

    public void setIdNumeroSocio(Integer idNumeroSocio) {
        this.idNumeroSocio = idNumeroSocio;
    }

    public Date getHoraAlteracao() {
        return horaAlteracao;
    }

    public void setHoraAlteracao(Date horaAlteracao) {
        this.horaAlteracao = horaAlteracao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Contaslog)) {
            return false;
        }
        Contaslog other = (Contaslog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Contaslog[ id=" + id + " ]";
    }
    
}
