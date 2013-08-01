/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.view;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Head
 */
@Entity
@Table(name = "endereco_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnderecoView.findAll", query = "SELECT e FROM EnderecoView e"),
    @NamedQuery(name = "EnderecoView.findById", query = "SELECT e FROM EnderecoView e WHERE e.id = :id"),
    @NamedQuery(name = "EnderecoView.findByNome", query = "SELECT e FROM EnderecoView e WHERE e.nome = :nome")})
public class EnderecoView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "nome")
    private String nome;

    public EnderecoView() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
