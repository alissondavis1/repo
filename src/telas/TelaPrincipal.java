/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.DaoChequeslog;
import dao.DaoContaslog;
import dao.DaoEntradaslog;
import dao.DaoUsuario;
import entidades.Chequeslog;
import entidades.Contaslog;
import entidades.Entradaslog;
import entidades.User;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UnsupportedLookAndFeelException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import telas.GeradorUsuario.CriadorUsuario;
import telas.relatorios.TelaRelatoriosCheques;
import telas.relatorios.TelaRelatoriosEntradas;
import telas.relatorios.TelaRelatoriosSaidas;
import telas.relatorios.TelaRelatoriosSocios;

import util.HibernateUtil;

/**
 *
 * @author Alexandre 
 * @author Alisson 
 */
public class TelaPrincipal extends javax.swing.JFrame {
   // private boolean tray = false;
    private Calendar c;
    SimpleDateFormat sdf = new SimpleDateFormat();
    private  TrayIcon trayIcon = null;
    private SystemTray systemTray;
    /**
     *
     * Aqui os componentes são iniciados , a classe Calendar é instanciada para
     * manipulação de datas e a classe DateFormat.
     *
     */
    public TelaPrincipal() {
        // setLocationRelativeTo(null);
       
        initComponents();
        c = Calendar.getInstance(new Locale("pt", "BR"));
        DateFormat df = SimpleDateFormat.getDateInstance(SimpleDateFormat.DATE_FIELD, new Locale("pt", "BR"));
        jDesktopPaneContas.setVisible(false);
        jInternalFrameContas1.setVisible(false);
        jDesktopPaneRelatorios.setVisible(false);
        jInternalFrameRelatorios.setVisible(false);
        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream(new File("properties/hibernate.properties")));
            if(!prop.getProperty("hibernate.connection.username").equals("root")){
                
                jMenuAuditoria.setVisible(false);
                 jMenuItemCriarUsuarios.setVisible(false);       
            }
            
        }catch(Exception e){
           JOptionPane.showMessageDialog(this,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE); 
        }
        // A data do sistema.

        jLabel1.setText(df.format(c.getTime()));

       ControlaEsc();
        //  Start do TimerBean para atualizar a hora no sistema

        timer1.start();

        // redimensionamento e posicionamento da tela principal, para que fique alinhada na parte de cima do monitor.

        //Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setBounds(0, 0, d.width, d.height);

      // if(tray == false){ 
        systemTray = SystemTray.getSystemTray();
        
        trayIcon = new TrayIcon(new ImageIcon(getClass().getResource("/img/ico.png")).getImage(), "Acal2000", popupMenu1);
        trayIcon.setImageAutoSize(true);
        System.out.println("");
       
       try{
           systemTray.add(trayIcon);
       }catch(AWTException e){
        
           System.out.println("EROOOOOOOOOOOOOOOOOOOOOO");
        e.printStackTrace();
       }
   // }

    }

    @Override
 public boolean isFocusable(){
     
     return true;
 }

    
  private void ControlaEsc() {  
        KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true);  
  
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ks, "esc");  
        getRootPane().getActionMap().put("esc", new AbstractAction() {  
  
            @Override  
            public void actionPerformed(ActionEvent ae) {  
  
               
                    if(jInternalFrameContas1.isVisible()){
                        
                        jButton4ActionPerformed(ae);
                        
                    }else if(jInternalFrameRelatorios.isVisible()){
                        
                         jButtonInternalFrameRelatoriosVoltar1ActionPerformed(ae);
                    }
                  
            }
        });  
    }  
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        popupMenu1 = new java.awt.PopupMenu();
        menuItemPopupSair = new java.awt.MenuItem();
        menuItemPopupCadastros = new java.awt.MenuItem();
        jPanelBotoesTelaPrincipal = new javax.swing.JPanel();
        jButtonTelaPrincipalLogoff = new javax.swing.JButton();
        jButtonTelaPrincipalRelatorios = new javax.swing.JButton();
        jButtonTelaPrincipalCaixa = new javax.swing.JButton();
        jButtonTelaPrincipalCadastros = new javax.swing.JButton();
        jDesktopPaneContas = new javax.swing.JDesktopPane();
        jInternalFrameContas1 = new javax.swing.JInternalFrame();
        jPanelInternalFrameContas = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanelImagemTelaPrincipal = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelDataHoraTelaPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDesktopPaneRelatorios = new javax.swing.JDesktopPane();
        jInternalFrameRelatorios = new javax.swing.JInternalFrame();
        jPanelInternalFrameRelatorios = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButtonFuncionarioRelatorio = new javax.swing.JButton();
        jButtonInternalFrameRelatoriosVoltar1 = new javax.swing.JButton();
        jButtonTaxasRelatorio = new javax.swing.JButton();
        jButtonCategoriaSocioRelatorio = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButtonEntrada = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemLogradouros = new javax.swing.JMenuItem();
        jMenuItemFuncionarios = new javax.swing.JMenuItem();
        jMenuItemReceitas = new javax.swing.JMenuItem();
        jMenuItemCategoria_Socio = new javax.swing.JMenuItem();
        jMenuItemSocio = new javax.swing.JMenuItem();
        jMenuItemTipoDespesa = new javax.swing.JMenuItem();
        jMenuItemDespesa = new javax.swing.JMenuItem();
        jMenuItemTipoReceita = new javax.swing.JMenuItem();
        jMenuItemReceita = new javax.swing.JMenuItem();
        jMenuItemContrato = new javax.swing.JMenuItem();
        jMenuItemTaxas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemAgua = new javax.swing.JMenuItem();
        jMenuItemSolicita_Socio = new javax.swing.JMenuItem();
        jMenuItemCriarUsuarios = new javax.swing.JMenuItem();
        jMenuItemTelaPrincipalBackup = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuAuditoria = new javax.swing.JMenu();
        jMenuItemAuditoriaCheques = new javax.swing.JMenuItem();
        jMenuItemAuditoriaContas = new javax.swing.JMenuItem();
        jMenuItemAuditoriaEntradas = new javax.swing.JMenuItem();
        jMenuItemAuditoriaSaidas = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        popupMenu1.setLabel("popupMenu1");

        menuItemPopupSair.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        menuItemPopupSair.setLabel("Sair");
        menuItemPopupSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPopupSairActionPerformed(evt);
            }
        });
        popupMenu1.add(menuItemPopupSair);
        popupMenu1.addSeparator();
        menuItemPopupCadastros.setLabel("Cadastros");
        menuItemPopupCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPopupCadastrosActionPerformed(evt);
            }
        });
        popupMenu1.add(menuItemPopupCadastros);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ACAL2000");
        setBackground(new java.awt.Color(204, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelBotoesTelaPrincipal.setOpaque(false);
        jPanelBotoesTelaPrincipal.setLayout(new java.awt.GridBagLayout());

        jButtonTelaPrincipalLogoff.setIcon(new ImageIcon(getClass().getResource("/img/logoff.png")));
        jButtonTelaPrincipalLogoff.setText(" Logoff");
        jButtonTelaPrincipalLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTelaPrincipalLogoffActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        jPanelBotoesTelaPrincipal.add(jButtonTelaPrincipalLogoff, gridBagConstraints);

        jButtonTelaPrincipalRelatorios.setIcon(new ImageIcon(getClass().getResource("/img/relatorios.png")));
        jButtonTelaPrincipalRelatorios.setText("Relatórios");
        jButtonTelaPrincipalRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTelaPrincipalRelatoriosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        jPanelBotoesTelaPrincipal.add(jButtonTelaPrincipalRelatorios, gridBagConstraints);

        jButtonTelaPrincipalCaixa.setIcon(new ImageIcon(getClass().getResource("/img/caixa.png")));
        jButtonTelaPrincipalCaixa.setText("Caixa");
        jButtonTelaPrincipalCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTelaPrincipalCaixaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        jPanelBotoesTelaPrincipal.add(jButtonTelaPrincipalCaixa, gridBagConstraints);

        jButtonTelaPrincipalCadastros.setIcon(new ImageIcon(getClass().getResource("/img/Cadastros.png")));
        jButtonTelaPrincipalCadastros.setText("Cadastros");
        jButtonTelaPrincipalCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTelaPrincipalCadastrosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 3, 0, 0);
        jPanelBotoesTelaPrincipal.add(jButtonTelaPrincipalCadastros, gridBagConstraints);

        jInternalFrameContas1.setBackground(new java.awt.Color(51, 153, 255));
        jInternalFrameContas1.setFrameIcon(null);
        jInternalFrameContas1.setVisible(true);

        jPanelInternalFrameContas.setOpaque(false);
        jPanelInternalFrameContas.setLayout(new java.awt.GridBagLayout());

        jPanel3.setOpaque(false);

        jButton1.setText("Contas a Receber");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Contas a Pagar");

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Gerar Contas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(69, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 308, 0, 316);
        jPanelInternalFrameContas.add(jPanel3, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(51, 255, 255));
        jLabel3.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jLabel3.setMinimumSize(new java.awt.Dimension(683, 10));
        jLabel3.setPreferredSize(new java.awt.Dimension(920, 585));

        javax.swing.GroupLayout jInternalFrameContas1Layout = new javax.swing.GroupLayout(jInternalFrameContas1.getContentPane());
        jInternalFrameContas1.getContentPane().setLayout(jInternalFrameContas1Layout);
        jInternalFrameContas1Layout.setHorizontalGroup(
            jInternalFrameContas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInternalFrameContas, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
            .addGroup(jInternalFrameContas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE))
        );
        jInternalFrameContas1Layout.setVerticalGroup(
            jInternalFrameContas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInternalFrameContas, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
            .addGroup(jInternalFrameContas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
        );

        jInternalFrameContas1.setBounds(0, 0, 920, 550);
        jDesktopPaneContas.add(jInternalFrameContas1, javax.swing.JLayeredPane.PALETTE_LAYER);

        jPanelImagemTelaPrincipal.setOpaque(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agua.jpg"))); // NOI18N
        jLabel4.setMaximumSize(jPanelImagemTelaPrincipal.getMaximumSize());
        jLabel4.setMinimumSize(jPanelImagemTelaPrincipal.getMinimumSize());

        javax.swing.GroupLayout jPanelImagemTelaPrincipalLayout = new javax.swing.GroupLayout(jPanelImagemTelaPrincipal);
        jPanelImagemTelaPrincipal.setLayout(jPanelImagemTelaPrincipalLayout);
        jPanelImagemTelaPrincipalLayout.setHorizontalGroup(
            jPanelImagemTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
            .addGroup(jPanelImagemTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE))
        );
        jPanelImagemTelaPrincipalLayout.setVerticalGroup(
            jPanelImagemTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
            .addGroup(jPanelImagemTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE))
        );

        jPanelDataHoraTelaPrincipal.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanelDataHoraTelaPrincipalLayout = new javax.swing.GroupLayout(jPanelDataHoraTelaPrincipal);
        jPanelDataHoraTelaPrincipal.setLayout(jPanelDataHoraTelaPrincipalLayout);
        jPanelDataHoraTelaPrincipalLayout.setHorizontalGroup(
            jPanelDataHoraTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataHoraTelaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addGap(96, 96, 96)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDataHoraTelaPrincipalLayout.setVerticalGroup(
            jPanelDataHoraTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataHoraTelaPrincipalLayout.createSequentialGroup()
                .addContainerGap(399, Short.MAX_VALUE)
                .addGroup(jPanelDataHoraTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(145, 145, 145))
        );

        jInternalFrameRelatorios.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrameRelatorios.setFrameIcon(null);
        jInternalFrameRelatorios.setVisible(true);

        jPanelInternalFrameRelatorios.setOpaque(false);
        jPanelInternalFrameRelatorios.setLayout(new java.awt.GridBagLayout());

        jPanel4.setOpaque(false);

        jButtonFuncionarioRelatorio.setText("Funcionários");

        jButtonInternalFrameRelatoriosVoltar1.setText("Voltar");
        jButtonInternalFrameRelatoriosVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInternalFrameRelatoriosVoltar1ActionPerformed(evt);
            }
        });

        jButtonTaxasRelatorio.setText("Taxas");
        jButtonTaxasRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaxasRelatorioActionPerformed(evt);
            }
        });

        jButtonCategoriaSocioRelatorio.setText("Categorias dos Socios");
        jButtonCategoriaSocioRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCategoriaSocioRelatorioActionPerformed(evt);
            }
        });

        jButton5.setText("Cheques");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButtonEntrada.setText("Entradas");
        jButtonEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntradaActionPerformed(evt);
            }
        });

        jButton7.setText("Saidas");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Socios");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCategoriaSocioRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTaxasRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jButtonFuncionarioRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jButtonInternalFrameRelatoriosVoltar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(361, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton5, jButton7, jButton8, jButtonCategoriaSocioRelatorio, jButtonEntrada, jButtonFuncionarioRelatorio, jButtonInternalFrameRelatoriosVoltar1, jButtonTaxasRelatorio});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTaxasRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFuncionarioRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCategoriaSocioRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(jButtonInternalFrameRelatoriosVoltar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(480, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton5, jButton7, jButton8, jButtonCategoriaSocioRelatorio, jButtonEntrada, jButtonFuncionarioRelatorio, jButtonInternalFrameRelatoriosVoltar1, jButtonTaxasRelatorio});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 404;
        gridBagConstraints.ipady = 586;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelInternalFrameRelatorios.add(jPanel4, gridBagConstraints);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/relatorios.jpg"))); // NOI18N
        jLabel5.setMaximumSize(jPanelInternalFrameRelatorios.getMaximumSize());
        jLabel5.setMinimumSize(jPanelInternalFrameRelatorios.getMinimumSize());

        javax.swing.GroupLayout jInternalFrameRelatoriosLayout = new javax.swing.GroupLayout(jInternalFrameRelatorios.getContentPane());
        jInternalFrameRelatorios.getContentPane().setLayout(jInternalFrameRelatoriosLayout);
        jInternalFrameRelatoriosLayout.setHorizontalGroup(
            jInternalFrameRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInternalFrameRelatorios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
            .addGroup(jInternalFrameRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE))
        );
        jInternalFrameRelatoriosLayout.setVerticalGroup(
            jInternalFrameRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameRelatoriosLayout.createSequentialGroup()
                .addComponent(jPanelInternalFrameRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jInternalFrameRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
        );

        jInternalFrameRelatorios.setBounds(0, 0, 930, 740);
        jDesktopPaneRelatorios.add(jInternalFrameRelatorios, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 0, 255), new java.awt.Color(51, 0, 255)));

        jMenu.setText("Menu");

        jMenuCadastros.setText("Cadastros");

        jMenuItemLogradouros.setText("Logradouro");
        jMenuItemLogradouros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogradourosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemLogradouros);

        jMenuItemFuncionarios.setText("Funcionarios");
        jMenuItemFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionariosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemFuncionarios);

        jMenuItemReceitas.setText("Receitas");
        jMenuItemReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReceitasActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemReceitas);

        jMenuItemCategoria_Socio.setText("Categoria Socio");
        jMenuItemCategoria_Socio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCategoria_SocioActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCategoria_Socio);

        jMenuItemSocio.setText("Socio");
        jMenuItemSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSocioActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemSocio);

        jMenuItemTipoDespesa.setText("Tipo de Despesa");
        jMenuItemTipoDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTipoDespesaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemTipoDespesa);

        jMenuItemDespesa.setText("Despesa");
        jMenuItemDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDespesaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemDespesa);

        jMenuItemTipoReceita.setText("Tipo de Receita");
        jMenuItemTipoReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTipoReceitaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemTipoReceita);

        jMenuItemReceita.setText("Receita");
        jMenuItemReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReceitaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemReceita);

        jMenuItemContrato.setText("Contrato");
        jMenuItemContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemContratoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemContrato);

        jMenuItemTaxas.setText("Taxas");
        jMenuItemTaxas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTaxasActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemTaxas);

        jMenu.add(jMenuCadastros);

        jMenu2.setText("Solicitações");

        jMenuItemAgua.setText("Ligação de Água");
        jMenu2.add(jMenuItemAgua);

        jMenuItemSolicita_Socio.setText("Filiação de Sócio");
        jMenu2.add(jMenuItemSolicita_Socio);

        jMenu.add(jMenu2);

        jMenuItemCriarUsuarios.setText("Criar Usuarios");
        jMenuItemCriarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCriarUsuariosActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemCriarUsuarios);

        jMenuItemTelaPrincipalBackup.setText("Backup");
        jMenuItemTelaPrincipalBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTelaPrincipalBackupActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemTelaPrincipalBackup);
        jMenu.add(jSeparator2);

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemSair);

        jMenuBar1.add(jMenu);

        jMenuAuditoria.setText("Auditoria");

        jMenuItemAuditoriaCheques.setText("Log de Cheques");
        jMenuItemAuditoriaCheques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAuditoriaChequesActionPerformed(evt);
            }
        });
        jMenuAuditoria.add(jMenuItemAuditoriaCheques);

        jMenuItemAuditoriaContas.setText("Log de Contas");
        jMenuItemAuditoriaContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAuditoriaContasActionPerformed(evt);
            }
        });
        jMenuAuditoria.add(jMenuItemAuditoriaContas);

        jMenuItemAuditoriaEntradas.setText("Log de Entradas");
        jMenuItemAuditoriaEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAuditoriaEntradasActionPerformed(evt);
            }
        });
        jMenuAuditoria.add(jMenuItemAuditoriaEntradas);

        jMenuItemAuditoriaSaidas.setText("Log de Saidas");
        jMenuItemAuditoriaSaidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAuditoriaSaidasActionPerformed(evt);
            }
        });
        jMenuAuditoria.add(jMenuItemAuditoriaSaidas);

        jMenuBar1.add(jMenuAuditoria);

        jMenuSair.setText("Sair");
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBotoesTelaPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
            .addComponent(jPanelDataHoraTelaPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPaneContas, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelImagemTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPaneRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBotoesTelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jPanelDataHoraTelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPaneContas, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelImagemTelaPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPaneRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonTelaPrincipalCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTelaPrincipalCadastrosActionPerformed

      
        new TelaCadastros(this).setVisible(true);

    }//GEN-LAST:event_jButtonTelaPrincipalCadastrosActionPerformed

   
    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenuSairMouseClicked

   
    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jButtonTelaPrincipalRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTelaPrincipalRelatoriosActionPerformed


        //Thread para gerar relatório. Utilizei jdbc como conexão para passar no método fillReport da classe JasperFillManager
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Connection conn = HibernateUtil.getConnection();
//                    Map<String, Object> paramets = new HashMap<>();
//                    JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/relatorios.jrxml"));
//
//                    JasperPrint jasper = JasperFillManager.fillReport(report, paramets, conn);
//                    JasperViewer.viewReport(jasper, false);
//
//
//                } catch (Exception ex) {
//                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }.start();
        
        jPanelBotoesTelaPrincipal.setVisible(false);
        jPanelDataHoraTelaPrincipal.setVisible(false);
        jPanelImagemTelaPrincipal.setVisible(false);
        jDesktopPaneRelatorios.setVisible(true);
        jInternalFrameRelatorios.setVisible(true);
        try {
            jInternalFrameRelatorios.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonTelaPrincipalRelatoriosActionPerformed

    
    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime

        c = Calendar.getInstance();
        DateFormat df = SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, new Locale("pt", "BR"));
        jLabel2.setText(df.format(c.getTime()));



    }//GEN-LAST:event_timer1OnTime

  
    private void jMenuItemFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionariosActionPerformed

        new TelaCadastros(this, evt).setVisible(true);

    }//GEN-LAST:event_jMenuItemFuncionariosActionPerformed

    
    private void jMenuItemLogradourosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogradourosActionPerformed
        new TelaCadastros(this, evt).setVisible(true);
    }//GEN-LAST:event_jMenuItemLogradourosActionPerformed

    
    private void jMenuItemReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReceitasActionPerformed
        new TelaCadastros(this, evt).setVisible(true);
    }//GEN-LAST:event_jMenuItemReceitasActionPerformed

    private void jMenuItemCategoria_SocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCategoria_SocioActionPerformed
        new TelaCadastros(this, evt).setVisible(true);
    }//GEN-LAST:event_jMenuItemCategoria_SocioActionPerformed

    private void jMenuItemSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSocioActionPerformed
        new TelaCadastros(this, evt).setVisible(true);
    }//GEN-LAST:event_jMenuItemSocioActionPerformed

    private void jMenuItemTipoDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTipoDespesaActionPerformed
        new TelaCadastros(this, evt).setVisible(true);
    }//GEN-LAST:event_jMenuItemTipoDespesaActionPerformed

    private void jMenuItemDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDespesaActionPerformed
        new TelaCadastros(this, evt).setVisible(true);
    }//GEN-LAST:event_jMenuItemDespesaActionPerformed

    
    private void jMenuItemTipoReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTipoReceitaActionPerformed
        new TelaCadastros(this, evt).setVisible(true);
    }//GEN-LAST:event_jMenuItemTipoReceitaActionPerformed

    
    private void jMenuItemReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReceitaActionPerformed
        new TelaCadastros(this, evt).setVisible(true);
    }//GEN-LAST:event_jMenuItemReceitaActionPerformed

    
    private void jMenuItemContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemContratoActionPerformed
        new TelaCadastros(this, evt).setVisible(true);
    }//GEN-LAST:event_jMenuItemContratoActionPerformed

   
    private void jMenuItemTaxasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTaxasActionPerformed
        new TelaCadastros(this, evt).setVisible(true);
    }//GEN-LAST:event_jMenuItemTaxasActionPerformed

    
    private void jMenuItemTelaPrincipalBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTelaPrincipalBackupActionPerformed

        //PrintWriter para escrever os dados do arquivo sql, criado automaticamente pelo programa , para o arquivo onde o usuário desejar salvar o .sql
        PrintWriter pw = null;
        //Esse Scanner vai ler os dados do arquivo sql gerado automaticamente e passar para o PrintWriter.
        Scanner sc = null;
        try {

            // String comando = "cmd /c mysqldump -uroot -p123 acal >" + getClass().getResource("/Sql/").getPath().substring(1) + "acal.sql";
            //Criei um File passando um caminho de um diretório, que em primeira instancia não existe.
            File caminho = new File("sql/");
            //Verifico se o diretório existe, caso contrário ele será criado com o método mkdir() da classe File.
            if (!caminho.exists()) {
                caminho.mkdir();
                //Files.createDirectory(caminho.toPath());
            }
            //Utilizei a classe Calendar e SimpleDateFormat para gravar no nome do arquivo a data atual.
            Calendar c = Calendar.getInstance();
            //Precisei separar a data do tipo DD/MM/yyy para DDMMyyy , para não dar erro no comando do Runtime.
            String[] s = SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT).format(c.getTime()).split("/");
            String data = "";

            //Aqui eu junto as Strings da data que separei com o método split.
            for (String temp : s) {

                data = data.concat(temp);
            }

            //Variável que armazena o modelo de nome do arquivo .sql.
            String acal = "acal" + data + ".sql";
            //Variável que armazena o comando do mysqldump que ira ser passado na classe Runtime.
            String comando = "cmd /c mysqldump -uroot -p123 acal > sql/" + acal;

            //Aqui utilizo os métodos da classe Runtime para executar o comando. o método exec retorna um Process.
            Process p = Runtime.getRuntime().exec(comando);
            //bloco Try/Catch para testar a execução do comando no processo de exportação do banco de dados.
            try {
                if (p.waitFor() == 0) {

                    System.out.println("mysqldump executado");

                } else {
                    System.out.println("erro no mysqldump");
                }
            } catch (InterruptedException ex) {

                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }


            // File file = new File(getClass().getResource("/Sql/acal.sql").getPath());
            //Criei um File passando o arquivo gerado pelo mysqldump. Desse arquivo irei ler com o Scanner e escrever em um novo arquivo .sql, escolhido pelo usuário, utilizando o PrintWriter.
            File file = new File("sql/" + acal);
            //FileChooser para o usuário escolher onde vai salvar o arquivo .sql.
            JFileChooser jf = new JFileChooser();




            //o método showSaveDilog retorna um int, que serve para saber em qual botão o usuário clicou na tela do FileChooser. Além disso ele faz com que o FileChooser exiba uma tela para salvar arquivos.
            int result = jf.showSaveDialog(this);

            //Aqui eu testo o retorno do showSaveDialog, se o usuário clicar em salvar o if é executado e o backup é gerado.
            if (result == JFileChooser.APPROVE_OPTION) {


                //Novo File que pega o caminho escolhido pelo usuário e, o nome do arquivo. no final acrescentei a extensão .sql.
                File f = new File(jf.getSelectedFile().getAbsolutePath() + ".sql");
                //Cria fisicamente o arquivo no lugar onde o usuário escolheu salvar.
                f.createNewFile();
                //Instanciei o PrintWriter, passando em seu construtor o File onde vou gravar os dados.
                pw = new PrintWriter(f);
                //Instancia do Scanner. No construtor o File do arquivo gerado automaticamente pelo programa.
                sc = new Scanner(file);
                //Nesse While o Scanner vai lendo linha por linha do arquivo .sql gerado automaticamente e, o PrintWriter vai escrevendo linha por linha no arquivo onde o usário escolheu salvar.
                while (sc.hasNextLine()) {
                    String s1 = sc.nextLine();

                    pw.println(s1);
                }
             
                
                JOptionPane.showMessageDialog(null, "Backup gerado com sucesso!", "Backup", JOptionPane.INFORMATION_MESSAGE);

            }



        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar o Backup, contate o suporte");
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        finally {
            if (pw != null) {

                pw.close();
            }
            if (sc != null) {

                sc.close();
            }


        }

    }//GEN-LAST:event_jMenuItemTelaPrincipalBackupActionPerformed

    private void jButtonTelaPrincipalLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTelaPrincipalLogoffActionPerformed
        //tray = true; 
        systemTray.remove(trayIcon);
        dispose();
        new TelaLogin().setVisible(true);
        
    }//GEN-LAST:event_jButtonTelaPrincipalLogoffActionPerformed

    private void menuItemPopupSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPopupSairActionPerformed
        formWindowClosing(null);        
        System.exit(0);
    }//GEN-LAST:event_menuItemPopupSairActionPerformed

    private void menuItemPopupCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPopupCadastrosActionPerformed
        
        
          new TelaCadastros(this).setVisible(true);
        
    }//GEN-LAST:event_menuItemPopupCadastrosActionPerformed

    private void jButtonTelaPrincipalCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTelaPrincipalCaixaActionPerformed
        jDesktopPaneContas.setVisible(true);
        jInternalFrameContas1.setVisible(true);
       
        
        try {
        jInternalFrameContas1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanelImagemTelaPrincipal.setVisible(false);
        jPanelDataHoraTelaPrincipal.setVisible(false);
        jPanelBotoesTelaPrincipal.setVisible(false);
    }//GEN-LAST:event_jButtonTelaPrincipalCaixaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        jDesktopPaneContas.setVisible(false);
        jInternalFrameContas1.setVisible(false);
        jPanelBotoesTelaPrincipal.setVisible(true);
        jPanelImagemTelaPrincipal.setVisible(true);
        jPanelDataHoraTelaPrincipal.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       Properties prop = new Properties();
            
            prop.setProperty("hibernate.connection.username", "");
            prop.setProperty("hibernate.connection.password", "");
            File caminho = new File("properties/hibernate.properties");
            
                FileOutputStream fo;
                try {
                    fo = new FileOutputStream(caminho);
                    prop.store(fo, null);
                    fo.close();
                } catch (IOException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }//GEN-LAST:event_formWindowClosing

    private void jButtonInternalFrameRelatoriosVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInternalFrameRelatoriosVoltar1ActionPerformed
       
        jDesktopPaneContas.setVisible(false);
        jInternalFrameRelatorios.setVisible(false);
        jPanelBotoesTelaPrincipal.setVisible(true);
        jPanelDataHoraTelaPrincipal.setVisible(true);
        jPanelImagemTelaPrincipal.setVisible(true);
        
       
    }//GEN-LAST:event_jButtonInternalFrameRelatoriosVoltar1ActionPerformed

    private void jButtonTaxasRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTaxasRelatorioActionPerformed
         
   
    int  resposta = JOptionPane.showConfirmDialog(null, "Deseja Gerar um Relatório de taxas?");
    if (resposta == JOptionPane.YES_OPTION) {
     
        jButtonTaxasRelatorio.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Espere , a janela se abrirá em breve");
    
        Thread t = new Thread(){
            
           @Override
            public void run() {
                try {
                    Connection conn = HibernateUtil.getConnection();
                   // JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/rc_taxa.jrxml"));

                    JasperPrint jasper = JasperFillManager.fillReport(getClass().getResourceAsStream("/relatorios/rc_taxa.jasper"), null, conn);
                    JasperViewer.viewReport(jasper, false);


                } catch (Exception ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        jButtonTaxasRelatorio.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonTaxasRelatorioActionPerformed

    private void jButtonCategoriaSocioRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriaSocioRelatorioActionPerformed
         
    int resposta = JOptionPane.showConfirmDialog(null, "Deseja Gerar um Relatório de Categorias de Socios?");
    if (resposta == JOptionPane.YES_OPTION) {
     
        JOptionPane.showMessageDialog(null, "Espere Alguns Instantes, a janela se abrirá em breve");
    
        
        new Thread() {
            @Override
            public void run() {
                try {
                    Connection conn = HibernateUtil.getConnection();
                    JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/rc_categoriaSocio.jrxml"));

                    JasperPrint jasper = JasperFillManager.fillReport(report, null, conn);
                    JasperViewer.viewReport(jasper, false);


                } catch (Exception ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        
        }
    }//GEN-LAST:event_jButtonCategoriaSocioRelatorioActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
       TelaRelatoriosCheques c = new TelaRelatoriosCheques(this, true);
       c.setLocationRelativeTo(null);
       c.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButtonEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntradaActionPerformed
       TelaRelatoriosEntradas c = new TelaRelatoriosEntradas(this, true);
       c.setLocationRelativeTo(null);
       c.setVisible(true);
        
       
    }//GEN-LAST:event_jButtonEntradaActionPerformed

    
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       TelaRelatoriosSaidas c = new TelaRelatoriosSaidas(this, true);
       c.setLocationRelativeTo(null);
       c.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       TelaRelatoriosSocios socio = new TelaRelatoriosSocios(this, true);
       socio.setLocationRelativeTo(null);
       socio.setVisible(true);  
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        new GContas(this).setVisible(true);
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        new GContasAReceber(this).setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItemAuditoriaChequesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAuditoriaChequesActionPerformed
        
        PrintWriter pw = null;
        try{
            
            
          
            File caminho = new File("logs/");
            
            if(!caminho.exists()){
                caminho.mkdir();
                
            }
            File arquivo = new File("logs/chequeslog.txt");
         
          
           if(arquivo.exists()){
                arquivo.delete();
               
           }
             arquivo.createNewFile();
            List<Chequeslog> cheques = new DaoChequeslog().BuscarTodosChequesLog();
            pw = new PrintWriter(arquivo);
            for(Chequeslog c : cheques){
                
                pw.print("ID:"+c.getId()+"\tIDOriginal:"+c.getIdOriginal()+"\tdataPagamento:"+c.getDataPagamento()+
                        "\tdataVencimento:"+c.getDataVencimento()+"\tdataAlteração:"+c.getDataAlteracao()+"\tNúmero:"+c.getNumero()+
                        "\tValor:"+c.getValor()+"\tIdFuncionario:"+c.getIdFuncionarioAlteracao()+"\tTipo:"+c.getTipo());
                pw.println();
                pw.println();
                
            }
            
            Desktop.getDesktop().open(arquivo);
            
        }catch(Exception e){
           e.printStackTrace(); 
           JOptionPane.showMessageDialog(this,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE); 
        }finally{
            
            if(pw != null){
                pw.close();
            }
        }
        
    }//GEN-LAST:event_jMenuItemAuditoriaChequesActionPerformed

    private void jMenuItemAuditoriaContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAuditoriaContasActionPerformed
      
         PrintWriter pw = null;
        try{
            
            
          
            File caminho = new File("logs/");
            
            if(!caminho.exists()){
                caminho.mkdir();
                
            }
            File arquivo = new File("logs/contaslog.txt");
         
          
           if(arquivo.exists()){
                arquivo.delete();
               
           }
             arquivo.createNewFile();
            List<Contaslog> contas = new DaoContaslog().ListarTodas();
            pw = new PrintWriter(arquivo);
            for(Contaslog c : contas){
                
                pw.print("ID:"+c.getId()+"\tIDOriginal:"+c.getIdOriginal()+"\tdataPagamento:"+c.getDataPag()+
                        "\tdataVencimento:"+c.getDataVence()+"\tTaxaSócio:"+c.getTaxaSocio()+"\tNúmeroSócio:"+c.getIdNumeroSocio()+
                        "\tHoraRegistro:"+c.getHoraRegristro()+"\tTipo:"+c.getTipo());
                pw.println();
                pw.println();
                
            }
            
            Desktop.getDesktop().open(arquivo);
            
        }catch(Exception e){
           e.printStackTrace(); 
           JOptionPane.showMessageDialog(this,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE); 
        }finally{
            
            if(pw != null){
                pw.close();
            }
        }
    }//GEN-LAST:event_jMenuItemAuditoriaContasActionPerformed

    private void jMenuItemAuditoriaEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAuditoriaEntradasActionPerformed
         PrintWriter pw = null;
        try{
            
            
          
            File caminho = new File("logs/");
            
            if(!caminho.exists()){
                caminho.mkdir();
                
            }
            File arquivo = new File("logs/entradaslog.txt");
         
          
           if(arquivo.exists()){
                arquivo.delete();
               
           }
             arquivo.createNewFile();
            List<Entradaslog> entradas = new DaoEntradaslog().BuscarTodasEntradasLog();
            pw = new PrintWriter(arquivo);
            for(Entradaslog c : entradas){
                
                pw.print("ID:"+c.getId()+"\tIDOriginal:"+c.getIdOriginal()+"\tdataAlteração:"+c.getDataAlteracao()+
                        "\tIdCedente:"+c.getIdCedente()+"\tIdFuncionario:"+c.getIdFuncionario()+"\tMotivoEntrada:"+c.getIdMotivoEntrada()+
                        "\tValor:"+c.getValor()+"\tTipo:"+c.getTipo());
                pw.println();
                pw.println();
                
            }
            
            Desktop.getDesktop().open(arquivo);
            
        }catch(Exception e){
           e.printStackTrace(); 
           JOptionPane.showMessageDialog(this,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE); 
        }finally{
            
            if(pw != null){
                pw.close();
            }
        }
    }//GEN-LAST:event_jMenuItemAuditoriaEntradasActionPerformed

    private void jMenuItemAuditoriaSaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAuditoriaSaidasActionPerformed
        
       
        
        
    }//GEN-LAST:event_jMenuItemAuditoriaSaidasActionPerformed

    private void jMenuItemCriarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCriarUsuariosActionPerformed
        
       CriadorUsuario cu = new CriadorUsuario(this, true);
       cu.setLocationRelativeTo(null);
       cu.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemCriarUsuariosActionPerformed
 
  
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //        try {
        //            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        //                if ("Metal".equals(info.getName())) {
        //                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
        //                    break;
        //                    
        //                }
        //            }
        //        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        //            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //</editor-fold>
        //</editor-fold>
        try {
            Properties p = new Properties();
            p.put("logoString", "ACAL2000");
            com.jtattoo.plaf.aluminium.AluminiumLookAndFeel.setTheme(p);

            javax.swing.UIManager.setLookAndFeel(new com.jtattoo.plaf.aluminium.AluminiumLookAndFeel());
            /* Create and display the form */
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }



        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonCategoriaSocioRelatorio;
    private javax.swing.JButton jButtonEntrada;
    private javax.swing.JButton jButtonFuncionarioRelatorio;
    private javax.swing.JButton jButtonInternalFrameRelatoriosVoltar1;
    private javax.swing.JButton jButtonTaxasRelatorio;
    private javax.swing.JButton jButtonTelaPrincipalCadastros;
    private javax.swing.JButton jButtonTelaPrincipalCaixa;
    private javax.swing.JButton jButtonTelaPrincipalLogoff;
    private javax.swing.JButton jButtonTelaPrincipalRelatorios;
    private javax.swing.JDesktopPane jDesktopPaneContas;
    private javax.swing.JDesktopPane jDesktopPaneRelatorios;
    private javax.swing.JInternalFrame jInternalFrameContas1;
    private javax.swing.JInternalFrame jInternalFrameRelatorios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuAuditoria;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItemAgua;
    private javax.swing.JMenuItem jMenuItemAuditoriaCheques;
    private javax.swing.JMenuItem jMenuItemAuditoriaContas;
    private javax.swing.JMenuItem jMenuItemAuditoriaEntradas;
    private javax.swing.JMenuItem jMenuItemAuditoriaSaidas;
    private javax.swing.JMenuItem jMenuItemCategoria_Socio;
    private javax.swing.JMenuItem jMenuItemContrato;
    private javax.swing.JMenuItem jMenuItemCriarUsuarios;
    private javax.swing.JMenuItem jMenuItemDespesa;
    private javax.swing.JMenuItem jMenuItemFuncionarios;
    private javax.swing.JMenuItem jMenuItemLogradouros;
    private javax.swing.JMenuItem jMenuItemReceita;
    private javax.swing.JMenuItem jMenuItemReceitas;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemSocio;
    private javax.swing.JMenuItem jMenuItemSolicita_Socio;
    private javax.swing.JMenuItem jMenuItemTaxas;
    private javax.swing.JMenuItem jMenuItemTelaPrincipalBackup;
    private javax.swing.JMenuItem jMenuItemTipoDespesa;
    private javax.swing.JMenuItem jMenuItemTipoReceita;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelBotoesTelaPrincipal;
    private javax.swing.JPanel jPanelDataHoraTelaPrincipal;
    private javax.swing.JPanel jPanelImagemTelaPrincipal;
    private javax.swing.JPanel jPanelInternalFrameContas;
    private javax.swing.JPanel jPanelInternalFrameRelatorios;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private java.awt.MenuItem menuItemPopupCadastros;
    private java.awt.MenuItem menuItemPopupSair;
    private java.awt.PopupMenu popupMenu1;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables
}
