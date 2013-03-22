/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "taxas", catalog = "acal", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Taxas.findAll", query = "SELECT t FROM Taxas t"),
//    @NamedQuery(name = "Taxas.findById", query = "SELECT t FROM Taxas t WHERE t.id = :id"),
//    @NamedQuery(name = "Taxas.findByNome", query = "SELECT t FROM Taxas t WHERE t.nome = :nome"),
//    @NamedQuery(name = "Taxas.findByDescricao", query = "SELECT t FROM Taxas t WHERE t.descricao = :descricao"),
//    @NamedQuery(name = "Taxas.findByValor", query = "SELECT t FROM Taxas t WHERE t.valor = :valor")})
public class Taxa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "Valor")
    private double valor;
    @Basic(optional = false)
    @Lob
    @Column(name = "Observacao")
    private String observacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtaxa")
    private List<Conta> contasList;

    public Taxa() {
    }

    public Taxa(Integer id) {
        this.id = id;
    }

    public Taxa(Integer id, String nome, String descricao, double valor, String observacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.observacao = observacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @XmlTransient
    public List<Conta> getContasList() {
        return contasList;
    }

    public void setContasList(List<Conta> contasList) {
        this.contasList = contasList;
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
        if (!(object instanceof Taxa)) {
            return false;
        }
        Taxa other = (Taxa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Taxas[ id=" + id + " ]";
    }
    
}
