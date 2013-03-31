/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.EntradasLog;
import java.util.List;
/**
 *
 * @author alexandre
 */
public interface EntradasLogInterface {
   
    public      EntradasLog  BuscarEntradasLogPorId();
    public List<EntradasLog> BuscarEntradaLog(String nome);
    public List<EntradasLog> BuscarTodasEntradasLog();
     
}
