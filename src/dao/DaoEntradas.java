/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoInterfaces.EntradasInterface;
import entidades.Entrada;
import java.math.BigDecimal;
import java.util.Date;
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
public class DaoEntradas implements EntradasInterface {

    @Override
    public void AdicionarEntrada(Entrada entrada) {
        
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(entrada); 
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
    public void ApagarEntrada(Entrada entrada) {
        
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(entrada); 
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
    public void AlterarEntrada(Entrada entrada) {
       Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.saveOrUpdate(entrada); 
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
    public BigDecimal SomarEntrada() {
        
        BigDecimal entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createSQLQuery("select sum(valor) from entrada where data between :inicio and :fim");
          //  query.setParameter("inicio",inicio);
          // query.setParameter("fim",fim);
    
           entrada = (BigDecimal) query.uniqueResult();
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
    return entrada;
    }

    @Override
    public BigDecimal SomarEntradaPorFuncionario(int idfuncionario) {
        BigDecimal entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createSQLQuery("select sum(valor) from entrada where  idFuncionario = :idfuncioanario");
           //query.setParameter("inicio",inicio);
           //query.setParameter("fim",fim);
           query.setParameter("idfuncionario",idfuncionario);
           
           entrada = (BigDecimal) query.uniqueResult();
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
    return entrada;
    
    }

    @Override
    public BigDecimal SomarEntradaPorData(Date inicio, Date fim) {
       BigDecimal entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createSQLQuery("select sum(valor) from entrada where data between :incio and :fim ");
           query.setParameter("inicio",inicio);
           query.setParameter("fim",fim);
           //query.setParameter("idfuncionario",idfuncionario);
           
           entrada = (BigDecimal) query.uniqueResult();
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
    return entrada;
    
    }
   
    @Override
    public BigDecimal SomarEntradaPorFuncionarioPorData(int idfuncionario, Date inicio, Date fim) {
    
        BigDecimal entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createSQLQuery("select sum(valor) from entrada where  idFuncionario = :idfuncioanario and data between :inicio and :fim");
           query.setParameter("inicio",inicio);
           query.setParameter("fim",fim);
           query.setParameter("idfuncionario",idfuncionario);
           
           entrada = (BigDecimal) query.uniqueResult();
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
    return entrada;
        
    }

    @Override
    public Entrada EntradaPorId(int id) {
    
        Entrada entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where  id = :id");
           //query.setParameter("inicio",inicio);
           //query.setParameter("fim",fim);
           query.setParameter("id",id);
           
           entrada = (Entrada) query.uniqueResult();
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
    return entrada;
    
    }    
    

    @Override
    public List<Entrada> EntradaPorFuncionario(int id) {
       
        List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where idfuncionario = :idfuncionario");
           //query.setParameter("inicio",inicio);
           //query.setParameter("fim",fim);
           query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada;
    }

    @Override
    public List<Entrada> EntradaPorData(Date inicio, Date fim) {
    
        List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where  data between :incio and :fim");
           query.setParameter("inicio",inicio);
           query.setParameter("fim",fim);
           //query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada;
        
    
    }

    @Override
    public List<Entrada> EntradaPorValor(int max, int min) {
    List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where  valor between :max and :min");
           query.setParameter("max",max);
           query.setParameter("min",min);
           //query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada; 
    }

    @Override
    public List<Entrada> EntradaPorFuncionarioPorMotivo(int motivo, int idfuncionario) {
       List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where  idmotivo = :motivo and idfuncionario =:idfuncionario");
           query.setParameter("motivo",motivo);
           query.setParameter("idfuncionario",idfuncionario);
           //query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada;
    }

    @Override
    public List<Entrada> EntradaPorMotivo(int idMotivo) {
    
        List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where idMotivo = :idMotivo");
           query.setParameter("idMotivo",idMotivo);
           //query.setParameter("fim",fim);
           //query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada;
        }

    @Override
    public List<Entrada> EntradraPorSocio(int idSocio) {
        
        List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where idSocio =:idSocio ");
           query.setParameter("idSocio",idSocio);
           //query.setParameter("fim",fim);
           //query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada;
        }

    

}
