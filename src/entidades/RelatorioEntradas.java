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
@Table(name = "relatorio_entradas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatorioEntradas.findAll", query = "SELECT r FROM RelatorioEntradas r"),
    @NamedQuery(name = "RelatorioEntradas.findByNumero", query = "SELECT r FROM RelatorioEntradas r WHERE r.numero = :numero"),
    @NamedQuery(name = "RelatorioEntradas.findByData", query = "SELECT r FROM RelatorioEntradas r WHERE r.data = :data"),
    @NamedQuery(name = "RelatorioEntradas.findByValor", query = "SELECT r FROM RelatorioEntradas r WHERE r.valor = :valor"),
    @NamedQuery(name = "RelatorioEntradas.findByMotivo", query = "SELECT r FROM RelatorioEntradas r WHERE r.motivo = :motivo"),
    @NamedQuery(name = "RelatorioEntradas.findByCodF", query = "SELECT r FROM RelatorioEntradas r WHERE r.codF = :codF"),
    @NamedQuery(name = "RelatorioEntradas.findByNome", query = "SELECT r FROM RelatorioEntradas r WHERE r.nome = :nome"),
    @NamedQuery(name = "RelatorioEntradas.findByCpf", query = "SELECT r FROM RelatorioEntradas r WHERE r.cpf = :cpf")})
public class RelatorioEntradas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @Column(name = "cod_F")
    private int codF;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;

    public RelatorioEntradas() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getCodF() {
        return codF;
    }

    public void setCodF(int codF) {
        this.codF = codF;
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
    
}
