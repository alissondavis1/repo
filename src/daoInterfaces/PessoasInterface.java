/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Pessoa;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface PessoasInterface {
 
    //inserir, apagar, alterar, buscar por nome, por matricula
    //buscar todos, soma de todos, algo mais??
    
    public void AdicionarPessoa(Pessoa pessoa);
    public void ApagarPessoa   (Pessoa pessoa);
    public void AlterarPessoa  (Pessoa pessoa);
    
    public List<Pessoa> BuscarPessoaId(int id);
    public List<Pessoa> BuscarPessoaNome(String nome);
    public List<Pessoa> BuscarTodos();
    public Pessoa       BuscarPessoaCpf(double Cpf);
    
      
}
