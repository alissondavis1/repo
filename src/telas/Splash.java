/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.UnsupportedLookAndFeelException;
import org.hibernate.Session;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import util.HibernateUtil;


public class Splash extends JWindow{
    
     AbsoluteConstraints absBarra, absImage;
     AbsoluteLayout absl;
     ImageIcon image;
     JLabel label, texto;
     JProgressBar progress;
    public Splash(){
        
        absBarra = new AbsoluteConstraints(0,480);
        absImage = new AbsoluteConstraints(0,0);
        
        absl = new AbsoluteLayout();
        label = new JLabel();
        image = new ImageIcon(getClass().getResource("/img/acal.jpg"));
        label.setIcon(image);
        progress = new JProgressBar();
        progress.setPreferredSize(new Dimension(794,20));
        progress.setBackground(Color.GREEN);
        progress.setString("Carregando");
        progress.setStringPainted(true);
        setLayout(absl);
        getContentPane().add(label,absImage);
        getContentPane().add(progress,absBarra);
        new Thread(){
            
            public void run(){
                
                int i = 0;
                while(i < 101){
                    
                    progress.setValue(i);
                    i++;
                   
                    try {   
                       
                  
                    
                       
                        sleep(60);
                    } catch (Exception ex) {
                  
                        Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                        System.exit(1);
                    }
                }
                new TelaPrincipal().setVisible(true);
                dispose();
               
            }
            
            
        }.start();
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/5 ,   
        Toolkit.getDefaultToolkit().getScreenSize().height/5 );  
        pack();
        setVisible(true);
        
        
        
    }
    
    private  void testarConexao1(){
        
        
        new Thread(){
            public void run(){
            Session session= null;
            try{
            
            progress.setString("Testando Conexão com o Banco");
            session = HibernateUtil.getSessionFactory().openSession();
           
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Erro de conexão ao banco de dados");
            
        }finally{
            if(session != null){
                session.close();
            }
            
        }
            
            progress.setString("Conexão bem sucedida...");
                
           
            }
            
            
        }.start();
        
    }
    
    
    
    public static void main(String[] args) {
        
        try {
            Properties p = new Properties();
            p.put("logoString", "ACAL2000");
            com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme(p);
           
            javax.swing.UIManager.setLookAndFeel(new com.jtattoo.plaf.mcwin.McWinLookAndFeel());
            /* Create and display the form */
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        new Splash().testarConexao1();
        
        
        
    }
    
}