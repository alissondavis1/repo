/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Entrada;
import daoInterfaces.EntradasInterface;
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
public class DaoEntradas implements EntradasInterface {

    @Override
    public void NovaEntrada(Entrada entrada) {
       Configuration cfg = new AnnotationConfiguration(); 
        
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.saveOrUpdate(entrada); 
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
    public void ApagarEntrada(Entrada entrada) {
       Configuration cfg = new AnnotationConfiguration(); 
        
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.delete(entrada); 
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
    public void AlterarEntrada(Entrada entrada) {
       Configuration cfg = new AnnotationConfiguration(); 
        
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory(); 
        Session session = sf.openSession(); 

        Transaction tx = session.beginTransaction();
       
         try{
            session.saveOrUpdate(entrada); 
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
    public float SomarEntrada() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float SomarEntradaFuncionario() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float SomarEntradaFuncionarioPorData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Entrada> EntradaPorFuncionario(int IdFuncionario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Entrada> EntradaPorData(Date DataInicial, Date DataFinal) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Entrada> EntradaPorValor(int MaxValor, int MinValor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Entrada> EntradaPorFuncionarioPorMotivo(int Motivo, int IdFuncionario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Entrada> EntradaPorMotivo(int IdMotivo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Entrada> EntradaPorCedente(int IdCedente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Entrada> EntradaPorCedentePorData(int IdCedente, Date DataInicial, Date DataFinal) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Entrada> EntradraPorSocio(int IdSocio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
   
}
