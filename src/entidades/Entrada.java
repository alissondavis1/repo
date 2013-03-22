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
@Table(name = "entradas", catalog = "acal", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Entradas.findAll", query = "SELECT e FROM Entradas e"),
//    @NamedQuery(name = "Entradas.findById", query = "SELECT e FROM Entradas e WHERE e.id = :id"),
//    @NamedQuery(name = "Entradas.findByValor", query = "SELECT e FROM Entradas e WHERE e.valor = :valor"),
//    @NamedQuery(name = "Entradas.findByData", query = "SELECT e FROM Entradas e WHERE e.data = :data"),
//    @NamedQuery(name = "Entradas.findByIdMotivo", query = "SELECT e FROM Entradas e WHERE e.idMotivo = :idMotivo"),
//    @NamedQuery(name = "Entradas.findByIdCedente", query = "SELECT e FROM Entradas e WHERE e.idCedente = :idCedente"),
//    @NamedQuery(name = "Entradas.findByIdFuncionario", query = "SELECT e FROM Entradas e WHERE e.idFuncionario = :idFuncionario")})
public class Entrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "valor")
    private float valor;
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
    @Lob
    @Column(name = "observacao")
    private String observacao;

    public Entrada() {
    }

    public Entrada(Integer id) {
        this.id = id;
    }

    public Entrada(Integer id, float valor, Date data, int idMotivo, int idCedente, int idFuncionario, String observacao) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.idMotivo = idMotivo;
        this.idCedente = idCedente;
        this.idFuncionario = idFuncionario;
        this.observacao = observacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Entradas[ id=" + id + " ]";
    }
    
}
