/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Funcionario;
import daoInterfaces.FuncionarioInterface;
import java.util.ArrayList;
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
public class DaoFuncionario implements FuncionarioInterface{

    @Override
    public void NovoFuncionario(Funcionario funcionario) {
       Configuration cfg = new AnnotationConfiguration(); 
        
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.save(funcionario); 
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
    public void AlterarFuncionario(Funcionario funcionario) {
         
        Configuration cfg = new AnnotationConfiguration();  
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.saveOrUpdate(funcionario); 
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
    public void ApagarFuncionario(Funcionario funcionario) {
       Configuration cfg = new AnnotationConfiguration(); 
        
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.delete(funcionario); 
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
    public Funcionario BuscarFuncionarioCpf(double Cpf) {
    
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Funcionario funcionario = new Funcionario();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("Cpd",Cpf );         
            
           funcionario = (Funcionario) query.list();
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
    return funcionario;   
    }
    

    @Override
    public List<Funcionario> BuscarFuncionario(String nome) {
        
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Funcionario> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("nome",nome );         
            
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
    public List<Funcionario> BuscarFuncionarios() {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Funcionario> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);   
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
