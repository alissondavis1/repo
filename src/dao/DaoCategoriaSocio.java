/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoInterfaces.CategoriaSocioInterface;
import entidades.CategoriaSocio;
import entidades.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Alexandre
 */
public class DaoCategoriaSocio implements CategoriaSocioInterface {

    @Override
    public void AdicionarCategoria(CategoriaSocio categoria) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
       
         try{
            session.save(categoria); 
            tx.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(Exception e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            tx.rollback();
        }
        finally
        {
            session.close(); 
        }    
    }
    
    @Override
    public void ApagarCategoria(CategoriaSocio categoria) {
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
       
         try{
            session.delete(categoria); 
            tx.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(Exception e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            tx.rollback();
        }
        finally
        {
            session.close(); 
        }    
    }

    @Override
    public void AtualizarCategoria(CategoriaSocio categoria) {
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
       
         try{
            session.saveOrUpdate(categoria); 
            tx.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(Exception e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            tx.rollback();
        }
        finally
        {
            session.close(); 
        }    
    }

    @Override
    public CategoriaSocio BuscarCategoria(String nome) {
        
        CategoriaSocio categoriaSocio = null;
        Session sessao = null; 
        Query query = null;
        Transaction trasacao = null;
        
        try{
           Session session = HibernateUtil.getSessionFactory().openSession();
           Transaction tx = session.beginTransaction();
           query = sessao.createQuery("from Pessoa where nome = :nome");
           query.setParameter("nome", nome);
           categoriaSocio = (CategoriaSocio) query.uniqueResult();
           trasacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            trasacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return categoriaSocio;
    }

    @Override
    public List<CategoriaSocio> BuscarTodasCategorias() {
        
        List<CategoriaSocio> categoriaSocio = null;
        Session sessao = null; 
        Query query = null;
        Transaction trasacao = null;
        
        try{
           Session session = HibernateUtil.getSessionFactory().openSession();
           Transaction tx = session.beginTransaction();
           query = sessao.createQuery("from CategoriaSocio order by nome");
           categoriaSocio =  query.list();
           trasacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            trasacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return categoriaSocio;
    }
    

    @Override
    public CategoriaSocio BuscarCategoriaSocioPorId(int id) {
        
        CategoriaSocio categoriaSocio = null;
        Session sessao = null; 
        Query query = null;
        Transaction trasacao = null;
        
        try{
           Session session = HibernateUtil.getSessionFactory().openSession();
           Transaction tx = session.beginTransaction();
           query = sessao.createQuery("from Pessoa where id = :id");
           query.setParameter("id", id);
           categoriaSocio =(CategoriaSocio) query.uniqueResult();
           trasacao.commit(); 
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            trasacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return categoriaSocio;
       
    }
}
