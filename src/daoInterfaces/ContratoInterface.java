/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.CategoriaSocio;
import entidades.Contrato;
import java.util.List;

/**
 *
 * @author alexandre
 */
public interface ContratoInterface {
    
    public Contrato AdcionarContrato  (Contrato contrato);
    public Contrato ApagarCategoria   (Contrato contrato);
    public Contrato AtualizarCategoria(Contrato contrato);
    
    public List<Contrato> BuscarContrato(Contrato contrato);
    
}
