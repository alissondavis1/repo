/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.MotivoDespesa;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface MotivoDespesaInterface {
     
    public void InserirMotivoEntrada        (MotivoDespesa motivo);
    public void ApagarMotivoEntrada         (MotivoDespesa motivo);
    public void AlterarMotivoEntrada        (MotivoDespesa motivo);
    
    public List<MotivoDespesa> BuscarMotivo   (String nome);
    public List<MotivoDespesa> BuscarTodosMotivos ();
}
