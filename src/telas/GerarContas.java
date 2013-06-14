/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.DaoContasMensais;
import dao.DaoEnderecoPessoa;
import entidades.Conta;
import entidades.Enderecopessoa;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author aliss_000
 */
public class GerarContas extends javax.swing.JDialog {

    /**
     * Creates new form GerarContas
     */
    private List<Enderecopessoa> socios = new DaoEnderecoPessoa().TodosOsSocios();

    public GerarContas(Frame parent, boolean modal) {
        super(parent, modal);

        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        initComponents();
        jDateChooser1.setEnabled(false);
        jDateChooser2.setEnabled(false);
    }

    private void preencherTabela() {


        if (jRadioButtonContaFixa.isSelected()) {
            DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
            centralizar.setHorizontalAlignment(SwingConstants.CENTER);

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},
                    new String[]{"id", "dataVencimento", "Sócio", "Numero Socio", "CPF", "Numero Endereço", "Valor", "Gerar", "Taxa"}) {
                Class[] types = new Class[]{Integer.class, String.class, String.class, Integer.class, String.class, Integer.class,
                    BigDecimal.class, Boolean.class, JButton.class};

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
                boolean[] canEdit = new boolean[]{false, false, false, false, false, false, true, true, true};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {

                    return canEdit[columnIndex];
                }
            });

            jTable1.getColumn("id").setCellRenderer(centralizar);
            jTable1.getColumn("dataVencimento").setCellRenderer(centralizar);
            jTable1.getColumn("Sócio").setCellRenderer(centralizar);
            jTable1.getColumn("Numero Socio").setCellRenderer(centralizar);
            jTable1.getColumn("CPF").setCellRenderer(centralizar);
            jTable1.getColumn("Numero Endereço").setCellRenderer(centralizar);
            jTable1.getColumn("Valor").setCellRenderer(centralizar);


        } else if (jRadioButtonContaHidrometro.isSelected()) {

            DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
            centralizar.setHorizontalAlignment(SwingConstants.CENTER);

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},
                    new String[]{"id", "dataVencimento", "Sócio", "Numero Socio", "CPF", "Numero Endereço", "Valor", "Gerar", "Taxa", "Consumo"}) {
                Class[] types = new Class[]{Integer.class, String.class, String.class, Integer.class, String.class, Integer.class,
                    BigDecimal.class, Boolean.class, JButton.class, Double.class};

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
                boolean[] canEdit = new boolean[]{false, false, false, false, false, false, true, true, true, true};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {

                    return canEdit[columnIndex];
                }
            });

            jTable1.getColumn("id").setCellRenderer(centralizar);
            jTable1.getColumn("dataVencimento").setCellRenderer(centralizar);
            jTable1.getColumn("Sócio").setCellRenderer(centralizar);
            jTable1.getColumn("Numero Socio").setCellRenderer(centralizar);
            jTable1.getColumn("CPF").setCellRenderer(centralizar);
            jTable1.getColumn("Numero Endereço").setCellRenderer(centralizar);
            jTable1.getColumn("Valor").setCellRenderer(centralizar);
            jTable1.getColumn("Consumo").setCellRenderer(centralizar);


        }



        ButtonColumn botao = new ButtonColumn(jTable1, 8);

        preencherColunas();

    }

    private void preencherColunas() {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, jMonthChooser1.getMonth());
        c.add(Calendar.DAY_OF_MONTH, 5);
        if (jRadioButtonContaFixa.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            //  List<Enderecopessoa> socios = new DaoEnderecoPessoa().TodosOsSocios();

            if (!socios.isEmpty()) {


                for (Enderecopessoa s : socios) {
                    List<Conta> contas = (List) s.getContaCollection();
                    if (contas.isEmpty()) {
                        if (!s.getIdPessoa().getSocio().getIdCategoriaSocio().getNome().equals("hidrometro")) {
                            model.addRow(new Object[]{s.getIdPessoa().getSocio().getId(), SimpleDateFormat.getDateInstance().format(c.getTime()), s.getIdPessoa().getNome() + " " + s.getIdPessoa().getSobrenome(), s.getIdPessoa().getSocio().getNumeroSocio(), s.getIdPessoa().getCpf(), s.getNumero(), s.getIdPessoa().getSocio().getIdCategoriaSocio().getTaxasId().getValor(), false});
                        }
                    } else {
                        boolean existeContaNoMes = false;
                        for (Conta conta : contas) {

                            Calendar c1 = Calendar.getInstance();
                            c1.setTime(conta.getDataVence());
                            if (c1.get(Calendar.MONTH) == jMonthChooser1.getMonth() && c1.get(Calendar.YEAR) == jYearChooser1.getYear()) {

                                existeContaNoMes = true;

                            }

                        }

                        if (!existeContaNoMes) {

                            if (!s.getIdPessoa().getSocio().getIdCategoriaSocio().getNome().equals("hidrometro")) {
                                model.addRow(new Object[]{s.getIdPessoa().getSocio().getId(), SimpleDateFormat.getDateInstance().format(c.getTime()), s.getIdPessoa().getNome() + " " + s.getIdPessoa().getSobrenome(), s.getIdPessoa().getSocio().getNumeroSocio(), s.getIdPessoa().getCpf(), s.getNumero(), s.getIdPessoa().getSocio().getIdCategoriaSocio().getTaxasId().getValor(), false});
                            }
                        }
                    }

                }

            }


        } else if (jRadioButtonContaHidrometro.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();



            model.setRowCount(0);
            // List<Enderecopessoa> socios = new DaoEnderecoPessoa().TodosOsSocios();


            if (!socios.isEmpty()) {

                for (Enderecopessoa s : socios) {
                    List<Conta> contas = (List) s.getContaCollection();
                    if (contas.isEmpty()) {
                        if (s.getIdPessoa().getSocio().getIdCategoriaSocio().getNome().equals("hidrometro")) {

                            model.addRow(new Object[]{s.getIdPessoa().getSocio().getId(), SimpleDateFormat.getDateInstance().format(c.getTime()), s.getIdPessoa().getNome() + " " + s.getIdPessoa().getSobrenome(), s.getIdPessoa().getSocio().getNumeroSocio(), s.getIdPessoa().getCpf(), s.getNumero(), s.getIdPessoa().getSocio().getIdCategoriaSocio().getTaxasId().getValor(), false});
                        }
                    } else {
                        boolean existeContaNoMes = false;
                        for (Conta conta : contas) {

                            Calendar c1 = Calendar.getInstance();
                            c1.setTime(conta.getDataVence());
                            if (c1.get(Calendar.MONTH) == jMonthChooser1.getMonth() && c1.get(Calendar.YEAR) == jYearChooser1.getYear()) {

                                existeContaNoMes = true;

                            }

                        }

                        if (!existeContaNoMes) {

                            if (s.getIdPessoa().getSocio().getIdCategoriaSocio().getNome().equals("hidrometro")) {
                                model.addRow(new Object[]{s.getIdPessoa().getSocio().getId(), SimpleDateFormat.getDateInstance().format(c.getTime()), s.getIdPessoa().getNome() + " " + s.getIdPessoa().getSobrenome(), s.getIdPessoa().getSocio().getNumeroSocio(), s.getIdPessoa().getCpf(), s.getNumero(), s.getIdPessoa().getSocio().getIdCategoriaSocio().getTaxasId().getValor(), false});
                            }
                        }


                    }
                }
            }



        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonContaFixa = new javax.swing.JRadioButton();
        jRadioButtonContaHidrometro = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxFiltrar = new javax.swing.JCheckBox();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(51, 255, 255));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        buttonGroup1.add(jRadioButtonContaFixa);
        jRadioButtonContaFixa.setText("Conta Fixa");
        jRadioButtonContaFixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonContaFixaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonContaHidrometro);
        jRadioButtonContaHidrometro.setText("Conta com Hidrômetro");
        jRadioButtonContaHidrometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonContaHidrometroActionPerformed(evt);
            }
        });

        jButton1.setText("Gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Vencimento entre:");

        jLabel2.setText("e");

        jCheckBoxFiltrar.setText("Filtrar");
        jCheckBoxFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFiltrarActionPerformed(evt);
            }
        });

        jMonthChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMonthChooser1PropertyChange(evt);
            }
        });

        jYearChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jYearChooser1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButtonContaHidrometro)
                        .addGap(33, 33, 33)
                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButtonContaFixa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(73, 73, 73)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxFiltrar))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonContaFixa)
                            .addComponent(jButton1)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonContaHidrometro)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxFiltrar))))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonContaFixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonContaFixaActionPerformed

        preencherTabela();

    }//GEN-LAST:event_jRadioButtonContaFixaActionPerformed

    private void jRadioButtonContaHidrometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonContaHidrometroActionPerformed
        preencherTabela();
    }//GEN-LAST:event_jRadioButtonContaHidrometroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, SimpleDateFormat.getDateInstance().format(jDateChooser1.getDate()), "data", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBoxFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFiltrarActionPerformed
        if (jCheckBoxFiltrar.isEnabled()) {
            jDateChooser1.setEnabled(true);
            jDateChooser2.setEnabled(true);
        } else {
            jDateChooser1.setEnabled(false);
            jDateChooser2.setEnabled(false);

        }
    }//GEN-LAST:event_jCheckBoxFiltrarActionPerformed

    private void jMonthChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMonthChooser1PropertyChange
       
       if(jRadioButtonContaFixa.isSelected()){
           
           jRadioButtonContaFixaActionPerformed(null);
       }else if(jRadioButtonContaHidrometro.isSelected()){
           
           jRadioButtonContaHidrometroActionPerformed(null);
       }
    }//GEN-LAST:event_jMonthChooser1PropertyChange

    private void jYearChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jYearChooser1PropertyChange
       if(jRadioButtonContaFixa.isSelected()){
           
           jRadioButtonContaFixaActionPerformed(null);
       }else if(jRadioButtonContaHidrometro.isSelected()){
           
           jRadioButtonContaHidrometroActionPerformed(null);
       }
    }//GEN-LAST:event_jYearChooser1PropertyChange

    private class ButtonColumn extends AbstractCellEditor
            implements TableCellRenderer, TableCellEditor, ActionListener {

        JTable table;
        JButton renderButton;
        JButton editButton;
        String text;

        public ButtonColumn(JTable table, int column) {
            super();
            this.table = table;
            renderButton = new JButton();

            editButton = new JButton();
            editButton.setFocusPainted(false);
            editButton.addActionListener(this);

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer(this);
            columnModel.getColumn(column).setCellEditor(this);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (hasFocus) {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            } else if (isSelected) {
                renderButton.setForeground(table.getSelectionForeground());
                renderButton.setBackground(table.getSelectionBackground());
            } else {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            }

            renderButton.setText((value == null) ? "Adicionar" : value.toString());
            return renderButton;
        }

        @Override
        public Component getTableCellEditorComponent(
                JTable table, Object value, boolean isSelected, int row, int column) {
            text = (value == null) ? "Adicionar" : value.toString();
            editButton.setText(text);
            return editButton;
        }

        @Override
        public Object getCellEditorValue() {
            return text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
            System.out.println(e.getActionCommand() + " : " + table.getSelectedRow());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(GerarContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerarContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerarContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerarContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GerarContas dialog = new GerarContas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxFiltrar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonContaFixa;
    private javax.swing.JRadioButton jRadioButtonContaHidrometro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}
