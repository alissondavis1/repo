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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "CategoriaSocio.findAll", query = "SELECT c FROM CategoriaSocio c"),
    @NamedQuery(name = "CategoriaSocio.findById", query = "SELECT c FROM CategoriaSocio c WHERE c.id = :id"),
    @NamedQuery(name = "CategoriaSocio.findByNome", query = "SELECT c FROM CategoriaSocio c WHERE c.nome = :nome")})
public class CategoriaSocio implements Serializable {
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
    @JoinColumn(name = "taxasId", referencedColumnName = "id")
    @ManyToOne
    private Taxa taxasId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaSocio")
    private List<Socio> socioList;

    public CategoriaSocio() {
    }

    public CategoriaSocio(Integer id) {
        this.id = id;
    }

    public CategoriaSocio(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Taxa getTaxasId() {
        return taxasId;
    }

    public void setTaxasId(Taxa taxasId) {
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
