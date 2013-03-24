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
@Table(name = "saidas")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Saida.findAll", query = "SELECT s FROM Saida s"),
//    @NamedQuery(name = "Saida.findById", query = "SELECT s FROM Saida s WHERE s.id = :id"),
//    @NamedQuery(name = "Saida.findByValor", query = "SELECT s FROM Saida s WHERE s.valor = :valor"),
//    @NamedQuery(name = "Saida.findByData", query = "SELECT s FROM Saida s WHERE s.data = :data"),
//    @NamedQuery(name = "Saida.findByFavorecido", query = "SELECT s FROM Saida s WHERE s.favorecido = :favorecido")})
public class Saida implements Serializable {
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
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "Favorecido")
    private String favorecido;
    @Lob
    @Column(name = "Observacao")
    private String observacao;
    @JoinColumn(name = "Id_funcionario", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Funcionario idfuncionario;
    @JoinColumn(name = "Id_motivo_saida", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MotivoDespesa idmotivosaida;

    public Saida() {
    }

    public Saida(float valor, Date data, String favorecido, String observacao, Funcionario idfuncionario, MotivoDespesa idmotivosaida) {
        this.valor = valor;
        this.data = data;
        this.favorecido = favorecido;
        this.observacao = observacao;
        this.idfuncionario = idfuncionario;
        this.idmotivosaida = idmotivosaida;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Funcionario getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Funcionario idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public MotivoDespesa getIdmotivosaida() {
        return idmotivosaida;
    }

    public void setIdmotivosaida(MotivoDespesa idmotivosaida) {
        this.idmotivosaida = idmotivosaida;
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
