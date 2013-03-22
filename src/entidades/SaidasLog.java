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
@Table(name = "saidas_log", catalog = "acal", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "SaidasLog.findAll", query = "SELECT s FROM SaidasLog s"),
//    @NamedQuery(name = "SaidasLog.findById", query = "SELECT s FROM SaidasLog s WHERE s.id = :id"),
//    @NamedQuery(name = "SaidasLog.findByValor", query = "SELECT s FROM SaidasLog s WHERE s.valor = :valor"),
//    @NamedQuery(name = "SaidasLog.findByData", query = "SELECT s FROM SaidasLog s WHERE s.data = :data"),
//    @NamedQuery(name = "SaidasLog.findByIdMotivoSaida", query = "SELECT s FROM SaidasLog s WHERE s.idMotivoSaida = :idMotivoSaida"),
//    @NamedQuery(name = "SaidasLog.findByIdSocio", query = "SELECT s FROM SaidasLog s WHERE s.idSocio = :idSocio"),
//    @NamedQuery(name = "SaidasLog.findByIdFuncionario", query = "SELECT s FROM SaidasLog s WHERE s.idFuncionario = :idFuncionario"),
//    @NamedQuery(name = "SaidasLog.findByDataTransacao", query = "SELECT s FROM SaidasLog s WHERE s.dataTransacao = :dataTransacao"),
//    @NamedQuery(name = "SaidasLog.findByTipo", query = "SELECT s FROM SaidasLog s WHERE s.tipo = :tipo")})
public class SaidasLog implements Serializable {
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
    @Column(name = "id_motivo_saida")
    private int idMotivoSaida;
    @Basic(optional = false)
    @Column(name = "id_socio")
    private int idSocio;
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

    public SaidasLog() {
    }

    public SaidasLog(Integer id) {
        this.id = id;
    }

    public SaidasLog(Integer id, double valor, Date data, int idMotivoSaida, int idSocio, int idFuncionario, Date dataTransacao, String tipo) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.idMotivoSaida = idMotivoSaida;
        this.idSocio = idSocio;
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

    public int getIdMotivoSaida() {
        return idMotivoSaida;
    }

    public void setIdMotivoSaida(int idMotivoSaida) {
        this.idMotivoSaida = idMotivoSaida;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
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
        if (!(object instanceof SaidasLog)) {
            return false;
        }
        SaidasLog other = (SaidasLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.SaidasLog[ id=" + id + " ]";
    }
    
}
