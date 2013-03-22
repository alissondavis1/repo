/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Saida;
import entidades.Socio;
import daoInterfaces.SaidasInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Alexandre
 */
public class DaoSaidas implements SaidasInterface{

    @Override
    public void NovaSaida(Saida saida) {
       Configuration cfg = new AnnotationConfiguration(); 
        
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.save(saida); 
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
    public void AlterarEntrada(Saida saida) {
       Configuration cfg = new AnnotationConfiguration(); 
        
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.delete(saida); 
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
    public void ApagarEntrada(Saida saida) {
       Configuration cfg = new AnnotationConfiguration(); 
        
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.saveOrUpdate(saida); 
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
    public float SomaSaidas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Saida> SaidasPorFuncionario(int IdFuncionario) {
         Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Saida> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("nome",'%'+IdFuncionario+'%' );         
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
    public List<Saida> SaidasPorData(Date DataInicio, Date DataFim) {
        
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Saida> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("dataInicio",DataInicio );         
            query.setParameter("dataFim",DataFim );   
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
    public List<Saida> SaidaPorDataPorFuncionario(int IdFuncionario, Date DataInicio, Date DataFim) {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Saida> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("IdFuncionario",IdFuncionario );
            query.setParameter("dataInicio",DataInicio );         
            query.setParameter("dataFim",DataFim );   
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
    public List<Saida> SaidaPorFuncionarioPorMotivo(int Motivo, int IdFuncionario) {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Saida> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("Motivo",Motivo );         
            query.setParameter("IdFuncionario",IdFuncionario );   
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
    public List<Saida> SaidasPorMotivo(int IdMotivoSaidas) {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Saida> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("IdMotivoSaidas",IdMotivoSaidas );         
            
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
}