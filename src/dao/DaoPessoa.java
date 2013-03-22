
package dao;

import entidades.Pessoa;
import entidades.Saida;
import daoInterfaces.PessoaInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class DaoPessoa implements PessoaInterface {

    @Override
    public void InserirPessoa(Pessoa pessoa) {
      Configuration cfg = new AnnotationConfiguration(); 
        
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.save(pessoa); 
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
    public void ApagarPessoa(Pessoa pessoa) {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.delete(pessoa); 
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
    public void AlterarPessoa(Pessoa pessoa) {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.saveOrUpdate(pessoa); 
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
    public List<Pessoa> BuscarPessoaId(int id) {
        
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Pessoa> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("id",id );         
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
    public List<Pessoa> BuscarPessoaNome(String nome) {
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Pessoa> lista = new ArrayList<>();
       
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
    public List<Pessoa> BuscarTodos() {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Pessoa> lista = new ArrayList<>();
       
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

    @Override
    public Pessoa BuscarPessoaCpf(double Cpf) {
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Pessoa pessoa = new Pessoa();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("Cpf",Cpf );         
            
           pessoa = (Pessoa) query;
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
    return pessoa;   
    }
}
 