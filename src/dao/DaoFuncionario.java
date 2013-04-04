/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Funcionario;
import daoInterfaces.FuncionariosInterface;
import entidades.Pessoa;
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
public class DaoFuncionario implements FuncionariosInterface{

    @Override
    public void AdicionarFuncionario(Funcionario funcionario) {
      
        Session sessao = null;
        Transaction transacao = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(funcionario);
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
    public void ApagarFuncionario(Funcionario funcionario) {
       
        Session sessao= null;
        Transaction transacao = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(funcionario);
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
    public void AlterarFuncionario(Funcionario funcionario) {
    
        Session sessao = null;
        Transaction transacao = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(funcionario);
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
     public Funcionario BuscarFuncionarioCpf(String Cpf) {
        
        Funcionario funcionario = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa where cpf = :cpf");
           query.setParameter("cpf",Cpf);
           funcionario = (Funcionario)query.uniqueResult();
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
    return funcionario;
    }
    
    @Override
    public Funcionario BuscarFuncionario(String nome) {
      
        Funcionario funcionario = null;
        Session sessao = null; 
        Query query = null;
        Transaction trasacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           trasacao = sessao.beginTransaction();
           query = sessao.createQuery("from Funcionario where nome = :nome");
           query.setParameter("nome",nome);
           funcionario = (Funcionario) query.uniqueResult();
           trasacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            trasacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return funcionario;
    }

    @Override
    public List<Funcionario> BuscarFuncionarios() {
        
        List<Funcionario> funcionario = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Funcionario");
           funcionario = (List<Funcionario>)query.list();
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
    return funcionario;
    }

}
