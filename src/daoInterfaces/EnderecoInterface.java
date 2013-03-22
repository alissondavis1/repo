/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Endereco;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface EnderecoInterface {
      
    public void NovoEndereco(Endereco endereco);
    public void ApagarEndereco(Endereco endereco);
    public void AlterarEndereco(Endereco endereco);
   
    public List<Endereco> BuscarEnderecoNome(String nome);
    public List<Endereco> BuscarTodosEnderecos();
    public List<Endereco> BuscarTodosNome(); 
}
