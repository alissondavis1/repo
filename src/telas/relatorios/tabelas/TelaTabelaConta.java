
package telas.relatorios.tabelas;

import TableModel.CaixaCompletoTableModel;
import TableModel.CaixaTableModel;
import dao.view.DaoCaixaCompletoView;
import dao.view.DaoCaixaView;
import entidades.view.CaixaView;
import entidades.view.RcCaixaCompleto;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import telas.TelaPrincipal;
import util.HibernateUtil;

public class TelaTabelaConta extends javax.swing.JFrame {

   private CaixaCompletoTableModel pModelTela;
   private CaixaCompletoTableModel pModelBanco;
   
    public TelaTabelaConta() {
        initComponents();
        inicializer();
    }

    private void inicializer()
    {
      jTotalTela.setEnabled(false);
      jTotalBanco.setEnabled(false);
      jAbertasTela.setEnabled(false);
      jAbertasBanco.setEnabled(false);
      jAtrasadasBanco.setEnabled(false);
      jAtrasadasTela.setEnabled(false);
      jDatePagamentoFim.setEnabled(false);
      jDatePagamentoInicio.setEnabled(false);
      jDateVencimentoInicio.setEnabled(false);
      jDateVencimentoFim.setEnabled(false);
      jValorTotalTela.setEnabled(false);
      jValorTotalbanco.setEnabled(false);
      getTableModelBanco();
      getTableModelTela();
      ConfigurarTabela();
    }
    
   public void ConfigurarTabela(){
    jTableBanco.setModel(pModelBanco);
    jTableTela .setModel(pModelTela);
    adicionarEventosTela(jTableTela);
    adicionarEventosBanco(jTableBanco);
   
   }
   
   public void contar()
   {
       jTotalTela.setText (Integer.toString(pModelTela.getRowCount()));
       jTotalBanco.setText(Integer.toString(pModelBanco.getRowCount()));
   
       int TelaAberta=0;
       int TelaQtdAtrasada=0;
       
       BigDecimal bdTela= new BigDecimal(0.00);
       BigDecimal vdTela= new BigDecimal(0.00);
       
       
       for (int i = 0; i < pModelTela.getRowCount(); i++) {
          //total de contas abertas
          if( pModelTela.getLinha(i).getPagamento()==null)
          {
          TelaAberta++;
          }
          //valor total das contas
          bdTela= bdTela.add(BigDecimal.valueOf(pModelTela.getLinha(i).getTotalconta()));
          if((pModelTela.getLinha(i).getPagamento() == null)&&
          (pModelTela.getLinha(i).getVencimento().before(new Date()) ))
          {
          TelaQtdAtrasada++;
          vdTela= vdTela.add(BigDecimal.valueOf(pModelTela.getLinha(i).getTotalconta()));
          }
          
       }
       
       if(bdTela==null){jValorTotalTela.setText(String.valueOf("0.00"));}
       else            {jValorTotalTela.setText(String.valueOf(bdTela));}
       if(vdTela==null){jValorAtrasadasTela.setText(String.valueOf("0.00"));}
       else            {jValorAtrasadasTela.setText(String.valueOf(vdTela));}
       
       jAtrasadasTela.setText(Integer.toString(TelaQtdAtrasada));
       jAbertasTela.setText(Integer.toString(TelaAberta));
       
       int BancoAberta=0;
       int BancoQtdAtrasada=0;
       
       BigDecimal bdBanco = new BigDecimal(0.00);
       BigDecimal VdBanco = new BigDecimal(0.00);
               
       
       for (int i = 0; i < pModelBanco.getRowCount(); i++) {
           
           if(pModelBanco.getLinha(i).getPagamento()==null)
           {
           BancoAberta++;
           }
           bdBanco= bdBanco.add(BigDecimal.valueOf(pModelBanco.getLinha(i).getTotalconta()));
           if((pModelBanco.getLinha(i).getPagamento() == null)&&
           (pModelBanco.getLinha(i).getVencimento().before(new Date()) ))
           {
           BancoQtdAtrasada++;
           VdBanco= VdBanco.add(BigDecimal.valueOf(pModelBanco.getLinha(i).getTotalconta()));
           }
          
       }
       if  (bdBanco==null){jValorTotalbanco.setText("0.00");}
       else               {jValorTotalbanco.setText(String.valueOf(bdBanco));}
       if  (VdBanco==null){jValorAtrasadasBanco.setText("0.00");}
       else               {jValorAtrasadasBanco.setText(String.valueOf(VdBanco));}
       
       
       jAtrasadasBanco.setText(Integer.toString(BancoQtdAtrasada));
       jAbertasBanco.setText(Integer.toString(BancoAberta));
       
   }
   
