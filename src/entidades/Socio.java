/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "socio", catalog = "acal", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s"),
//    @NamedQuery(name = "Socio.findById", query = "SELECT s FROM Socio s WHERE s.id = :id"),
//    @NamedQuery(name = "Socio.findByDatamatricula", query = "SELECT s FROM Socio s WHERE s.datamatricula = :datamatricula"),
//    @NamedQuery(name = "Socio.findByDataaprovacao", query = "SELECT s FROM Socio s WHERE s.dataaprovacao = :dataaprovacao"),
//    @NamedQuery(name = "Socio.findByNumerosocio", query = "SELECT s FROM Socio s WHERE s.numerosocio = :numerosocio"),
//    @NamedQuery(name = "Socio.findByDataVence", query = "SELECT s FROM Socio s WHERE s.dataVence = :dataVence")})
public class Socio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Data_matricula")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datamatricula;
    @Basic(optional = false)
    @Column(name = "Data_aprovacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataaprovacao;
    @Basic(optional = false)
    @Column(name = "Numero_socio")
    private int numerosocio;
    @Basic(optional = false)
    @Column(name = "data_Vence")
    @Temporal(TemporalType.DATE)
    private Date dataVence;
    @Basic(optional = false)
    @Lob
    @Column(name = "Observacao")
    private String observacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnumerosocio")
    private List<Conta> contasList;
    @JoinColumn(name = "Id_categorira_socio", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private CategoriaSocio idcategorirasocio;
    @JoinColumn(name = "Id_pessoa", referencedColumnName = "Id")
    @OneToOne(optional = false)
    private Pessoa idpessoa;

    public Socio() {
    }

    public Socio(Integer id) {
        this.id = id;
    }

    public Socio(Integer id, Date datamatricula, Date dataaprovacao, int numerosocio, Date dataVence, String observacao) {
        this.id = id;
        this.datamatricula = datamatricula;
        this.dataaprovacao = dataaprovacao;
        this.numerosocio = numerosocio;
        this.dataVence = dataVence;
        this.observacao = observacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatamatricula() {
        return datamatricula;
    }

    public void setDatamatricula(Date datamatricula) {
        this.datamatricula = datamatricula;
    }

    public Date getDataaprovacao() {
        return dataaprovacao;
    }

    public void setDataaprovacao(Date dataaprovacao) {
        this.dataaprovacao = dataaprovacao;
    }

    public int getNumerosocio() {
        return numerosocio;
    }

    public void setNumerosocio(int numerosocio) {
        this.numerosocio = numerosocio;
    }

    public Date getDataVence() {
        return dataVence;
    }

    public void setDataVence(Date dataVence) {
        this.dataVence = dataVence;
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

    public CategoriaSocio getIdcategorirasocio() {
        return idcategorirasocio;
    }

    public void setIdcategorirasocio(CategoriaSocio idcategorirasocio) {
        this.idcategorirasocio = idcategorirasocio;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
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
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Socio[ id=" + id + " ]";
    }
    
}
