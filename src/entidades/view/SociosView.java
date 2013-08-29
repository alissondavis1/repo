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
 * @author ACAL
 */
@Entity
@Table(name = "socios_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SociosView.findAll", query = "SELECT s FROM SociosView s"),
    @NamedQuery(name = "SociosView.findById", query = "SELECT s FROM SociosView s WHERE s.id = :id"),
    @NamedQuery(name = "SociosView.findByNome", query = "SELECT s FROM SociosView s WHERE s.nome = :nome")})
public class SociosView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "nome")
    private String nome;

    public SociosView() {
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
