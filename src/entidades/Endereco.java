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
@Table(name = "enderecos", catalog = "acal", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Enderecos.findAll", query = "SELECT e FROM Enderecos e"),
//    @NamedQuery(name = "Enderecos.findById", query = "SELECT e FROM Enderecos e WHERE e.id = :id"),
//    @NamedQuery(name = "Enderecos.findByNome", query = "SELECT e FROM Enderecos e WHERE e.nome = :nome"),
//    @NamedQuery(name = "Enderecos.findByTipo", query = "SELECT e FROM Enderecos e WHERE e.tipo = :tipo")})
public class Endereco implements Serializable {
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
    @Column(name = "Tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEndereco")
    private List<Pessoa> pessoaList;

    public Endereco() {
    }

    public Endereco(Integer id) {
        this.id = id;
    }

    public Endereco(Integer id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
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
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Enderecos[ id=" + id + " ]";
    }
    
}
