/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Motivodespesa;
import daoInterfaces.MotivoDespesasInterface;
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
public class DaoMotivoDespesa implements MotivoDespesasInterface  {

    @Override
    public void AdicionarMotivoEntrada(Motivodespesa motivo) {
    
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(motivo); 
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
    public void ApagarMotivoEntrada(Motivodespesa motivo) {
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(motivo); 
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
    public void AlterarMotivoEntrada(Motivodespesa motivo) {
       
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.saveOrUpdate(motivo); 
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
    public List<Motivodespesa> BuscarMotivo(String nome) {
       
        Session sessao= null;
        Transaction transacao = null;
        List<Motivodespesa> lista = new ArrayList<>();
        Query query = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            String HQL_QUERY="FROM Motivosaida m where  lower(m.nome) like lower(:nome) order by nome";
            query = sessao.createQuery(HQL_QUERY);       
            lista = query.list();
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
    return lista;
    }

    @Override
    public List<Motivodespesa> BuscarTodosMotivos() {
        Session sessao= null;
        Transaction transacao = null;
        List<Motivodespesa> lista = new ArrayList<>();
        Query query = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            String HQL_QUERY="FROM Motivosaida order by nome";
            query = sessao.createQuery(HQL_QUERY);       
            lista = query.list();
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
    return lista;
    }

   
}
