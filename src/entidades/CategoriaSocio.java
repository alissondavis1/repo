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
@Table(name = "categoria_socio")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "CategoriaSocio.findAll", query = "SELECT c FROM CategoriaSocio c"),
//    @NamedQuery(name = "CategoriaSocio.findById", query = "SELECT c FROM CategoriaSocio c WHERE c.id = :id"),
//    @NamedQuery(name = "CategoriaSocio.findByNome", query = "SELECT c FROM CategoriaSocio c WHERE c.nome = :nome"),
//    @NamedQuery(name = "CategoriaSocio.findByTaxaSocio", query = "SELECT c FROM CategoriaSocio c WHERE c.taxaSocio = :taxaSocio")})
public class CategoriaSocio implements Serializable {
    
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
    @Column(name = "taxa Socio")
    private int taxaSocio;
    @Lob
    @Column(name = "Descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategorirasocio")
    private List<Socio> socioList;

    public CategoriaSocio() {
    }

    public CategoriaSocio(String nome, int taxaSocio, String descricao, List<Socio> socioList) {
        this.nome = nome;
        this.taxaSocio = taxaSocio;
        this.descricao = descricao;
        this.socioList = socioList;
    }

  


    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTaxaSocio() {
        return taxaSocio;
    }

    public void setTaxaSocio(int taxaSocio) {
        this.taxaSocio = taxaSocio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof CategoriaSocio)) {
            return false;
        }
        CategoriaSocio other = (CategoriaSocio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CategoriaSocio[ id=" + id + " ]";
    }
    
}
