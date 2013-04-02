/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import daoInterfaces.UsuarioInterface;
import entidades.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


/**
 *
 * @author alexandre
 */
public class DaoUsuario implements UsuarioInterface{

    @Override
    public void AdicionarUsuario(Usuario u) {
       
        Session sessao = null;
        Transaction transcao = null;
        
        DaoUsuario d = new DaoUsuario();
        String sql = d.ConstruirString(u);
        String Qry = null;
        
         try{
            
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.createSQLQuery(sql);
           
            transcao.commit();
            
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        }     
    }
    @Override
    public void AlterarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ApagarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void EditarPermissoesUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    private void Previlegios(Usuario u, String p)
    {
    
    
    }
    
    private String ConstruirString(Usuario u)
    {
        
    String sql = null;
    if((u.getNome()!= null)&&(u.getSenha()!=null))
    {
     sql ="create user " + u.getNome() +"@localhost identified by '"+ u.getSenha()+"' ;";
    }
    return sql;
    }
}
