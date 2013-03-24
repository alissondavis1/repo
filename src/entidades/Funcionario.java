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
@Table(name = "funcionario")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
//    @NamedQuery(name = "Funcionario.findById", query = "SELECT f FROM Funcionario f WHERE f.id = :id"),
//    @NamedQuery(name = "Funcionario.findByCargo", query = "SELECT f FROM Funcionario f WHERE f.cargo = :cargo"),
//    @NamedQuery(name = "Funcionario.findBySalario", query = "SELECT f FROM Funcionario f WHERE f.salario = :salario"),
//    @NamedQuery(name = "Funcionario.findByDataContratacao", query = "SELECT f FROM Funcionario f WHERE f.dataContratacao = :dataContratacao"),
//    @NamedQuery(name = "Funcionario.findByMatricula", query = "SELECT f FROM Funcionario f WHERE f.matricula = :matricula")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "Salario")
    private float salario;
    @Basic(optional = false)
    @Column(name = "DataContratacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataContratacao;
    @Basic(optional = false)
    @Column(name = "Matricula")
    private int matricula;
    @Basic(optional = false)
    @Lob
    @Column(name = "Observacao")
    private String observacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private List<Cheque> chequeList;
    @JoinColumn(name = "Id_pessoa", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Pessoa idpessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncionario")
    private List<Saida> saidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private List<Entrada> entradasList;

    public Funcionario() {
    }

    public Funcionario(String cargo, float salario, Date dataContratacao, int matricula, String observacao, List<Cheque> chequeList, Pessoa idpessoa, List<Saida> saidaList, List<Entrada> entradasList) {
        this.cargo = cargo;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.matricula = matricula;
        this.observacao = observacao;
        this.chequeList = chequeList;
        this.idpessoa = idpessoa;
        this.saidaList = saidaList;
        this.entradasList = entradasList;
    }
    public Integer getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @XmlTransient
    public List<Cheque> getChequeList() {
        return chequeList;
    }

    public void setChequeList(List<Cheque> chequeList) {
        this.chequeList = chequeList;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
    }

    @XmlTransient
    public List<Saida> getSaidaList() {
        return saidaList;
    }

    public void setSaidaList(List<Saida> saidaList) {
        this.saidaList = saidaList;
    }

    @XmlTransient
    public List<Entrada> getEntradasList() {
        return entradasList;
    }

    public void setEntradasList(List<Entrada> entradasList) {
        this.entradasList = entradasList;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Funcionario[ id=" + id + " ]";
    }
    
}
