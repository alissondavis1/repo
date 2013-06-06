/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "conta")
@XmlRootElement

public class Conta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataPag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPag;
    @Basic(optional = false)
    @Column(name = "dataVence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVence;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
   
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idconta")
    private Hidrometro hidrometro;
    @Column(name = "dataGerada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGerada;
    @JoinColumn(name = "idEnderecoPessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Enderecopessoa idEnderecoPessoa;
    public Conta() {
    }

    public Conta(Integer id) {
        this.id = id;
    }

    public Conta(Integer id, Date dataVence) {
        this.id = id;
        this.dataVence = dataVence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPag() {
        return dataPag;
    }

    public void setDataPag(Date dataPag) {
        this.dataPag = dataPag;
    }

    public Date getDataVence() {
        return dataVence;
    }

    public void setDataVence(Date dataVence) {
        this.dataVence = dataVence;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

   

    public Hidrometro getHidrometro() {
        return hidrometro;
    }

    public void setHidrometro(Hidrometro hidrometro) {
        this.hidrometro = hidrometro;
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
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Conta[ id=" + id + " ]";
    }

    public Date getDataGerada() {
        return dataGerada;
    }

    public void setDataGerada(Date dataGerada) {
        this.dataGerada = dataGerada;
    }

    public Enderecopessoa getIdEnderecoPessoa() {
        return idEnderecoPessoa;
    }

    public void setIdEnderecoPessoa(Enderecopessoa idEnderecoPessoa) {
        this.idEnderecoPessoa = idEnderecoPessoa;
    }
    
}
