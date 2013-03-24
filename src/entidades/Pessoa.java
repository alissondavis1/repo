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
@Table(name = "pessoa")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
//    @NamedQuery(name = "Pessoa.findById", query = "SELECT p FROM Pessoa p WHERE p.id = :id"),
//    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
//    @NamedQuery(name = "Pessoa.findBySobrenome", query = "SELECT p FROM Pessoa p WHERE p.sobrenome = :sobrenome"),
//    @NamedQuery(name = "Pessoa.findByApelido", query = "SELECT p FROM Pessoa p WHERE p.apelido = :apelido"),
//    @NamedQuery(name = "Pessoa.findByNumero", query = "SELECT p FROM Pessoa p WHERE p.numero = :numero"),
//    @NamedQuery(name = "Pessoa.findByBairro", query = "SELECT p FROM Pessoa p WHERE p.bairro = :bairro"),
//    @NamedQuery(name = "Pessoa.findByCidade", query = "SELECT p FROM Pessoa p WHERE p.cidade = :cidade"),
//    @NamedQuery(name = "Pessoa.findByUf", query = "SELECT p FROM Pessoa p WHERE p.uf = :uf"),
//    @NamedQuery(name = "Pessoa.findByCep", query = "SELECT p FROM Pessoa p WHERE p.cep = :cep"),
//    @NamedQuery(name = "Pessoa.findByTelefone", query = "SELECT p FROM Pessoa p WHERE p.telefone = :telefone"),
//    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
//    @NamedQuery(name = "Pessoa.findByDatanasc", query = "SELECT p FROM Pessoa p WHERE p.datanasc = :datanasc"),
//    @NamedQuery(name = "Pessoa.findBySexo", query = "SELECT p FROM Pessoa p WHERE p.sexo = :sexo"),
//    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
//    @NamedQuery(name = "Pessoa.findByRgnumero", query = "SELECT p FROM Pessoa p WHERE p.rgnumero = :rgnumero"),
//    @NamedQuery(name = "Pessoa.findByRgexpedidor", query = "SELECT p FROM Pessoa p WHERE p.rgexpedidor = :rgexpedidor"),
//    @NamedQuery(name = "Pessoa.findByRgemissao", query = "SELECT p FROM Pessoa p WHERE p.rgemissao = :rgemissao"),
//    @NamedQuery(name = "Pessoa.findByNomemae", query = "SELECT p FROM Pessoa p WHERE p.nomemae = :nomemae"),
//    @NamedQuery(name = "Pessoa.findByNomepai", query = "SELECT p FROM Pessoa p WHERE p.nomepai = :nomepai"),
//    @NamedQuery(name = "Pessoa.findByNumeromatricula", query = "SELECT p FROM Pessoa p WHERE p.numeromatricula = :numeromatricula"),
//    @NamedQuery(name = "Pessoa.findByStatus", query = "SELECT p FROM Pessoa p WHERE p.status = :status"),
//    @NamedQuery(name = "Pessoa.findByCategoriasocio", query = "SELECT p FROM Pessoa p WHERE p.categoriasocio = :categoriasocio")})
public class Pessoa implements Serializable {
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
    @Column(name = "Sobrenome")
    private String sobrenome;
    @Column(name = "Apelido")
    private String apelido;
    @Column(name = "Numero")
    private Integer numero;
    @Column(name = "Bairro")
    private String bairro;
    @Column(name = "Cidade")
    private String cidade;
    @Column(name = "Uf")
    private String uf;
    @Column(name = "Cep")
    private String cep;
    @Column(name = "Telefone")
    private String telefone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Data_nasc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanasc;
    @Column(name = "Sexo")
    private String sexo;
    @Column(name = "Cpf")
    private Integer cpf;
    @Column(name = "Rg_numero")
    private Integer rgnumero;
    @Column(name = "Rg_expedidor")
    private String rgexpedidor;
    @Column(name = "Rg_emissao")
    @Temporal(TemporalType.DATE)
    private Date rgemissao;
    @Column(name = "Nome_mae")
    private String nomemae;
    @Column(name = "Nome_pai")
    private String nomepai;
    @Column(name = "Numero_matricula")
    private Integer numeromatricula;
    @Basic(optional = false)
    @Column(name = "Status")
    private boolean status;
    @Column(name = "Categoria_socio")
    private Integer categoriasocio;
    @Lob
    @Column(name = "Observacoes")
    private String observacoes;
    @JoinColumn(name = "Id_Endereco", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Endereco idEndereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpessoa")
    private List<Funcionario> funcionarioList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idpessoa")
    private Socio socio;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, String apelido, Integer numero, String bairro, String cidade, String uf, String cep, String telefone, String email, Date datanasc, String sexo, Integer cpf, Integer rgnumero, String rgexpedidor, Date rgemissao, String nomemae, String nomepai, Integer numeromatricula, boolean status, Integer categoriasocio, String observacoes, Endereco idEndereco, List<Funcionario> funcionarioList, Socio socio) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.datanasc = datanasc;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rgnumero = rgnumero;
        this.rgexpedidor = rgexpedidor;
        this.rgemissao = rgemissao;
        this.nomemae = nomemae;
        this.nomepai = nomepai;
        this.numeromatricula = numeromatricula;
        this.status = status;
        this.categoriasocio = categoriasocio;
        this.observacoes = observacoes;
        this.idEndereco = idEndereco;
        this.funcionarioList = funcionarioList;
        this.socio = socio;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getRgnumero() {
        return rgnumero;
    }

    public void setRgnumero(Integer rgnumero) {
        this.rgnumero = rgnumero;
    }

    public String getRgexpedidor() {
        return rgexpedidor;
    }

    public void setRgexpedidor(String rgexpedidor) {
        this.rgexpedidor = rgexpedidor;
    }

    public Date getRgemissao() {
        return rgemissao;
    }

    public void setRgemissao(Date rgemissao) {
        this.rgemissao = rgemissao;
    }

    public String getNomemae() {
        return nomemae;
    }

    public void setNomemae(String nomemae) {
        this.nomemae = nomemae;
    }

    public String getNomepai() {
        return nomepai;
    }

    public void setNomepai(String nomepai) {
        this.nomepai = nomepai;
    }

    public Integer getNumeromatricula() {
        return numeromatricula;
    }

    public void setNumeromatricula(Integer numeromatricula) {
        this.numeromatricula = numeromatricula;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getCategoriasocio() {
        return categoriasocio;
    }

    public void setCategoriasocio(Integer categoriasocio) {
        this.categoriasocio = categoriasocio;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Endereco getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Endereco idEndereco) {
        this.idEndereco = idEndereco;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
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
    
}
