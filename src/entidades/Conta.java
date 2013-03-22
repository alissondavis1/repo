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
@Table(name = "contas", catalog = "acal", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Contas.findAll", query = "SELECT c FROM Contas c"),
//    @NamedQuery(name = "Contas.findById", query = "SELECT c FROM Contas c WHERE c.id = :id"),
//    @NamedQuery(name = "Contas.findByTaxarelogio", query = "SELECT c FROM Contas c WHERE c.taxarelogio = :taxarelogio"),
//    @NamedQuery(name = "Contas.findByDatapag", query = "SELECT c FROM Contas c WHERE c.datapag = :datapag"),
//    @NamedQuery(name = "Contas.findByDatavence", query = "SELECT c FROM Contas c WHERE c.datavence = :datavence"),
//    @NamedQuery(name = "Contas.findByObservacoes", query = "SELECT c FROM Contas c WHERE c.observacoes = :observacoes")})
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Taxa_relogio")
    private double taxarelogio;
    @Basic(optional = false)
    @Column(name = "Data_pag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datapag;
    @Basic(optional = false)
    @Column(name = "Data_vence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datavence;
    @Basic(optional = false)
    @Column(name = "Observacoes")
    private int observacoes;
    @JoinColumn(name = "Id_taxa", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Taxa idtaxa;
    @JoinColumn(name = "Id_numero_socio", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Socio idnumerosocio;

    public Conta() {
    }

    public Conta(Integer id) {
        this.id = id;
    }

    public Conta(Integer id, double taxarelogio, Date datapag, Date datavence, int observacoes) {
        this.id = id;
        this.taxarelogio = taxarelogio;
        this.datapag = datapag;
        this.datavence = datavence;
        this.observacoes = observacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTaxarelogio() {
        return taxarelogio;
    }

    public void setTaxarelogio(double taxarelogio) {
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

    public int getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(int observacoes) {
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
        return "entidades.Contas[ id=" + id + " ]";
    }
    
}
