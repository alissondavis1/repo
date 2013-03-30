/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Usuario;
import java.util.List;

/**
 *
 * @author alexandre
 */
public interface UsuariosInterface {
    
    public void AdcionarUsuario(Usuario usuario);
    public void AlterarUsuario(Usuario usuario);
    public void ApagarUsuario(Usuario usuario);
    
    public      Usuario  ListarPorId(int id);
    public List<Usuario> ListarUsuario();
    public List<Usuario> ListarUsuarioPorNome();
    
}
