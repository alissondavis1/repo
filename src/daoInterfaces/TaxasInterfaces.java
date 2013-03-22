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
public interface TaxasInterfaces {
    
    public void NovaTaxa   (Taxa taxa);
    public void ApagarTaxa (Taxa taxa);
    public void AlterarTaxa(Taxa taxa);
    
    public List<Taxa> TaxasPorNome(String nome);
    public List<Taxa> TaxasTodas  ();
    
}
