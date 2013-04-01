/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.CategoriaSocio;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Alexandre
 */
public interface CategoriaSocioInterface {
    
    public void AdicionarCategoria(CategoriaSocio categoria);
    public void ApagarCategoria   (CategoriaSocio categoria);
    public void AtualizarCategoria(CategoriaSocio categoria);
    
    public CategoriaSocio       BuscarCategoria(String nome);
    public CategoriaSocio       BuscarCategoriaSocioPorId(int id);
    public List<CategoriaSocio> BuscarTodasCategorias();
}
