/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Logradouros.java
 *
 * Created on 15/05/2013, 17:54:14
 */
package telas;

import dao.DaoEndereco;
import entidades.Endereco;
import entidades.Enderecopessoa;
import java.util.List;

/**
 *
 * @author alunoarea1
 */
public class Logradouros extends javax.swing.JDialog {

 private List<Enderecopessoa> enderecos;
    /** Creates new form Logradouros */
    public Logradouros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
      
        setEditableComponentes(false);
    }
    
   public Logradouros(java.awt.Frame parent, boolean modal, List<Enderecopessoa> enderecos ){
       
       this(parent, modal);
       this.enderecos = enderecos;
          carregarCampos();      
       
   }
   
   
    private void carregarCampos(){
        
        List<Endereco> ends = new DaoEndereco().BuscarTodosEnderecos();
                jComboBox1.addItem("");
                jComboBox2.addItem("");
                jComboBox3.addItem("");
                jComboBox4.addItem("");
                jComboBox5.addItem("");
                jComboBox6.addItem("");
                jComboBox7.addItem("");
                jComboBox8.addItem("");
        if(!ends.isEmpty()){
            
            
            for(Endereco e : ends){
                jComboBox1.addItem(e.getTipo()+" "+e.getNome());
                jComboBox2.addItem(e.getTipo()+" "+e.getNome());
                jComboBox3.addItem(e.getTipo()+" "+e.getNome());
                jComboBox4.addItem(e.getTipo()+" "+e.getNome());
                jComboBox5.addItem(e.getTipo()+" "+e.getNome());
                jComboBox6.addItem(e.getTipo()+" "+e.getNome());
                jComboBox7.addItem(e.getTipo()+" "+e.getNome());
                jComboBox8.addItem(e.getTipo()+" "+e.getNome());
                
            }
        }
        
      
            
            switch(enderecos.size()){
                
               
                     case 1 : setSelectedCombos(1); break;
                     case 2 : setSelectedCombos(2); break;
                     case 3 : setSelectedCombos(3); break;
                     case 4 : setSelectedCombos(4); break;
                     case 5 : setSelectedCombos(5); break;
                     case 6 : setSelectedCombos(6); break;
                     case 7 : setSelectedCombos(7); break;
                     case 8 : setSelectedCombos(8); break;
                
            }
           
      
            
    
        
    }
    
    private void setSelectedCombos(int size){
        
        if(size >= 1){
            
            jComboBox1.setSelectedItem(enderecos.get(0).getIdEndereco().getTipo()+" "+enderecos.get(0).getIdEndereco().getNome());
            
        } if(size >= 2){
            
             jTextField2.setEditable(true);
             jComboBox2.setEnabled(true);
             jButtonAdicionar2.setEnabled(true);
             jComboBox2.setSelectedItem(enderecos.get(1).getIdEndereco().getTipo()+" "+enderecos.get(1).getIdEndereco().getNome());
        } if(size >= 3){
             jTextField3.setEditable(true);
             jComboBox3.setEnabled(true);
             jButtonAdicionar3.setEnabled(true);
             jComboBox3.setSelectedItem(enderecos.get(2).getIdEndereco().getTipo()+" "+enderecos.get(2).getIdEndereco().getNome());
        } if(size >= 4){
             jTextField4.setEditable(true);
             jComboBox4.setEnabled(true);
             jButtonAdicionar4.setEnabled(true);
             jComboBox4.setSelectedItem(enderecos.get(3).getIdEndereco().getTipo()+" "+enderecos.get(3).getIdEndereco().getNome());
        }if(size >= 5){
             jTextField5.setEditable(true);
             jComboBox5.setEnabled(true);
             jButtonAdicionar5.setEnabled(true);
             jComboBox5.setSelectedItem(enderecos.get(4).getIdEndereco().getTipo()+" "+enderecos.get(4).getIdEndereco().getNome());
            
        }if(size >= 6){
             jTextField6.setEditable(true);
             jComboBox6.setEnabled(true);
             jButtonAdicionar6.setEnabled(true);
             jComboBox6.setSelectedItem(enderecos.get(5).getIdEndereco().getTipo()+" "+enderecos.get(5).getIdEndereco().getNome());
        } if(size >= 7){
             jTextField7.setEditable(true);
             jComboBox7.setEnabled(true);
             jButtonAdicionar7.setEnabled(true);
             jComboBox1.setSelectedItem(enderecos.get(6).getIdEndereco().getTipo()+" "+enderecos.get(6).getIdEndereco().getNome());
        } if(size >= 8){
             jTextField8.setEditable(true);
             jComboBox8.setEnabled(true);
             jButtonAdicionar8.setEnabled(true);
             jComboBox8.setSelectedItem(enderecos.get(7).getIdEndereco().getTipo()+" "+enderecos.get(7).getIdEndereco().getNome());
        }
        
    }
    
    private void setEditableComponentes(boolean edit){
        
        jTextField2.setEditable(edit);
        jTextField3.setEditable(edit);
        jTextField4.setEditable(edit);
        jTextField5.setEditable(edit);
        jTextField6.setEditable(edit);
        jTextField7.setEditable(edit);
        jTextField8.setEditable(edit);
     
        jComboBox2.setEnabled(edit);
        jComboBox3.setEnabled(edit);
        jComboBox4.setEnabled(edit);
        jComboBox5.setEnabled(edit);
        jComboBox6.setEnabled(edit);
        jComboBox7.setEnabled(edit);
        jComboBox8.setEnabled(edit);
        
        jButtonAdicionar2.setEnabled(edit);
        jButtonAdicionar3.setEnabled(edit);
        jButtonAdicionar4.setEnabled(edit);
        jButtonAdicionar5.setEnabled(edit);
        jButtonAdicionar6.setEnabled(edit);
        jButtonAdicionar7.setEnabled(edit);
        jButtonAdicionar8.setEnabled(edit);
        
    }
 

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAdicionar2 = new javax.swing.JButton();
        jButtonAdicionar1 = new javax.swing.JButton();
        jButtonAdicionar3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jButtonAdicionar4 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox();
        jButtonAdicionar5 = new javax.swing.JButton();
        jButtonAdicionar7 = new javax.swing.JButton();
        jComboBox7 = new javax.swing.JComboBox();
        jButtonAdicionar8 = new javax.swing.JButton();
        jButtonAdicionar6 = new javax.swing.JButton();
        jComboBox8 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jButtonAdicionar2.setText("Adicionar");

        jButtonAdicionar1.setText("Adicionar");

        jButtonAdicionar3.setText("Adicionar");

        jButtonAdicionar4.setText("Adicionar");

        jButtonAdicionar5.setText("Adicionar");

        jButtonAdicionar7.setText("Adicionar");

        jButtonAdicionar8.setText("Adicionar");

        jButtonAdicionar6.setText("Adicionar");

        jLabel1.setText("Número");

        jLabel2.setText("Logradouro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionar3)
                            .addComponent(jButtonAdicionar1)
                            .addComponent(jButtonAdicionar2)
                            .addComponent(jButtonAdicionar4)
                            .addComponent(jButtonAdicionar5)
                            .addComponent(jButtonAdicionar7)
                            .addComponent(jButtonAdicionar8)
                            .addComponent(jButtonAdicionar6))))
                .addContainerGap(331, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAdicionar1, jButtonAdicionar2, jButtonAdicionar3, jButtonAdicionar4, jButtonAdicionar5, jButtonAdicionar6, jButtonAdicionar7, jButtonAdicionar8});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdicionar5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdicionar6)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdicionar7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdicionar8)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAdicionar1, jButtonAdicionar2, jButtonAdicionar3, jButtonAdicionar4, jButtonAdicionar5, jButtonAdicionar6, jButtonAdicionar7, jButtonAdicionar8});

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Logradouros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logradouros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logradouros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logradouros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Logradouros dialog = new Logradouros(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonAdicionar1;
    private javax.swing.JButton jButtonAdicionar2;
    private javax.swing.JButton jButtonAdicionar3;
    private javax.swing.JButton jButtonAdicionar4;
    private javax.swing.JButton jButtonAdicionar5;
    private javax.swing.JButton jButtonAdicionar6;
    private javax.swing.JButton jButtonAdicionar7;
    private javax.swing.JButton jButtonAdicionar8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
