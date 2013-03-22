/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoInterfaces.ContasInterface;
import entidades.Conta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import java.text.SimpleDateFormat;

/**
 *
 * @author Alexandre
 */
public class DaoContasMensais implements ContasInterface {

    @Override
    public void NovaConta(Conta conta) {
        
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        
        Session session = sf.openSession(); 
        Transaction tx = session.beginTransaction();
       
         try{
            session.save(conta); 
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
    public List<Conta> ContasAbertas(Date data) {
        
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Conta> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("data",data);         
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
    public List<Conta> ContasAbertasCliente(int id) {
        
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Conta> lista = new ArrayList<>();
        
        try{
            String HQL_QUERY="FROM ContasMensais c where c.id = :id  and data_pag = null  order by nome";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("id",id);
            
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
    public List<Conta> ContasVencidas(Date data) {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Conta> lista = new ArrayList<>();
     
      
        try{
            String HQL_QUERY;
            HQL_QUERY = "";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("data",data);         
            
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
    public List<Conta> ContasVencidasPorCliente(Date data) {
        
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Conta> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY;
            HQL_QUERY = 
                    "FROM ContasMensais INNER JOIN socio "
                    + "ON ContasMensais.numeroSocio = socio.id"
                    + " where ContasMensais.data <= :data";
            
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("data",data );         
            
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
    public List<Conta> ContasTotalAbertas() {
        
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Conta> lista = new ArrayList<>();
       
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
    public List<Conta> ContaSomaPorData(Date dataInicial, Date dataFinal) {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Conta> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("dataInicial",dataInicial);         
            query.setParameter("dataInicial",dataFinal); 
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
    public List<Conta> ContasPorRua(int IdRua) {
       
        Configuration cfg = new AnnotationConfiguration(); 
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Conta> lista = new ArrayList<>();
       
        try{
            String HQL_QUERY="falta a query";
            Query query = session.createQuery(HQL_QUERY);
            query.setParameter("IdRua",IdRua);         
            
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
    public void ApagarConta(Conta conta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void AtualizarConta(Conta conta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Conta> ContasAbertasCliente(String nome) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Conta> ContasVencidasPorCliente(Date data, int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Conta> ContasVencidasPorCliente(Date data, String nome) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
