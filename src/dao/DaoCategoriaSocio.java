/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoInterfaces.CategoriaSocioInterface;
import entidades.CategoriaSocio;
import java.util.ArrayList;
import java.util.List;
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
    public List<CategoriaSocio> BuscarCategoria(String nome) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        List<CategoriaSocio> lista = new ArrayList<>();
        
        try{
            String HQL_QUERY="from CategoriaSocio c where c.nome = :nome ";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("nome",nome);
            
            lista = query.list();
            tx.commit(); 
           
        }
        catch(Exception e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             session.close();
        }  
    return lista;
    }

    @Override
    public List<CategoriaSocio> BuscarTodasCategorias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriaSocio BuscarCategoriaSocioPorId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
