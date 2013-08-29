/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Head
 */
@Entity
@Table(name = "rc_caixa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaixaView.findAll", query = "SELECT c FROM CaixaView c"),
    @NamedQuery(name = "CaixaView.findByNumeroconta", query = "SELECT c FROM CaixaView c WHERE c.numeroconta = :numeroconta"),
    @NamedQuery(name = "CaixaView.findByData", query = "SELECT c FROM CaixaView c WHERE c.data = :data"),
    @NamedQuery(name = "CaixaView.findByPagamento", query = "SELECT c FROM CaixaView c WHERE c.pagamento = :pagamento"),
    @NamedQuery(name = "CaixaView.findByVencimento", query = "SELECT c FROM CaixaView c WHERE c.vencimento = :vencimento"),
    @NamedQuery(name = "CaixaView.findBySocio", query = "SELECT c FROM CaixaView c WHERE c.socio = :socio"),
    @NamedQuery(name = "CaixaView.findByEndereco", query = "SELECT c FROM CaixaView c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "CaixaView.findByNumero", query = "SELECT c FROM CaixaView c WHERE c.numero = :numero"),
    @NamedQuery(name = "CaixaView.findByNumeroSocio", query = "SELECT c FROM CaixaView c WHERE c.numeroSocio = :numeroSocio"),
    @NamedQuery(name = "CaixaView.findByCategoriaSocio", query = "SELECT c FROM CaixaView c WHERE c.categoriaSocio = :categoriaSocio"),
    @NamedQuery(name = "CaixaView.findByTaxaSocio", query = "SELECT c FROM CaixaView c WHERE c.taxaSocio = :taxaSocio"),
    @NamedQuery(name = "CaixaView.findByConsumo", query = "SELECT c FROM CaixaView c WHERE c.consumo = :consumo"),
    @NamedQuery(name = "CaixaView.findByExcessoLTd", query = "SELECT c FROM CaixaView c WHERE c.excessoLTd = :excessoLTd"),
    @NamedQuery(name = "CaixaView.findByExcessoValor", query = "SELECT c FROM CaixaView c WHERE c.excessoValor = :excessoValor"),
    @NamedQuery(name = "CaixaView.findByTaxas", query = "SELECT c FROM CaixaView c WHERE c.taxas = :taxas"),
    @NamedQuery(name = "CaixaView.findByTotalconta", query = "SELECT c FROM CaixaView c WHERE c.totalconta = :totalconta")})
public class CaixaView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "numeroconta")
    @Id
    private int numeroconta;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pagamento;
    @Basic(optional = false)
    @Column(name = "vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vencimento;
    @Column(name = "socio")
    private String socio;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "numeroSocio")
    private int numeroSocio;
    @Basic(optional = false)
    @Column(name = "categoriaSocio")
    private String categoriaSocio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "taxaSocio")
    private BigDecimal taxaSocio;
    @Column(name = "consumo")
    private Double consumo;
    @Column(name = "excessoLTd")
    private Double excessoLTd;
    @Column(name = "excessoValor")
    private Double excessoValor;
    @Column(name = "taxas")
    private BigDecimal taxas;
    @Column(name = "totalconta")
    private Double totalconta;

    public CaixaView() {
    }

    public int getNumeroconta() {
        return numeroconta;
    }

    public void setNumeroconta(int numeroconta) {
        this.numeroconta = numeroconta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getPagamento() {
        return pagamento;
    }

    public void setPagamento(Date pagamento) {
        this.pagamento = pagamento;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public String getCategoriaSocio() {
        return categoriaSocio;
    }

    public void setCategoriaSocio(String categoriaSocio) {
        this.categoriaSocio = categoriaSocio;
    }

    public BigDecimal getTaxaSocio() {
        return taxaSocio;
    }

    public void setTaxaSocio(BigDecimal taxaSocio) {
        this.taxaSocio = taxaSocio;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Double getExcessoLTd() {
        return excessoLTd;
    }

    public void setExcessoLTd(Double excessoLTd) {
        this.excessoLTd = excessoLTd;
    }

    public Double getExcessoValor() {
        return excessoValor;
    }

    public void setExcessoValor(Double excessoValor) {
        this.excessoValor = excessoValor;
    }

    public BigDecimal getTaxas() {
        return taxas;
    }

    public void setTaxas(BigDecimal taxas) {
        this.taxas = taxas;
    }

    public Double getTotalconta() {
        return totalconta;
    }

    public void setTotalconta(Double totalconta) {
        this.totalconta = totalconta;
    }
    
}
