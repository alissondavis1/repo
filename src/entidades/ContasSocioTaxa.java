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
@Table(name = "contas_socio_taxa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContasSocioTaxa.findAll", query = "SELECT c FROM ContasSocioTaxa c"),
    @NamedQuery(name = "ContasSocioTaxa.findById", query = "SELECT c FROM ContasSocioTaxa c WHERE c.id = :id"),
    @NamedQuery(name = "ContasSocioTaxa.findByDataPag", query = "SELECT c FROM ContasSocioTaxa c WHERE c.dataPag = :dataPag"),
    @NamedQuery(name = "ContasSocioTaxa.findByDataVence", query = "SELECT c FROM ContasSocioTaxa c WHERE c.dataVence = :dataVence"),
    @NamedQuery(name = "ContasSocioTaxa.findByTaxaRelogio", query = "SELECT c FROM ContasSocioTaxa c WHERE c.taxaRelogio = :taxaRelogio"),
    @NamedQuery(name = "ContasSocioTaxa.findByValor", query = "SELECT c FROM ContasSocioTaxa c WHERE c.valor = :valor"),
    @NamedQuery(name = "ContasSocioTaxa.findByCodigoSocio", query = "SELECT c FROM ContasSocioTaxa c WHERE c.codigoSocio = :codigoSocio"),
    @NamedQuery(name = "ContasSocioTaxa.findByNome", query = "SELECT c FROM ContasSocioTaxa c WHERE c.nome = :nome"),
    @NamedQuery(name = "ContasSocioTaxa.findBySobrenome", query = "SELECT c FROM ContasSocioTaxa c WHERE c.sobrenome = :sobrenome")})
public class ContasSocioTaxa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "dataPag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPag;
    @Basic(optional = false)
    @Column(name = "dataVence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVence;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxaRelogio")
    private BigDecimal taxaRelogio;
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "codigo_socio")
    private int codigoSocio;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "sobrenome")
    private String sobrenome;

    public ContasSocioTaxa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public BigDecimal getTaxaRelogio() {
        return taxaRelogio;
    }

    public void setTaxaRelogio(BigDecimal taxaRelogio) {
        this.taxaRelogio = taxaRelogio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getCodigoSocio() {
        return codigoSocio;
    }

    public void setCodigoSocio(int codigoSocio) {
        this.codigoSocio = codigoSocio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
}
