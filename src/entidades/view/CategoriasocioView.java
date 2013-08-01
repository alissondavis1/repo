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
@Table(name = "categoriasocio_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriasocioView.findAll", query = "SELECT c FROM CategoriasocioView c"),
    @NamedQuery(name = "CategoriasocioView.findByNome", query = "SELECT c FROM CategoriasocioView c WHERE c.nome = :nome")})
public class CategoriasocioView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Id
    private Long ID;

    public CategoriasocioView() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
}
