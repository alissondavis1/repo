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
@Table(name = "cheques")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Cheque.findAll", query = "SELECT c FROM Cheque c"),
//    @NamedQuery(name = "Cheque.findById", query = "SELECT c FROM Cheque c WHERE c.id = :id"),
//    @NamedQuery(name = "Cheque.findByValor", query = "SELECT c FROM Cheque c WHERE c.valor = :valor"),
//    @NamedQuery(name = "Cheque.findByNumero", query = "SELECT c FROM Cheque c WHERE c.numero = :numero"),
//    @NamedQuery(name = "Cheque.findByDatavencimento", query = "SELECT c FROM Cheque c WHERE c.datavencimento = :datavencimento"),
//    @NamedQuery(name = "Cheque.findByDatapagamento", query = "SELECT c FROM Cheque c WHERE c.datapagamento = :datapagamento")})
public class Cheque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Valor")
    private float valor;
    @Basic(optional = false)
    @Column(name = "Numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "Data_vencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datavencimento;
    @Column(name = "Data_pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datapagamento;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "Id_Motivo_despeza", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MotivoDespesa idMotivodespeza;
    @JoinColumn(name = "Id_Funcionario", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

    public Cheque() {
    }

    public Cheque(float valor, int numero, Date datavencimento, Date datapagamento, String observacoes, MotivoDespesa idMotivodespeza, Funcionario idFuncionario) {
        this.valor = valor;
        this.numero = numero;
        this.datavencimento = datavencimento;
        this.datapagamento = datapagamento;
        this.observacoes = observacoes;
        this.idMotivodespeza = idMotivodespeza;
        this.idFuncionario = idFuncionario;
    }

 
    public Integer getId() {
        return id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public Date getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public MotivoDespesa getIdMotivodespeza() {
        return idMotivodespeza;
    }

    public void setIdMotivodespeza(MotivoDespesa idMotivodespeza) {
        this.idMotivodespeza = idMotivodespeza;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
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
        if (!(object instanceof Cheque)) {
            return false;
        }
        Cheque other = (Cheque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cheque[ id=" + id + " ]";
    }
    
}
