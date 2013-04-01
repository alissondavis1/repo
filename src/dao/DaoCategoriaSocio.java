/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoInterfaces.CategoriaSocioInterface;
import entidades.Categoriasocio;
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
    public void AdicionarCategoria(Categoriasocio categoria) {
        
        Session sessao = null;
        Transaction transacao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(categoria); 
            transacao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transacao.rollback();
        }
        finally
        {
            sessao.close(); 
        }    
    }
    
    @Override
    public void ApagarCategoria(Categoriasocio categoria) {
       
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
       
         try{
            sessao.delete(categoria); 
            transacao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transacao.rollback();
        }
        finally
        {
            sessao.close(); 
        }    
    }

    @Override
    public void AtualizarCategoria(Categoriasocio categoria) {
       
        Session sessao =  null;
        Transaction transacao = null;
       
         try{
             sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(categoria); 
            transacao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transacao.rollback();
        }
        finally
        {
            sessao.close(); 
        }    
    }

    @Override
    public Categoriasocio BuscarCategoria(String nome) {
        
        Categoriasocio categoriaSocio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa where nome = :nome");
           query.setParameter("nome", nome);
           categoriaSocio = (Categoriasocio) query.uniqueResult();
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
    return categoriaSocio;
    }

    @Override
    public List<Categoriasocio> BuscarTodasCategorias() {
        
        List<Categoriasocio> categoriaSocio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CategoriaSocio order by nome");
           categoriaSocio =  query.list();
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
    return categoriaSocio;
    }
    

    @Override
    public Categoriasocio BuscarCategoriaSocioPorId(int id) {
        
       Categoriasocio categoriaSocio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao= sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa where id = :id");
           query.setParameter("id", id);
           categoriaSocio =(Categoriasocio) query.uniqueResult();
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
    return categoriaSocio;
       
    }
}
