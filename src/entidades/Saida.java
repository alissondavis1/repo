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
@Table(name = "saida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saida.findAll", query = "SELECT s FROM Saida s"),
    @NamedQuery(name = "Saida.findById", query = "SELECT s FROM Saida s WHERE s.id = :id"),
    @NamedQuery(name = "Saida.findByData", query = "SELECT s FROM Saida s WHERE s.data = :data"),
    @NamedQuery(name = "Saida.findByValor", query = "SELECT s FROM Saida s WHERE s.valor = :valor"),
    @NamedQuery(name = "Saida.findByFavorecido", query = "SELECT s FROM Saida s WHERE s.favorecido = :favorecido")})
public class Saida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "favorecido")
    private String favorecido;
    @JoinColumn(name = "idmotivosaida", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MotivoDespesa idmotivosaida;
    @JoinColumn(name = "idfuncionario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario idfuncionario;

    public Saida() {
    }

    public Saida(Integer id) {
        this.id = id;
    }

    public Saida(Integer id, Date data, BigDecimal valor, String favorecido) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.favorecido = favorecido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

    public MotivoDespesa getIdmotivosaida() {
        return idmotivosaida;
    }

    public void setIdmotivosaida(MotivoDespesa idmotivosaida) {
        this.idmotivosaida = idmotivosaida;
    }

    public Funcionario getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Funcionario idfuncionario) {
        this.idfuncionario = idfuncionario;
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
        if (!(object instanceof Saida)) {
            return false;
        }
        Saida other = (Saida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Saida[ id=" + id + " ]";
    }
    
}
