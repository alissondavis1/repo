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
@Table(name = "entradas_log", catalog = "acal", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "EntradasLog.findAll", query = "SELECT e FROM EntradasLog e"),
//    @NamedQuery(name = "EntradasLog.findById", query = "SELECT e FROM EntradasLog e WHERE e.id = :id"),
//    @NamedQuery(name = "EntradasLog.findByValor", query = "SELECT e FROM EntradasLog e WHERE e.valor = :valor"),
//    @NamedQuery(name = "EntradasLog.findByData", query = "SELECT e FROM EntradasLog e WHERE e.data = :data"),
//    @NamedQuery(name = "EntradasLog.findByIdMotivo", query = "SELECT e FROM EntradasLog e WHERE e.idMotivo = :idMotivo"),
//    @NamedQuery(name = "EntradasLog.findByIdCedente", query = "SELECT e FROM EntradasLog e WHERE e.idCedente = :idCedente"),
//    @NamedQuery(name = "EntradasLog.findByIdFuncionario", query = "SELECT e FROM EntradasLog e WHERE e.idFuncionario = :idFuncionario"),
//    @NamedQuery(name = "EntradasLog.findByDataTransacao", query = "SELECT e FROM EntradasLog e WHERE e.dataTransacao = :dataTransacao"),
//    @NamedQuery(name = "EntradasLog.findByTipo", query = "SELECT e FROM EntradasLog e WHERE e.tipo = :tipo")})
public class EntradasLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "id_motivo")
    private int idMotivo;
    @Basic(optional = false)
    @Column(name = "id_cedente")
    private int idCedente;
    @Basic(optional = false)
    @Column(name = "id_funcionario")
    private int idFuncionario;
    @Basic(optional = false)
    @Column(name = "data_transacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTransacao;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;

    public EntradasLog() {
    }

    public EntradasLog(Integer id) {
        this.id = id;
    }

    public EntradasLog(Integer id, double valor, Date data, int idMotivo, int idCedente, int idFuncionario, Date dataTransacao, String tipo) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.idMotivo = idMotivo;
        this.idCedente = idCedente;
        this.idFuncionario = idFuncionario;
        this.dataTransacao = dataTransacao;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }

    public int getIdCedente() {
        return idCedente;
    }

    public void setIdCedente(int idCedente) {
        this.idCedente = idCedente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
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
        if (!(object instanceof EntradasLog)) {
            return false;
        }
        EntradasLog other = (EntradasLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EntradasLog[ id=" + id + " ]";
    }
    
}
