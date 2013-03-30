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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "entradaslog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entradaslog.findAll", query = "SELECT e FROM Entradaslog e"),
    @NamedQuery(name = "Entradaslog.findById", query = "SELECT e FROM Entradaslog e WHERE e.id = :id"),
    @NamedQuery(name = "Entradaslog.findByIdOriginal", query = "SELECT e FROM Entradaslog e WHERE e.idOriginal = :idOriginal"),
    @NamedQuery(name = "Entradaslog.findByDataOriginal", query = "SELECT e FROM Entradaslog e WHERE e.dataOriginal = :dataOriginal"),
    @NamedQuery(name = "Entradaslog.findByDataAlteracao", query = "SELECT e FROM Entradaslog e WHERE e.dataAlteracao = :dataAlteracao"),
    @NamedQuery(name = "Entradaslog.findByValor", query = "SELECT e FROM Entradaslog e WHERE e.valor = :valor"),
    @NamedQuery(name = "Entradaslog.findByIdCedente", query = "SELECT e FROM Entradaslog e WHERE e.idCedente = :idCedente"),
    @NamedQuery(name = "Entradaslog.findByIdFuncionario", query = "SELECT e FROM Entradaslog e WHERE e.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Entradaslog.findByIdMotivoEntrada", query = "SELECT e FROM Entradaslog e WHERE e.idMotivoEntrada = :idMotivoEntrada"),
    @NamedQuery(name = "Entradaslog.findByTipo", query = "SELECT e FROM Entradaslog e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "Entradaslog.findByIdFuncionarioAlteracao", query = "SELECT e FROM Entradaslog e WHERE e.idFuncionarioAlteracao = :idFuncionarioAlteracao")})
public class Entradaslog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idOriginal")
    private Integer idOriginal;
    @Column(name = "dataOriginal")
    @Temporal(TemporalType.DATE)
    private Date dataOriginal;
    @Column(name = "dataAlteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "idCedente")
    private Integer idCedente;
    @Column(name = "idFuncionario")
    private Integer idFuncionario;
    @Column(name = "idMotivoEntrada")
    private Integer idMotivoEntrada;
    @Column(name = "tipo")
    private String tipo;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "idFuncionarioAlteracao")
    private Integer idFuncionarioAlteracao;

    public Entradaslog() {
    }

    public Entradaslog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOriginal() {
        return idOriginal;
    }

    public void setIdOriginal(Integer idOriginal) {
        this.idOriginal = idOriginal;
    }

    public Date getDataOriginal() {
        return dataOriginal;
    }

    public void setDataOriginal(Date dataOriginal) {
        this.dataOriginal = dataOriginal;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getIdCedente() {
        return idCedente;
    }

    public void setIdCedente(Integer idCedente) {
        this.idCedente = idCedente;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdMotivoEntrada() {
        return idMotivoEntrada;
    }

    public void setIdMotivoEntrada(Integer idMotivoEntrada) {
        this.idMotivoEntrada = idMotivoEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getIdFuncionarioAlteracao() {
        return idFuncionarioAlteracao;
    }

    public void setIdFuncionarioAlteracao(Integer idFuncionarioAlteracao) {
        this.idFuncionarioAlteracao = idFuncionarioAlteracao;
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
        if (!(object instanceof Entradaslog)) {
            return false;
        }
        Entradaslog other = (Entradaslog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Entradaslog[ id=" + id + " ]";
    }
    
}
