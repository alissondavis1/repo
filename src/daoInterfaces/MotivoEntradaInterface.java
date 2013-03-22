/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.MotivoEntrada;
import java.util.List;
/**
 *
 * @author netservidor
 */
public interface MotivoEntradaInterface {
    
    public void InserirMotivoEntrada        (MotivoEntrada motivo);
    public void ApagarMotivoEntrada         (MotivoEntrada motivo);
    public void AlterarMotivoEntrada        (MotivoEntrada motivo);
  
    public List<MotivoEntrada> BuscarMotivo (String nome);
    public List<MotivoEntrada> BuscarTodosMotivos ();
}
