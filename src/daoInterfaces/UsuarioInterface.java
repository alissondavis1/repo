/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Usuario;

/**
 *
 * @author alexandre
 */
public interface UsuarioInterface {

    void AdicionarUsuario(Usuario u);
    void AlterarUsuario(Usuario usuario);
    void ApagarUsuario(Usuario usuario);
    
}
