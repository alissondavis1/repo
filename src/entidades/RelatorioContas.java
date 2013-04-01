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
@Table(name = "relatorio_contas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatorioContas.findAll", query = "SELECT r FROM RelatorioContas r"),
    @NamedQuery(name = "RelatorioContas.findById", query = "SELECT r FROM RelatorioContas r WHERE r.id = :id"),
    @NamedQuery(name = "RelatorioContas.findByDataPag", query = "SELECT r FROM RelatorioContas r WHERE r.dataPag = :dataPag"),
    @NamedQuery(name = "RelatorioContas.findByDataVence", query = "SELECT r FROM RelatorioContas r WHERE r.dataVence = :dataVence"),
    @NamedQuery(name = "RelatorioContas.findByTaxaValor", query = "SELECT r FROM RelatorioContas r WHERE r.taxaValor = :taxaValor"),
    @NamedQuery(name = "RelatorioContas.findByRelogio", query = "SELECT r FROM RelatorioContas r WHERE r.relogio = :relogio"),
    @NamedQuery(name = "RelatorioContas.findByCodigoSocio", query = "SELECT r FROM RelatorioContas r WHERE r.codigoSocio = :codigoSocio"),
    @NamedQuery(name = "RelatorioContas.findByNome", query = "SELECT r FROM RelatorioContas r WHERE r.nome = :nome"),
    @NamedQuery(name = "RelatorioContas.findBySobrenome", query = "SELECT r FROM RelatorioContas r WHERE r.sobrenome = :sobrenome")})
public class RelatorioContas implements Serializable {
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
    @Column(name = "Taxa_Valor")
    private BigDecimal taxaValor;
    @Column(name = "Relogio")
    private BigDecimal relogio;
    @Basic(optional = false)
    @Column(name = "codigo_socio")
    private int codigoSocio;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "sobrenome")
    private String sobrenome;

    public RelatorioContas() {
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

    public BigDecimal getTaxaValor() {
        return taxaValor;
    }

    public void setTaxaValor(BigDecimal taxaValor) {
        this.taxaValor = taxaValor;
    }

    public BigDecimal getRelogio() {
        return relogio;
    }

    public void setRelogio(BigDecimal relogio) {
        this.relogio = relogio;
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
