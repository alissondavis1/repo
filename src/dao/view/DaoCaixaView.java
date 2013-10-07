/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.view;

import entidades.view.CaixaView;
import entidades.view.SociosView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Head
 */
public class DaoCaixaView {
    
     public List<CaixaView> BuscarTodosCaixaView() {
       
        List<CaixaView> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView ");
           endereco = query.list();
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
    return endereco;
    }
    
    public List<CaixaView> BuscarTodosCaixaViewDatePagamento(Date ini, Date fim) {
        
        List<CaixaView> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
      
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        //transformar em string para evitar passar o horario.
        String inis = sdf.format(ini);
        String fims = sdf.format(fim);
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView where Pagamento between :ini and :fim");
           query.setParameter("ini",inis);
           query.setParameter("fim",fims);
           endereco = query.list();
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
    return endereco;
    }
    public List<CaixaView> BuscarTodosCaixaViewDateVencimento(Date ini, Date fim) {
        
        List<CaixaView> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView where vencimento between :ini and :fim");
           query.setParameter("ini",ini);
           query.setParameter("fim",fim);
           endereco = query.list();
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
    return endereco;
    }
}

