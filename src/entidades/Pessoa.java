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
@Table(name = "pessoa", catalog = "acal", schema = "")
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
    @Basic(optional = true)
    @Column(name = "Apelido")
    private String apelido;
    @Basic(optional = false)
    @Column(name = "Numero")
    private int numero;
    @Basic(optional = true)
    @Column(name = "Bairro")
    private String bairro;
    @Basic(optional = true)
    @Column(name = "Cidade")
    private String cidade;
    @Basic(optional = true)
    @Column(name = "Uf")
    private String uf;
    @Basic(optional = true)
    @Column(name = "Cep")
    private String cep;
    @Basic(optional = true)
    @Column(name = "Telefone")
    private String telefone;
    @Basic(optional = true)
    @Column(name = "Email")
    private String email;
    @Basic(optional = true)
    @Column(name = "Data_nasc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanasc;
    @Basic(optional = true)
    @Column(name = "Sexo")
    private String sexo;
    @Basic(optional = true)
    @Column(name = "Cpf")
    private int cpf;
    @Basic(optional = true)
    @Column(name = "Rg_numero")
    private int rgnumero;
    @Basic(optional = true)
    @Column(name = "Rg_expedidor")
    private String rgexpedidor;
    @Basic(optional = true)
    @Column(name = "Rg_emissao")
    @Temporal(TemporalType.DATE)
    private Date rgemissao;
    @Basic(optional = true)
    @Column(name = "Nome_mae")
    private String nomemae;
    @Basic(optional = true)
    @Column(name = "Nome_pai")
    private String nomepai;
    @Basic(optional = true)
    @Column(name = "Numero_matricula")
    private int numeromatricula;
    @Basic(optional = true)
    @Column(name = "Status")
    private boolean status;
    @Basic(optional = true)
    @Column(name = "Categoria_socio")
    private int categoriasocio;
    @Basic(optional = true)
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

    public Pessoa(Integer id) {
        this.id = id;
    }

    public Pessoa(Integer id, String nome, String sobrenome, String apelido, int numero, String bairro, String cidade, String uf, String cep, String telefone, String email, Date datanasc, String sexo, int cpf, int rgnumero, String rgexpedidor, Date rgemissao, String nomemae, String nomepai, int numeromatricula, boolean status, int categoriasocio, String observacoes) {
        this.id = id;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRgnumero() {
        return rgnumero;
    }

    public void setRgnumero(int rgnumero) {
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

    public int getNumeromatricula() {
        return numeromatricula;
    }

    public void setNumeromatricula(int numeromatricula) {
        this.numeromatricula = numeromatricula;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCategoriasocio() {
        return categoriasocio;
    }

    public void setCategoriasocio(int categoriasocio) {
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