    private CaixaCompletoTableModel getTableModelBanco()        
    {       
        if (pModelBanco == null) {
            pModelBanco = new CaixaCompletoTableModel();       
        }
        return pModelBanco;
    }    
   
    private CaixaCompletoTableModel getTableModelTela()        
    {       
        if (pModelTela == null) {
            pModelTela = new CaixaCompletoTableModel();       
        }
        return pModelTela;
    }    
    
   
    private void adicionarEventosBanco(final JTable table ) {
    
     table.addMouseListener(new MouseListener() {
     @Override
     public void mouseClicked(MouseEvent e) 
     { 
         boolean flag=true;
          if (e.getClickCount() == 2) 
          {
              for (int i = 0; i < pModelTela.getRowCount(); i++) {
                if( pModelTela.getLinha(i).getNumeroconta() ==
                    pModelBanco.getLinha(jTableBanco.getSelectedRow()).getNumeroconta())
                {
                 flag=false;
                JOptionPane.showMessageDialog(null,"Essa linha já foi adcionda");
                }
              }
              if(flag==true){
              pModelTela.addLinha(pModelBanco.getLinha(jTableBanco.getSelectedRow()));
              pModelBanco.removeLinha(jTableBanco.getSelectedRow());
              }
           contar();
          }
     }
     @Override
     public void mousePressed(MouseEvent e) {}
     @Override
     public void mouseReleased(MouseEvent e){}
     @Override
     public void mouseEntered(MouseEvent e) {}
     @Override
     public void mouseExited(MouseEvent e)  {}
     
     
     });
    }
    
