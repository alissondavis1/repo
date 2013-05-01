/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import util.HibernateUtil;

/**
 *
 * @author Alexandre 
 * @author Alisson 
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private Calendar c;
    SimpleDateFormat sdf = new SimpleDateFormat();
    private final TrayIcon trayIcon;

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
        jDesktopPane1.setVisible(false);
        jInternalFrame1.setVisible(false);


        // A data do sistema.

        jLabel1.setText(df.format(c.getTime()));


        //  Start do TimerBean para atualizar a hora no sistema

        timer1.start();

        // redimensionamento e posicionamento da tela principal, para que fique alinhada na parte de cima do monitor.

        //Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setBounds(0, 0, d.width, d.height);


        SystemTray systemTray = SystemTray.getSystemTray();
        
        trayIcon = new TrayIcon(new ImageIcon(getClass().getResource("/img/ico.png")).getImage(), "Acal2000", popupMenu1);
        trayIcon.setImageAutoSize(true);
       
       try{
           systemTray.add(trayIcon);
       }catch(AWTException e){
        
        e.printStackTrace();
        
    }
//        Properties prop = new Properties();
//        try {
//            prop.load(new FileInputStream("configs/LAF.properties"));
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException e) {
//
//            JOptionPane.showMessageDialog(null, "Erro de IO");
//
//        }
//        String laf = prop.getProperty("LAF");
//        prop.put("logoString", "Acal2000");
//        switch (laf) {
//
//            case "luna":
//                com.jtattoo.plaf.luna.LunaLookAndFeel.setTheme(prop);
//                setLookAndFeel(new com.jtattoo.plaf.luna.LunaLookAndFeel());
//                break;
//           
//            case "aluminium":
//                com.jtattoo.plaf.aluminium.AluminiumLookAndFeel.setTheme(prop);
//                setLookAndFeel(new com.jtattoo.plaf.aluminium.AluminiumLookAndFeel());
//                break;
//            case "aero":
//                com.jtattoo.plaf.aero.AeroLookAndFeel.setTheme(prop);
//                setLookAndFeel(new com.jtattoo.plaf.aero.AeroLookAndFeel());
//                break;
//            default:
//                setLookAndFeel(new com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel());
//
//        }
//
//
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
        jPanel1 = new javax.swing.JPanel();
        jButtonTelaPrincipalLogoff = new javax.swing.JButton();
        jButtonTelaPrincipalRelatorios = new javax.swing.JButton();
        jButtonTelaPrincipalCaixa = new javax.swing.JButton();
        jButtonTelaPrincipalCadastros = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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
        jMenuItemCaixa = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItemTelaPrincipalBackup = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();
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

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButtonTelaPrincipalLogoff.setIcon(new ImageIcon(getClass().getResource("/img/logoff.jpg")));
        jButtonTelaPrincipalLogoff.setText("Opções de Logoff");
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
        jPanel1.add(jButtonTelaPrincipalLogoff, gridBagConstraints);

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
        jPanel1.add(jButtonTelaPrincipalRelatorios, gridBagConstraints);

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
        jPanel1.add(jButtonTelaPrincipalCaixa, gridBagConstraints);

        jButtonTelaPrincipalCadastros.setIcon(new ImageIcon(getClass().getResource("/img/cadastros.png")));
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
        jPanel1.add(jButtonTelaPrincipalCadastros, gridBagConstraints);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 5, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 663;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 5, 10);
        jPanel1.add(jLabel2, gridBagConstraints);

        jInternalFrame1.setFrameIcon(null);
        jInternalFrame1.setVisible(true);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Contas a Receber");

        jButton2.setText("Contas a Pagar");

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");

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
        jPanel2.add(jPanel3, gridBagConstraints);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        jInternalFrame1.setBounds(0, 0, 920, 550);
        jDesktopPane1.add(jInternalFrame1, javax.swing.JLayeredPane.PALETTE_LAYER);

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

        jMenuItemCaixa.setText("Caixa");
        jMenu.add(jMenuItemCaixa);

        jMenuItem8.setText("Gerador de contas");
        jMenu.add(jMenuItem8);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 409, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
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
        new Thread() {
            @Override
            public void run() {
                try {
                    Connection conn = HibernateUtil.getConnection();
                    Map<String, Object> paramets = new HashMap<>();
                    JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/relatorios.jrxml"));

                    JasperPrint jasper = JasperFillManager.fillReport(report, paramets, conn);
                    JasperViewer.viewReport(jasper, false);


                } catch (Exception ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();

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
        new TelaLogout().setVisible(true);
    }//GEN-LAST:event_jButtonTelaPrincipalLogoffActionPerformed

    private void menuItemPopupSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPopupSairActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_menuItemPopupSairActionPerformed

    private void menuItemPopupCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPopupCadastrosActionPerformed
        
          new TelaCadastros(this).setVisible(true);
    }//GEN-LAST:event_menuItemPopupCadastrosActionPerformed

    private void jButtonTelaPrincipalCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTelaPrincipalCaixaActionPerformed
        jDesktopPane1.setVisible(true);
        jInternalFrame1.setVisible(true);
       
        try {
            jInternalFrame1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanel1.setVisible(false);
    }//GEN-LAST:event_jButtonTelaPrincipalCaixaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        jDesktopPane1.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme(p);

            javax.swing.UIManager.setLookAndFeel(new com.jtattoo.plaf.mcwin.McWinLookAndFeel());
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
    private javax.swing.JButton jButtonTelaPrincipalCadastros;
    private javax.swing.JButton jButtonTelaPrincipalCaixa;
    private javax.swing.JButton jButtonTelaPrincipalLogoff;
    private javax.swing.JButton jButtonTelaPrincipalRelatorios;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItemAgua;
    private javax.swing.JMenuItem jMenuItemCaixa;
    private javax.swing.JMenuItem jMenuItemCategoria_Socio;
    private javax.swing.JMenuItem jMenuItemContrato;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private java.awt.MenuItem menuItemPopupCadastros;
    private java.awt.MenuItem menuItemPopupSair;
    private java.awt.PopupMenu popupMenu1;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables
}
