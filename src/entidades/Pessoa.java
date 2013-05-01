/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "pessoa")
@XmlRootElement

public class Pessoa implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "numeroEndereco")
    private String numeroEndereco;
   
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Column(name = "apelido")
    private String apelido;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "dataNasc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNasc;
    @Column(name = "email")
    private String email;
    @Column(name = "nomeMae")
    private String nomeMae;
    @Column(name = "nomePai")
    private String nomePai;
//    @Column(name = "numeroMatricula")
//    private Integer numeroMatricula;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "rgEmissao")
    @Temporal(TemporalType.DATE)
    private Date rgEmissao;
    @Column(name = "rgExpedidor")
    private String rgExpedidor;
    @Column(name = "rgNumero")
    private String rgNumero;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "uf")
    private String uf;
    @JoinColumn(name = "idEndereco", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Endereco idEndereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa", fetch= FetchType.EAGER)
    private List<Funcionario> funcionarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private List<Socio> socioList;

    public Pessoa() {
    }

    public Pessoa(Integer id) {
        this.id = id;
    }

    public Pessoa(Integer id, String nome, String sobrenome, int categoriaSocio, boolean status) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }
    
    public String getNumeroEnderco(){
        
        return this.numeroEndereco;
    }
    
    public void setNumeroEndereco(String numeroEndereco){
        
        String oldNumeroEndereco = this.numeroEndereco;
        this.numeroEndereco = numeroEndereco;
        changeSupport.firePropertyChange("numeroEndereco", oldNumeroEndereco, numeroEndereco);
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        String oldSobrenome = this.sobrenome;
        this.sobrenome = sobrenome;
        changeSupport.firePropertyChange("sobrenome", oldSobrenome, sobrenome);
    }

   

   

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        boolean oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        String oldApelido = this.apelido;
        this.apelido = apelido;
        changeSupport.firePropertyChange("apelido", oldApelido, apelido);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        String oldCep = this.cep;
        this.cep = cep;
        changeSupport.firePropertyChange("cep", oldCep, cep);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        Date oldDataNasc = this.dataNasc;
        this.dataNasc = dataNasc;
        changeSupport.firePropertyChange("dataNasc", oldDataNasc, dataNasc);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        String oldNomeMae = this.nomeMae;
        this.nomeMae = nomeMae;
        changeSupport.firePropertyChange("nomeMae", oldNomeMae, nomeMae);
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        String oldNomePai = this.nomePai;
        this.nomePai = nomePai;
        changeSupport.firePropertyChange("nomePai", oldNomePai, nomePai);
    }

//    public Integer getNumeroMatricula() {
//        return numeroMatricula;
//    }
//
//    public void setNumeroMatricula(Integer numeroMatricula) {
//        Integer oldNumeroMatricula = this.numeroMatricula;
//        this.numeroMatricula = numeroMatricula;
//        changeSupport.firePropertyChange("numeroMatricula", oldNumeroMatricula, numeroMatricula);
//    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        String oldObservacoes = this.observacoes;
        this.observacoes = observacoes;
        changeSupport.firePropertyChange("observacoes", oldObservacoes, observacoes);
    }

    public Date getRgEmissao() {
        return rgEmissao;
    }

    public void setRgEmissao(Date rgEmissao) {
        Date oldRgEmissao = this.rgEmissao;
        this.rgEmissao = rgEmissao;
        changeSupport.firePropertyChange("rgEmissao", oldRgEmissao, rgEmissao);
    }

    public String getRgExpedidor() {
        return rgExpedidor;
    }

    public void setRgExpedidor(String rgExpedidor) {
        String oldRgExpedidor = this.rgExpedidor;
        this.rgExpedidor = rgExpedidor;
        changeSupport.firePropertyChange("rgExpedidor", oldRgExpedidor, rgExpedidor);
    }

    public String getRgNumero() {
        return rgNumero;
    }

    public void setRgNumero(String rgNumero) {
        String oldRgNumero = this.rgNumero;
        this.rgNumero = rgNumero;
        changeSupport.firePropertyChange("rgNumero", oldRgNumero, rgNumero);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        String oldSexo = this.sexo;
        this.sexo = sexo;
        changeSupport.firePropertyChange("sexo", oldSexo, sexo);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        String oldUf = this.uf;
        this.uf = uf;
        changeSupport.firePropertyChange("uf", oldUf, uf);
    }

    public Endereco getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Endereco idEndereco) {
        Endereco oldIdEndereco = this.idEndereco;
        this.idEndereco = idEndereco;
        changeSupport.firePropertyChange("idEndereco", oldIdEndereco, idEndereco);
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pessoa[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