    private void adicionarEventosTela(final JTable table ) {
    
     table.addMouseListener(new MouseListener() {
     @Override
     public void mouseClicked(MouseEvent e) 
     { 
        if (e.getClickCount() == 2) 
        {  
        pModelTela.removeLinha(jTableTela.getSelectedRow());
        contar();
        }
     }
     @Override
     public void mousePressed(MouseEvent e) {}
     @Override
     public void mouseReleased(MouseEvent e){}
     @Override
     public void mouseEntered(MouseEvent e) {}
     @Override
     public void mouseExited(MouseEvent e)  {}
     
     
     });
    }         
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTotalTela = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jAbertasTela = new javax.swing.JTextField();
        jAtrasadasTela = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jValorTotalTela = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jValorAtrasadasTela = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jDatePagamentoFim = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDatePagamentoInicio = new com.toedter.calendar.JDateChooser();
        jCheckBoxPagamento = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jDateVencimentoInicio = new com.toedter.calendar.JDateChooser();
        jDateVencimentoFim = new com.toedter.calendar.JDateChooser();
        jCheckVencimento = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        jButtonExportar = new javax.swing.JButton();
        jButtonExportar1 = new javax.swing.JButton();
        jButtonExportar2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTotalBanco = new javax.swing.JTextField();
        jAbertasBanco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jAtrasadasBanco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jValorTotalbanco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jValorAtrasadasBanco = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBanco = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableTela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTela);

        jLabel1.setText("Contas Prontas para a Impressão");

        jLabel5.setText("Numero de Contas");

        jLabel7.setText("Abertas");

        jLabel9.setText("Atrasadas");

        jLabel10.setText("Valor Total");

        jLabel15.setText("Valor Atrasadas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(3, 3, 3)
                .addComponent(jAtrasadasTela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel15)
                .addGap(3, 3, 3)
                .addComponent(jValorAtrasadasTela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addComponent(jAbertasTela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(jTotalTela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel10)
                .addGap(3, 3, 3)
                .addComponent(jValorTotalTela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jAbertasTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jValorTotalTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTotalTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAtrasadasTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jValorAtrasadasTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)))))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jLabel4.setText("Final");

        jLabel3.setText("Inicio");

        jCheckBoxPagamento.setText("Pagamento");
        jCheckBoxPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxPagamento)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDatePagamentoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDatePagamentoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jCheckBoxPagamento)
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDatePagamentoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDatePagamentoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10))
        );

        jCheckVencimento.setText("Vecimento");
        jCheckVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckVencimentoActionPerformed(evt);
            }
        });

        jLabel13.setText("Inicio");

        jLabel14.setText("Final");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckVencimento)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateVencimentoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateVencimentoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jCheckVencimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jDateVencimentoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateVencimentoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonExportar.setText("Exportar");
        jButtonExportar.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarActionPerformed(evt);
            }
        });

        jButtonExportar1.setText("Limpar Tela");
        jButtonExportar1.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonExportar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportar1ActionPerformed(evt);
            }
        });

        jButtonExportar2.setText("Limpar Banco");
        jButtonExportar2.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonExportar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonExportar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExportar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExportar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExportar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setText("Contas No banco de dados");

        jLabel6.setText(" Numero de Contas");

        jLabel8.setText("Abertas");

        jLabel12.setText("Atrasadas");

        jLabel11.setText("Valor Total");

        jLabel16.setText("Valor Atrasadas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(3, 3, 3)
                .addComponent(jAtrasadasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel16)
                .addGap(3, 3, 3)
                .addComponent(jValorAtrasadasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addComponent(jAbertasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addComponent(jTotalBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel11)
                .addGap(3, 3, 3)
                .addComponent(jValorTotalbanco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jValorTotalbanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6)
                        .addComponent(jTotalBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jAbertasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAtrasadasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jValorAtrasadasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)))))
                .addGap(5, 5, 5))
        );

        jTableBanco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableBanco);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
       
        pModelBanco.limpar();
        
        if(jCheckBoxPagamento.isSelected()){
     
            if(jDatePagamentoInicio.getDate()==null){
            JOptionPane.showMessageDialog(null, "É preciso escolher o Pagamento inicial");
            }
            else if(jDatePagamentoFim.getDate()==null){
            JOptionPane.showMessageDialog(null, "É preciso escolher o Pagamento Final");
            }
            else if(jDatePagamentoFim.getDate().before(jDatePagamentoInicio.getDate()) ){
            JOptionPane.showMessageDialog(null, "A data Final não pode ser Inferior a data Inicial");
            jDatePagamentoInicio.setDate(null);
            jDatePagamentoFim.setDate(null);
            }
            else {
            SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat f2 = new SimpleDateFormat("dd/MM/yyyy");
           
            
           pModelBanco.addListaDeCaixa(new DaoCaixaCompletoView()
           .BuscarTodosRcCaixaCompletoDatePagamento(jDatePagamentoInicio.getDate(),jDatePagamentoFim.getDate()));
            }
        }
        
        else if(jCheckVencimento.isSelected()){
        
            if(jDateVencimentoInicio.getDate()==null){
            JOptionPane.showMessageDialog(null, "É preciso escolher o Vencimento inicial");
            }
            else if(jDateVencimentoFim.getDate()==null){
            JOptionPane.showMessageDialog(null, "É preciso escolher o Vencimento Final");
            }
            else if(jDateVencimentoFim.getDate().before(jDateVencimentoInicio.getDate()) ){
            JOptionPane.showMessageDialog(null, "A data Final não pode ser Inferior a data Inicial");
            jDateVencimentoInicio.setDate(null);
            jDateVencimentoFim.setDate(null);
            }
            else {
            SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat f2 = new SimpleDateFormat("dd/MM/yyyy");
            
            pModelBanco.addListaDeCaixa(new DaoCaixaCompletoView()
            .BuscarTodosRcCaixaCompletoDateVencimento(jDateVencimentoInicio.getDate(),jDateVencimentoFim.getDate()));
            }
        }
        contar();
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    
    private void jButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarActionPerformed
                 
      Thread t =  new Thread ()  
      {
        @Override
        @SuppressWarnings("empty-statement")
        public void run() {
        
        String sql=" Where ";
        if(pModelTela.getRowCount()<1)
        {
         JOptionPane.showMessageDialog(null,"É preciso Haver pelo menos um Elemento para ser Exportado");
        }
        else if(pModelTela.getRowCount()==1)
        {
         sql+= " c.id = " + pModelTela.getLinha(0).getNumeroconta();
        }
        else
        {
         for (int i = 0; i < pModelTela.getRowCount(); i++) {
          if(i==0){sql+= "\n c.id = " + pModelTela.getLinha(i).getNumeroconta();}
          else    {sql+= "\n or c.id = " + pModelTela.getLinha(i).getNumeroconta();}
         }
        }
        sql+= "\n group by c.id ";
        System.out.println(sql);       
    
        try 
        {
         Connection conn = HibernateUtil.getConnection();
         Map<String, Object> p = new HashMap<>();
         
         p.put("complementos",sql);
         JasperPrint jasper = JasperFillManager.fillReport(getClass().getResourceAsStream("/relatorios/rc_novaConta.jasper"), p, conn);
         JasperViewer.viewReport(jasper, false);
        }
        catch (Exception ex) 
        {
         Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }    
            
        }
      };
      t.start();
        
    }//GEN-LAST:event_jButtonExportarActionPerformed

    private void jButtonExportar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportar1ActionPerformed
        pModelTela.limpar();
        contar();
    }//GEN-LAST:event_jButtonExportar1ActionPerformed

    private void jButtonExportar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportar2ActionPerformed
      pModelBanco.limpar();
      contar();
    }//GEN-LAST:event_jButtonExportar2ActionPerformed

    private void jCheckBoxPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPagamentoActionPerformed
        if(jCheckBoxPagamento.isSelected())
        {
        jCheckVencimento.setSelected(false);
        jDateVencimentoInicio.setDate(null);
        jDateVencimentoFim.setDate(null);
        jDatePagamentoFim.setEnabled(true);
        jDatePagamentoInicio.setEnabled(true);
        }
        else
        {
        jDatePagamentoFim.setEnabled(false);
        jDatePagamentoInicio.setEnabled(false);
        
        }
    }//GEN-LAST:event_jCheckBoxPagamentoActionPerformed

    private void jCheckVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckVencimentoActionPerformed
        if(jCheckVencimento.isSelected())
        {
        jCheckBoxPagamento.setSelected(false);
        jDatePagamentoInicio.setDate(null);
        jDatePagamentoFim.setDate(null);
        jDateVencimentoInicio.setEnabled(true);
        jDateVencimentoFim.setEnabled(true);
        }
        else
        {
        jDateVencimentoInicio.setEnabled(false);
        jDateVencimentoFim.setEnabled(false);    
        }
    }//GEN-LAST:event_jCheckVencimentoActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaTabelaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTabelaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTabelaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTabelaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaTabelaConta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAbertasBanco;
    private javax.swing.JTextField jAbertasTela;
    private javax.swing.JTextField jAtrasadasBanco;
    private javax.swing.JTextField jAtrasadasTela;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonExportar;
    private javax.swing.JButton jButtonExportar1;
    private javax.swing.JButton jButtonExportar2;
    private javax.swing.JCheckBox jCheckBoxPagamento;
    private javax.swing.JCheckBox jCheckVencimento;
    private com.toedter.calendar.JDateChooser jDatePagamentoFim;
    private com.toedter.calendar.JDateChooser jDatePagamentoInicio;
    private com.toedter.calendar.JDateChooser jDateVencimentoFim;
    private com.toedter.calendar.JDateChooser jDateVencimentoInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBanco;
    private javax.swing.JTable jTableTela;
    private javax.swing.JTextField jTotalBanco;
    private javax.swing.JTextField jTotalTela;
    private javax.swing.JTextField jValorAtrasadasBanco;
    private javax.swing.JTextField jValorAtrasadasTela;
    private javax.swing.JTextField jValorTotalTela;
    private javax.swing.JTextField jValorTotalbanco;
    // End of variables declaration//GEN-END:variables
}
