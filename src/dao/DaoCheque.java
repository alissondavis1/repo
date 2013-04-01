/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoInterfaces.ChequesInterface;
import entidades.Cheque;
import java.util.Date;
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
public class DaoCheque implements ChequesInterface {

    @Override
    public void AdicionarCheque(Cheque cheque) {
      
        Session session = null;
        Transaction  tx = null;
       
         try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(cheque); 
            tx.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
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
    public void ApagarCheque(Cheque cheque) {
        
        Session session = null;
        Transaction  tx = null;
       
         try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(cheque); 
            tx.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
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
    public void AtualizarCheque(Cheque cheque) {
      
        Session session = null;
        Transaction  tx = null;
       
         try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(cheque); 
            tx.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
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
    public Cheque ChequesId(int idCheque) {
       
        Cheque cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
          sessao = HibernateUtil.getSessionFactory().openSession();
            tx = sessao.beginTransaction();
           query = sessao.createQuery("from Cheque where id = :id");
           query.setParameter("id",idCheque);
           cheque = (Cheque) query.uniqueResult();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }

    @Override
    public List<Cheque> ChequesAbertos(Date dataIni, Date dataFim ) {
      
        List<Cheque> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("dataIni",dataIni);
           query.setParameter("dataFim",dataFim);
           cheque =  query.list();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }

    @Override
    public List<Cheque> ChequesAbertosClientesPorIdClinete(int id) {
    
        List<Cheque> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("dataIni",id);
           cheque =  query.list();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }

    @Override
    public List<Cheque> ChequesAbertosClientesPorNomeCliente(String nome) {
       List<Cheque> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("nome",nome);
           cheque =  query.list();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }

    @Override
    public List<Cheque> ChequesVencidosPorCliente(Date data) {
       
        List<Cheque> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("data",data);
           ;
           cheque =  query.list();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }

    @Override
    public List<Cheque> ChequesTotalAbertas() {
     
        List<Cheque> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           cheque =  query.list();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }

    @Override
    public List<Cheque> ChequesSomaPorData(Date dataInicial, Date dataFinal) {
      
        List<Cheque> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("dataIni",dataInicial);
           query.setParameter("dataFim",dataFinal);
           cheque =  query.list();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }
    
    
}
