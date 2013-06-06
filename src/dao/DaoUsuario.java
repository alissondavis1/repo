/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import daoInterfaces.UsuarioInterface;
import entidades.User;
import java.sql.SQLException;
import java.sql.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtilUser;


/**
 *
 * @author alexandre
 */
public class DaoUsuario implements UsuarioInterface{

    @Override
    public void AdicionarUsuario(User usuario) {
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtilUser.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(usuario); 
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

    public void novoUsuario(String usuario, String privilegio) {
       
    Session sessao =  null;  
    Transaction transaction = null;
    
    try{
        
    sessao = HibernateUtilUser.getSessionFactory().openSession();
    transaction =  sessao.beginTransaction();
    sessao.createSQLQuery(usuario).executeUpdate();
    if(!privilegio.equals("0")){sessao.createSQLQuery(privilegio).executeUpdate();}
    sessao.getTransaction().commit();
    
        System.out.println(usuario);
        System.out.println(privilegio);
    }    
    catch(HibernateException e)
    {
        System.out.println(e);
    }
      finally{
    sessao.close();
     }
    }
    @Override
    public void AlterarUsuario(User usuario) {
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtilUser.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.saveOrUpdate(usuario); 
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
    public void ApagarUsuario(User usuario) {
       Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtilUser.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(usuario); 
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
 
    public User BuscaUsuario(String nome, String pass) {
       
        User user = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtilUser.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from User where user = :nome and password = PASSWORD(:pass) ");
           //query.setString("nome","%"+nome+"%");
           query.setParameter("nome",nome);
           query.setParameter("pass", pass);
           
           user = (User) query.uniqueResult();
           transacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            transacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return user;
    }
    public boolean BuscaUsuarioBoolean(String nome) {
       
        User user = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        boolean     teste=false;
        try{
           sessao = HibernateUtilUser.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from User where user = :nome  ");
           //query.setString("nome","%"+nome+"%");
           query.setParameter("nome",nome);
           user = (User) query.uniqueResult();
           transacao.commit(); 
           
          
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            transacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
        if(user!=null){teste = true;}
        
    return teste;
    }

    
    
}
