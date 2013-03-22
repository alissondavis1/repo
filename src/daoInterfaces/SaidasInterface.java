/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;


import entidades.Saida;
import java.util.Date;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface SaidasInterface {
    
    public void NovaSaida(Saida saida);
    public void AlterarEntrada(Saida saida);
    public void ApagarEntrada(Saida saida);
    
    public float SomaSaidas();
    public List<Saida> SaidasPorFuncionario(int IdFuncionario);
    public List<Saida> SaidasPorData(Date DataInicio, Date DataFim);
    public List<Saida> SaidaPorDataPorFuncionario(int IdFuncionario, Date DataInicio, Date DataFim) ;
    public List<Saida> SaidaPorFuncionarioPorMotivo(int Motivo, int IdFuncionario);
    public List<Saida> SaidasPorMotivo(int IdMotivoSaidas);
   
}
