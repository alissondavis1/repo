/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Entrada;
import java.util.Date;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface EntradasInterface {
    
    public void NovaEntrada   (Entrada entrada);
    public void ApagarEntrada (Entrada entrada);
    public void AlterarEntrada(Entrada entrada);
   
    public float SomarEntrada();
    public float SomarEntradaFuncionario();
    public float SomarEntradaFuncionarioPorData();
            
    public List<Entrada> EntradaPorFuncionario(int IdFuncionario);
    public List<Entrada> EntradaPorData (Date DataInicial, Date DataFinal);
    public List<Entrada> EntradaPorValor(int MaxValor,int MinValor);
    public List<Entrada> EntradaPorFuncionarioPorMotivo(int Motivo,int IdFuncionario);
    public List<Entrada> EntradaPorMotivo( int IdMotivo);
    public List<Entrada> EntradaPorCedente(int IdCedente);
    public List<Entrada> EntradaPorCedentePorData(int IdCedente, Date DataInicial, Date DataFinal);
    public List<Entrada> EntradraPorSocio(int IdSocio);
    
                        
}