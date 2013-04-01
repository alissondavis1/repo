/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "soma_contas_pagas_por_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SomaContasPagasPorPessoa.findAll", query = "SELECT s FROM SomaContasPagasPorPessoa s"),
    @NamedQuery(name = "SomaContasPagasPorPessoa.findById", query = "SELECT s FROM SomaContasPagasPorPessoa s WHERE s.id = :id"),
    @NamedQuery(name = "SomaContasPagasPorPessoa.findByDataPag", query = "SELECT s FROM SomaContasPagasPorPessoa s WHERE s.dataPag = :dataPag"),
    @NamedQuery(name = "SomaContasPagasPorPessoa.findByDataVence", query = "SELECT s FROM SomaContasPagasPorPessoa s WHERE s.dataVence = :dataVence"),
    @NamedQuery(name = "SomaContasPagasPorPessoa.findBySomaRelogio", query = "SELECT s FROM SomaContasPagasPorPessoa s WHERE s.somaRelogio = :somaRelogio"),
    @NamedQuery(name = "SomaContasPagasPorPessoa.findBySomaContasPorTaxas", query = "SELECT s FROM SomaContasPagasPorPessoa s WHERE s.somaContasPorTaxas = :somaContasPorTaxas"),
    @NamedQuery(name = "SomaContasPagasPorPessoa.findByNome", query = "SELECT s FROM SomaContasPagasPorPessoa s WHERE s.nome = :nome"),
    @NamedQuery(name = "SomaContasPagasPorPessoa.findBySobrenome", query = "SELECT s FROM SomaContasPagasPorPessoa s WHERE s.sobrenome = :sobrenome")})
public class SomaContasPagasPorPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "dataPag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPag;
    @Basic(optional = false)
    @Column(name = "dataVence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVence;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "soma_relogio")
    private BigDecimal somaRelogio;
    @Column(name = "soma_contas_por_taxas")
    private BigDecimal somaContasPorTaxas;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "sobrenome")
    private String sobrenome;

    public SomaContasPagasPorPessoa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public BigDecimal getSomaRelogio() {
        return somaRelogio;
    }

    public void setSomaRelogio(BigDecimal somaRelogio) {
        this.somaRelogio = somaRelogio;
    }

    public BigDecimal getSomaContasPorTaxas() {
        return somaContasPorTaxas;
    }

    public void setSomaContasPorTaxas(BigDecimal somaContasPorTaxas) {
        this.somaContasPorTaxas = somaContasPorTaxas;
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
    
}
