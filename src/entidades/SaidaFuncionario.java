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
@Table(name = "saida_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaidaFuncionario.findAll", query = "SELECT s FROM SaidaFuncionario s"),
    @NamedQuery(name = "SaidaFuncionario.findById", query = "SELECT s FROM SaidaFuncionario s WHERE s.id = :id"),
    @NamedQuery(name = "SaidaFuncionario.findByNome", query = "SELECT s FROM SaidaFuncionario s WHERE s.nome = :nome"),
    @NamedQuery(name = "SaidaFuncionario.findBySobrenome", query = "SELECT s FROM SaidaFuncionario s WHERE s.sobrenome = :sobrenome"),
    @NamedQuery(name = "SaidaFuncionario.findBySalario", query = "SELECT s FROM SaidaFuncionario s WHERE s.salario = :salario"),
    @NamedQuery(name = "SaidaFuncionario.findByData", query = "SELECT s FROM SaidaFuncionario s WHERE s.data = :data"),
    @NamedQuery(name = "SaidaFuncionario.findByFavorecido", query = "SELECT s FROM SaidaFuncionario s WHERE s.favorecido = :favorecido"),
    @NamedQuery(name = "SaidaFuncionario.findByValor", query = "SELECT s FROM SaidaFuncionario s WHERE s.valor = :valor"),
    @NamedQuery(name = "SaidaFuncionario.findByDespesa", query = "SELECT s FROM SaidaFuncionario s WHERE s.despesa = :despesa")})
public class SaidaFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic(optional = false)
    @Column(name = "salario")
    private float salario;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "favorecido")
    private String favorecido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "despesa")
    private String despesa;

    public SaidaFuncionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDespesa() {
        return despesa;
    }

    public void setDespesa(String despesa) {
        this.despesa = despesa;
    }
    
}
