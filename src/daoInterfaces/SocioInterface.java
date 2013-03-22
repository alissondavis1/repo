/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Socio;
import java.util.Date;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface SocioInterface {
    
    public void NovoSocio   (Socio socio);
    public void AlterarSocio(Socio socio);
    public void ApagarSocio (Socio socio);
   
    public List<Socio> SociosPorNome(String nome);
    public List<Socio> SocioPorRua(String Rua);
    public List<Socio> TodosOsSocios();
 
}
