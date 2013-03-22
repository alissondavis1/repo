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
@Table(name = "motivosaidas", catalog = "acal", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Motivosaidas.findAll", query = "SELECT m FROM Motivosaidas m"),
//    @NamedQuery(name = "Motivosaidas.findById", query = "SELECT m FROM Motivosaidas m WHERE m.id = :id"),
//    @NamedQuery(name = "Motivosaidas.findByNome", query = "SELECT m FROM Motivosaidas m WHERE m.nome = :nome")})
public class MotivoDespesa implements Serializable {
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
    @Lob
    @Column(name = "Descricao")
    private String descricao;
    @Basic(optional = false)
    @Lob
    @Column(name = "Observacao")
    private String observacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotivodespeza")
    private List<Cheque> chequesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmotivosaida")
    private List<Saida> saidasList;

    public MotivoDespesa() {
    }

    public MotivoDespesa(Integer id) {
        this.id = id;
    }

    public MotivoDespesa(Integer id, String nome, String descricao, String observacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @XmlTransient
    public List<Cheque> getChequesList() {
        return chequesList;
    }

    public void setChequesList(List<Cheque> chequesList) {
        this.chequesList = chequesList;
    }

    @XmlTransient
    public List<Saida> getSaidasList() {
        return saidasList;
    }

    public void setSaidasList(List<Saida> saidasList) {
        this.saidasList = saidasList;
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
        if (!(object instanceof MotivoDespesa)) {
            return false;
        }
        MotivoDespesa other = (MotivoDespesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Motivosaidas[ id=" + id + " ]";
    }
    
}
