/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lixo;

import dao.DaoContasMensais;
import dao.DaoEnderecoPessoa;
import entidades.Conta;
import entidades.Enderecopessoa;
import entidades.Taxa;
import entidades.Taxasconta;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import telas.Taxas;

/**
 *
 * @author aliss_000
 */
public class GerarContas extends javax.swing.JDialog {

    /**
     * Creates new form GerarContas
     */
    private List<Enderecopessoa> socios;
    private Map<Integer,List<Taxa>> taxas;
    public GerarContas(Frame parent, boolean modal) {
        super(parent, modal);
        taxas = new HashMap<>();
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        initComponents();
       carregarSocios();
    }

    private void carregarSocios(){
        
        this.socios = new DaoEnderecoPessoa().TodosOsSocios();
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
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jProgressBar1 = new javax.swing.JProgressBar();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
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

        jProgressBar1.setBackground(new java.awt.Color(0, 255, 255));
        jProgressBar1.setStringPainted(true);

        jCheckBox1.setText("Incluir contas registradas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonContaFixa)
                    .addComponent(jRadioButtonContaHidrometro))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonContaFixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonContaHidrometro)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

      int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja registrar as contas desses sócios?","Atenção",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
      
         
      if(op == JOptionPane.YES_OPTION){
      Thread t = new Thread(){
       public void run(){    
           DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
           Conta c = null;
           jButton1.setEnabled(false);
           jRadioButtonContaFixa.setEnabled(false);
           jRadioButtonContaHidrometro.setEnabled(false);
           
           
    
       
        if(jRadioButtonContaFixa.isSelected() || jRadioButtonContaHidrometro.isSelected()){
            
       
            try{
           
                int cont = 0;
                //percorre todas as linhas
                 for(int i=0;i<model.getRowCount();i++){
              
              if((boolean)model.getValueAt(i, 7)){
                  
                  cont++;
              }
                 }
           
                 jProgressBar1.setMaximum(cont-1);
            //percorre todas as linhas     
            for(int i=0;i<model.getRowCount();i++){
           //se o checkbox estiver marcado executa o if.
           if((boolean)model.getValueAt(i, 7)){
                
             jProgressBar1.setValue(i);
              
                  
              //se tiver selecionado as contas fixas...
              if(jRadioButtonContaFixa.isSelected()){
                //Cria uma conta vazia.
                c = new Conta();
                //seta a data Gerada como a data atual.
                c.setDataGerada(new Date());
                //data de vencimento da tabela   
                c.setDataVence(SimpleDateFormat.getDateInstance().parse((String)model.getValueAt(i, 1)));
                //Pega do banco um endereçoPessoa de acordo com o número do endereço na tabela, que é único    
                Enderecopessoa e = new DaoEnderecoPessoa().EnderecopessoaporNumero((int)model.getValueAt(i, 5));
                //seta o enderecoPessoa na conta
                c.setIdEnderecoPessoa(e);
                
                List<Taxasconta>  taxas = new ArrayList<>();
                
                Taxasconta tx = new Taxasconta();
                tx.setContaid(c);
                //seta a taxa em taxas Conta de acordo com a categoria socio do sócio vinculado ao endereço
                tx.setTaxaid(e.getIdPessoa().getSocio().getIdCategoriaSocio().getTaxasId());
                //Aqui adiciono todas as taxas de cada endereço...
                taxas.add(tx);
                //lista de taxasConta na conta...
                c.setTaxascontaList(taxas);
                new DaoContasMensais().AdicionarConta(c);
              
                
              }
            //se tiver selecionado as contas com hidrometro    
            else if(jRadioButtonContaHidrometro.isSelected()){
                
                
                
            }
           
           }
             }  
           
        if(c == null){
            jButton1.setEnabled(true);
           jRadioButtonContaFixa.setEnabled(true);
           jRadioButtonContaHidrometro.setEnabled(true);
            JOptionPane.showMessageDialog(GerarContas.this, "Nenhum sócio foi selecionado","Atenção", JOptionPane.INFORMATION_MESSAGE);
        }else{
           
           jButton1.setEnabled(true);
           jRadioButtonContaFixa.setEnabled(true);
           jRadioButtonContaHidrometro.setEnabled(true);
           JOptionPane.showMessageDialog(GerarContas.this,"Conta(s) Registrada(s) com sucesso!","Atenção",JOptionPane.INFORMATION_MESSAGE);
           jProgressBar1.setValue(0);
           carregarSocios();
           preencherTabela();
        }
             
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(GerarContas.this, e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
        }
       }};  
      
      t.start();
      }
      
          
      
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMonthChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMonthChooser1PropertyChange
       taxas.clear();
       if(jRadioButtonContaFixa.isSelected()){
           
           jRadioButtonContaFixaActionPerformed(null);
       }else if(jRadioButtonContaHidrometro.isSelected()){
           
           jRadioButtonContaHidrometroActionPerformed(null);
       }
    }//GEN-LAST:event_jMonthChooser1PropertyChange

    private void jYearChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jYearChooser1PropertyChange
        taxas.clear();
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
            
            
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            Enderecopessoa e1 = new DaoEnderecoPessoa().EnderecopessoaporNumero((int)model.getValueAt(jTable1.getSelectedRow(), 5));
            //se o mapa não tiver essa chave , ele adiciona e coloca um único valor...que é a taxa principal
            if(!taxas.containsKey(e1.getNumero())){
                List<Taxa> inicial = new ArrayList<>();
                inicial.add(e1.getIdPessoa().getSocio().getIdCategoriaSocio().getTaxasId());
                taxas.put(e1.getNumero(), inicial);
            }
            
            List<Taxa> t1 = taxas.get(e1.getNumero());

            Taxas t = new Taxas(null, true, t1);
             t.setLocationRelativeTo(null);
            t.setVisible(true);
           
            taxas.get(e1.getNumero()).clear();
            double soma = 0;
            List<Taxa> taxasTaxas = t.getValoresTaxas();
            for(Taxa aux : taxasTaxas){
            soma += aux.getValor().doubleValue();
            taxas.get(e1.getNumero()).add(aux);
        }
            
            
            //Atualiza o valor da conta de acordo com a quantidade de taxas
            model.setValueAt(BigDecimal.valueOf(soma), jTable1.getSelectedRow(), 6);
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
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButtonContaFixa;
    private javax.swing.JRadioButton jRadioButtonContaHidrometro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}