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
@Table(name = "relatorio_contas_abertas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatorioContasAbertas.findAll", query = "SELECT r FROM RelatorioContasAbertas r"),
    @NamedQuery(name = "RelatorioContasAbertas.findByNumeroConta", query = "SELECT r FROM RelatorioContasAbertas r WHERE r.numeroConta = :numeroConta"),
    @NamedQuery(name = "RelatorioContasAbertas.findByVencimento", query = "SELECT r FROM RelatorioContasAbertas r WHERE r.vencimento = :vencimento"),
    @NamedQuery(name = "RelatorioContasAbertas.findByTaxaSocio", query = "SELECT r FROM RelatorioContasAbertas r WHERE r.taxaSocio = :taxaSocio"),
    @NamedQuery(name = "RelatorioContasAbertas.findByTaxaRelogio", query = "SELECT r FROM RelatorioContasAbertas r WHERE r.taxaRelogio = :taxaRelogio"),
    @NamedQuery(name = "RelatorioContasAbertas.findByNome", query = "SELECT r FROM RelatorioContasAbertas r WHERE r.nome = :nome"),
    @NamedQuery(name = "RelatorioContasAbertas.findByCpf", query = "SELECT r FROM RelatorioContasAbertas r WHERE r.cpf = :cpf"),
    @NamedQuery(name = "RelatorioContasAbertas.findByCategoria", query = "SELECT r FROM RelatorioContasAbertas r WHERE r.categoria = :categoria")})
public class RelatorioContasAbertas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Numero_Conta")
    private int numeroConta;
    @Basic(optional = false)
    @Column(name = "Vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vencimento;
    @Column(name = "TaxaSocio")
    private Integer taxaSocio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxaRelogio")
    private BigDecimal taxaRelogio;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "categoria")
    private String categoria;

    public RelatorioContasAbertas() {
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
