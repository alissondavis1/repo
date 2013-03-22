/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "motivoentradas", catalog = "acal", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Motivoentradas.findAll", query = "SELECT m FROM Motivoentradas m"),
//    @NamedQuery(name = "Motivoentradas.findById", query = "SELECT m FROM Motivoentradas m WHERE m.id = :id"),
//    @NamedQuery(name = "Motivoentradas.findByNome", query = "SELECT m FROM Motivoentradas m WHERE m.nome = :nome")})
public class MotivoEntrada implements Serializable {
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

    public MotivoEntrada() {
    }

    public MotivoEntrada(Integer id) {
        this.id = id;
    }

    public MotivoEntrada(Integer id, String nome, String descricao, String observacao) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivoEntrada)) {
            return false;
        }
        MotivoEntrada other = (MotivoEntrada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Motivoentradas[ id=" + id + " ]";
    }
    
}
