/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import util.HibernateUtil;

/**
 *
 * @author alexandre
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private Calendar c;
    SimpleDateFormat sdf = new SimpleDateFormat();

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        // setLocationRelativeTo(null);

        initComponents();
        c = Calendar.getInstance(new Locale("pt", "BR"));
        DateFormat df = SimpleDateFormat.getDateInstance(SimpleDateFormat.DATE_FIELD, new Locale("pt", "BR"));


        jLabel1.setText(df.format(c.getTime()));

        timer1.start();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        setBounds(0, 0, d.width, d.height / 3);


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
        jPanel1 = new javax.swing.JPanel();
        jButtonTelaPrincipalLogoff = new javax.swing.JButton();
        jButtonTelaPrincipalRelatorios = new javax.swing.JButton();
        jButtonTelaPrincipalCaixa = new javax.swing.JButton();
        jButtonTelaPrincipalCadastros = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
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
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
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
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 3, 0, 0);
        jPanel1.add(jButtonTelaPrincipalCadastros, gridBagConstraints);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BELOW_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 5, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 663;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 5, 10);
        jPanel1.add(jLabel2, gridBagConstraints);
        jPanel1.add(jProgressBar1, new java.awt.GridBagConstraints());

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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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

    private void jButtonTelaPrincipalCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTelaPrincipalCaixaActionPerformed

        Cedente cedente = new Cedente("PROJETO JRimiun", "03.247.900/0001-26");

        Sacado sacado = new Sacado("JavaDeveloper Pronto Para Férias", "222.222.222-22");
        Endereco enderecoSac = new Endereco();
        enderecoSac.setUF(UnidadeFederativa.RN);
        enderecoSac.setLocalidade("Natal");
        enderecoSac.setCep(new CEP("59064-120"));
        enderecoSac.setBairro("Grande Centro");
        enderecoSac.setLogradouro("Rua poeta dos programas");
        enderecoSac.setNumero("1");
        sacado.addEndereco(enderecoSac);

        ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_BRADESCO.create());
        contaBancaria.setNumeroDaConta(new NumeroDaConta(123456, "0"));
        contaBancaria.setCarteira(new Carteira(30));
        contaBancaria.setAgencia(new Agencia(1234, "1"));

        Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
        titulo.setNumeroDoDocumento("123456");
        titulo.setNossoNumero("99345678912");
        titulo.setDigitoDoNossoNumero("5");
        titulo.setValor(BigDecimal.valueOf(0.23));
        titulo.setDataDoDocumento(new Date());
        titulo.setDataDoVencimento(new Date());
        titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
        // titulo.setAceite(Aceite.A);
        titulo.setDesconto(new BigDecimal(0.05));
        titulo.setDeducao(BigDecimal.ZERO);
        titulo.setMora(BigDecimal.ZERO);
        titulo.setAcrecimo(BigDecimal.ZERO);
        titulo.setValorCobrado(BigDecimal.ZERO);

        Boleto boleto = new Boleto(titulo);

        boleto.setLocalPagamento("Pagável preferencialmente na Rede X ou em "
                + "qualquer Banco até o Vencimento.");
        boleto.setInstrucaoAoSacado("Senhor sacado, sabemos sim que o valor "
                + "cobrado não é o esperado, aproveite o DESCONTÃO!");
        boleto.setInstrucao1("PARA PAGAMENTO 1 até Hoje não cobrar nada!");
        boleto.setInstrucao2("PARA PAGAMENTO 2 até Amanhã Não cobre!");
        boleto.setInstrucao3("PARA PAGAMENTO 3 até Depois de amanhã, OK, não cobre.");
        boleto.setInstrucao4("PARA PAGAMENTO 4 até 04/xx/xxxx de 4 dias atrás COBRAR O VALOR DE: R$ 01,00");
        boleto.setInstrucao5("PARA PAGAMENTO 5 até 05/xx/xxxx COBRAR O VALOR DE: R$ 02,00");
        boleto.setInstrucao6("PARA PAGAMENTO 6 até 06/xx/xxxx COBRAR O VALOR DE: R$ 03,00");
        boleto.setInstrucao7("PARA PAGAMENTO 7 até xx/xx/xxxx COBRAR O VALOR QUE VOCÊ QUISER!");
        boleto.setInstrucao8("APÓS o Vencimento, Pagável Somente na Rede X.");

        BoletoViewer boletoViewer = new BoletoViewer(boleto);

        File arquivoPdf = boletoViewer.getPdfAsFile("MeuPrimeiroBoleto.pdf");

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(arquivoPdf);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonTelaPrincipalCaixaActionPerformed

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

        PrintWriter pw = null;
        Scanner sc = null;
        try {

            String comando = "cmd /c mysqldump -uroot -p123 acal >" + getClass().getResource("/Sql/").getPath().substring(1) + "acal.sql";

            Process p = Runtime.getRuntime().exec(comando);
            try {
                if(p.waitFor() == 0){
                    
                    System.out.println("mysqldump executado");
                    
                }else{
                    System.out.println("erro no mysqldump");
                }
            } catch (InterruptedException ex) {
                
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }


            File file = new File(getClass().getResource("/Sql/acal.sql").getPath());
            JFileChooser jf = new JFileChooser();




            int result = jf.showSaveDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {


                File f = new File(jf.getSelectedFile().getAbsolutePath() + ".sql");
                f.createNewFile();
                pw = new PrintWriter(f);
                sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String s = sc.nextLine();

                    pw.println(s);
                }


            }



        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar o Backup, contate o suporte");
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JButton jButtonTelaPrincipalCadastros;
    private javax.swing.JButton jButtonTelaPrincipalCaixa;
    private javax.swing.JButton jButtonTelaPrincipalLogoff;
    private javax.swing.JButton jButtonTelaPrincipalRelatorios;
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables
}
