/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Cheque;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alexandre
 */
public interface ChequesInterfaces {
    
    public void NovoCheque   (Cheque cheque);
    public void ApagarCheque   (Cheque cheque);
    public void AtualizarCheque(Cheque cheque);
  
    public List<Cheque> ChequesAbertos(Date data);
    public List<Cheque> ChequesAbertosClientes(int id);
    public List<Cheque> ChequesAbertosClientes(String nome);
  
    public List<Cheque> ChequesVencidosPorCliente(Date data);
    public List<Cheque> ChequesVencidosPorMotivo(Date data, int id);
    public List<Cheque> ChequesVencidasPorClientePorMotivo(Date data, int motivo);
    
    public List<Cheque> ChequesTotalAbertas();
    public List<Cheque> ChequesSomaPorData(Date dataInicial, Date dataFinal);

}
