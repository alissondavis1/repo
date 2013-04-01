/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Motivodespesa;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface MotivoDespesasInterface {
     
    public void AdicionarMotivoEntrada      (Motivodespesa motivo);
    public void ApagarMotivoEntrada         (Motivodespesa motivo);
    public void AlterarMotivoEntrada        (Motivodespesa motivo);
    
    public List<Motivodespesa> BuscarMotivo   (String nome);
    public List<Motivodespesa> BuscarTodosMotivos ();
}
