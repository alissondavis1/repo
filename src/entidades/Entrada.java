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
@Table(name = "entradas")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Entradas.findAll", query = "SELECT e FROM Entradas e"),
//    @NamedQuery(name = "Entradas.findById", query = "SELECT e FROM Entradas e WHERE e.id = :id"),
//    @NamedQuery(name = "Entradas.findByValor", query = "SELECT e FROM Entradas e WHERE e.valor = :valor"),
//    @NamedQuery(name = "Entradas.findByData", query = "SELECT e FROM Entradas e WHERE e.data = :data")})
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
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "id_cedente", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Socio idCedente;
    @JoinColumn(name = "id_motivo", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private MotivoEntrada idMotivo;

    public Entrada() {
    }

    public Entrada(float valor, Date data, String observacao, Funcionario idFuncionario, Socio idCedente, MotivoEntrada idMotivo) {
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.idFuncionario = idFuncionario;
        this.idCedente = idCedente;
        this.idMotivo = idMotivo;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Socio getIdCedente() {
        return idCedente;
    }

    public void setIdCedente(Socio idCedente) {
        this.idCedente = idCedente;
    }

    public MotivoEntrada getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(MotivoEntrada idMotivo) {
        this.idMotivo = idMotivo;
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
