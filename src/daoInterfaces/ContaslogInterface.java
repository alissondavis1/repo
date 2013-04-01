/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Contaslog;

/**
 *
 * @author alexandre
 */
public interface ContaslogInterface {
  
    public Contaslog ListarPorId  (int id);
    public Contaslog ListarPorNome(String nome);
    public Contaslog ListarTodas  ();
}
