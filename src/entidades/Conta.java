/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "contas")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c"),
//    @NamedQuery(name = "Conta.findById", query = "SELECT c FROM Conta c WHERE c.id = :id"),
//    @NamedQuery(name = "Conta.findByTaxarelogio", query = "SELECT c FROM Conta c WHERE c.taxarelogio = :taxarelogio"),
//    @NamedQuery(name = "Conta.findByDatapag", query = "SELECT c FROM Conta c WHERE c.datapag = :datapag"),
//    @NamedQuery(name = "Conta.findByDatavence", query = "SELECT c FROM Conta c WHERE c.datavence = :datavence"),
//    @NamedQuery(name = "Conta.findByObservacoes", query = "SELECT c FROM Conta c WHERE c.observacoes = :observacoes")})
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Taxa_relogio")
    private Double taxarelogio;
    @Column(name = "Data_pag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datapag;
    @Basic(optional = false)
    @Column(name = "Data_vence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datavence;
    @Column(name = "Observacoes")
    private Integer observacoes;
    @JoinColumn(name = "Id_taxa", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Taxa idtaxa;
    @JoinColumn(name = "Id_numero_socio", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Socio idnumerosocio;

    public Conta() {
    }

    public Conta(Double taxarelogio, Date datapag, Date datavence, Integer observacoes, Taxa idtaxa, Socio idnumerosocio) {
        this.taxarelogio = taxarelogio;
        this.datapag = datapag;
        this.datavence = datavence;
        this.observacoes = observacoes;
        this.idtaxa = idtaxa;
        this.idnumerosocio = idnumerosocio;
    }

  
    public Integer getId() {
        return id;
    }


    public Double getTaxarelogio() {
        return taxarelogio;
    }

    public void setTaxarelogio(Double taxarelogio) {
        this.taxarelogio = taxarelogio;
    }

    public Date getDatapag() {
        return datapag;
    }

    public void setDatapag(Date datapag) {
        this.datapag = datapag;
    }

    public Date getDatavence() {
        return datavence;
    }

    public void setDatavence(Date datavence) {
        this.datavence = datavence;
    }

    public Integer getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(Integer observacoes) {
        this.observacoes = observacoes;
    }

    public Taxa getIdtaxa() {
        return idtaxa;
    }

    public void setIdtaxa(Taxa idtaxa) {
        this.idtaxa = idtaxa;
    }

    public Socio getIdnumerosocio() {
        return idnumerosocio;
    }

    public void setIdnumerosocio(Socio idnumerosocio) {
        this.idnumerosocio = idnumerosocio;
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
