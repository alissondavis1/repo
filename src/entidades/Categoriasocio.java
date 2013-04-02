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
@Table(name = "categoriasocio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriasocio.findAll", query = "SELECT c FROM Categoriasocio c"),
    @NamedQuery(name = "Categoriasocio.findById", query = "SELECT c FROM Categoriasocio c WHERE c.id = :id"),
    @NamedQuery(name = "Categoriasocio.findByNome", query = "SELECT c FROM Categoriasocio c WHERE c.nome = :nome"),
    @NamedQuery(name = "Categoriasocio.findByTaxasId", query = "SELECT c FROM Categoriasocio c WHERE c.taxasId = :taxasId")})
public class Categoriasocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "taxasId")
    private int taxasId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaSocio")
    private List<Socio> socioList;

    public Categoriasocio() {
    }

    public Categoriasocio(Integer id) {
        this.id = id;
    }

    public Categoriasocio(Integer id, String nome, int taxasId) {
        this.id = id;
        this.nome = nome;
        this.taxasId = taxasId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTaxasId() {
        return taxasId;
    }

    public void setTaxasId(int taxasId) {
        this.taxasId = taxasId;
    }

    @XmlTransient
    public List<Socio> getSocioList() {
        return socioList;
    }

    public void setSocioList(List<Socio> socioList) {
        this.socioList = socioList;
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
        if (!(object instanceof Categoriasocio)) {
            return false;
        }
        Categoriasocio other = (Categoriasocio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Categoriasocio[ id=" + id + " ]";
    }
    
}