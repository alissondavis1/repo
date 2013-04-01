/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "relatorio_socio_ativos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatorioSocioAtivos.findAll", query = "SELECT r FROM RelatorioSocioAtivos r"),
    @NamedQuery(name = "RelatorioSocioAtivos.findByNumeroSocio", query = "SELECT r FROM RelatorioSocioAtivos r WHERE r.numeroSocio = :numeroSocio"),
    @NamedQuery(name = "RelatorioSocioAtivos.findByApelido", query = "SELECT r FROM RelatorioSocioAtivos r WHERE r.apelido = :apelido"),
    @NamedQuery(name = "RelatorioSocioAtivos.findByNome", query = "SELECT r FROM RelatorioSocioAtivos r WHERE r.nome = :nome"),
    @NamedQuery(name = "RelatorioSocioAtivos.findByCpf", query = "SELECT r FROM RelatorioSocioAtivos r WHERE r.cpf = :cpf"),
    @NamedQuery(name = "RelatorioSocioAtivos.findByDataMatricula", query = "SELECT r FROM RelatorioSocioAtivos r WHERE r.dataMatricula = :dataMatricula"),
    @NamedQuery(name = "RelatorioSocioAtivos.findByDataAprovacao", query = "SELECT r FROM RelatorioSocioAtivos r WHERE r.dataAprovacao = :dataAprovacao"),
    @NamedQuery(name = "RelatorioSocioAtivos.findByCategoria", query = "SELECT r FROM RelatorioSocioAtivos r WHERE r.categoria = :categoria")})
public class RelatorioSocioAtivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "numeroSocio")
    private int numeroSocio;
    @Column(name = "apelido")
    private String apelido;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "dataMatricula")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMatricula;
    @Column(name = "dataAprovacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAprovacao;
    @Basic(optional = false)
    @Column(name = "Categoria")
    private String categoria;

    public RelatorioSocioAtivos() {
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
