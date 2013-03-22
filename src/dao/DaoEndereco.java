/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
 
import entidades.Endereco;
import daoInterfaces.EnderecoInterface;
import java.util.ArrayList;
/**
 *
 * @author Alexandre
 */
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
public class DaoEndereco implements EnderecoInterface{

    @Override
    public void NovoEndereco(Endereco endereco) {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.save(endereco); 
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
    public void ApagarEndereco(Endereco endereco) {
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.save(endereco); 
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
    public void AlterarEndereco(Endereco endereco) {
            
        Configuration cfg = new AnnotationConfiguration(); 
        
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.saveOrUpdate(endereco); 
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
    public List<Endereco> BuscarEnderecoNome(String nome) {
      
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        List<Endereco> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="FROM Endereco e where  lower(e.nome) like lower(:nome) order by nome";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("nome",'%'+nome+'%' );       
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
    public List<Endereco> BuscarTodosEnderecos() {
        
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Endereco> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="FROM Endereco order by nome";
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
    public List<Endereco> BuscarTodosNome() {
       Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="select * FROM Endereco as endereco order by nome";
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
