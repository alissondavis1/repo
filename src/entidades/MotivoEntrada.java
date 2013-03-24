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
@Table(name = "motivoentradas")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "MotivoEntrada.findAll", query = "SELECT m FROM MotivoEntrada m"),
//    @NamedQuery(name = "MotivoEntrada.findById", query = "SELECT m FROM MotivoEntrada m WHERE m.id = :id"),
//    @NamedQuery(name = "MotivoEntrada.findByNome", query = "SELECT m FROM MotivoEntrada m WHERE m.nome = :nome")})
public class MotivoEntrada implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotivo")
    private List<Entrada> entradaList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Lob
    @Column(name = "Descricao")
    private String descricao;
    @Lob
    @Column(name = "Observacao")
    private String observacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotivo")
    private Entrada entradas;

    public MotivoEntrada() {
    }

    public MotivoEntrada(String nome, String descricao, String observacao, Entrada entradas) {
        this.nome = nome;
        this.descricao = descricao;
        this.observacao = observacao;
        this.entradas = entradas;
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
    public Entrada getEntradas() {
        return entradas;
    }

    public void setEntradasList(Entrada entradas) {
        this.entradas = entradas;
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
        return "entidades.MotivoEntrada[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
    }
    
}
