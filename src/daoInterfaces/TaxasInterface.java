/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Taxa;
import java.util.List;

/**
 *
 * @author alexandre
 */
public interface TaxasInterface {
    
    public void AdicionarTaxa(Taxa taxa);
    public void ApagarTaxa   (Taxa taxa);
    public void AlterarTaxa  (Taxa taxa);
    
    public Taxa       TaxaPorId(int id);
    public List<Taxa> TaxasPorNome(String nome);
    public List<Taxa> TaxasTodas  ();
    
}