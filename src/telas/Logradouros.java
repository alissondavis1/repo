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
import dao.DaoEnderecoPessoa;
import dao.DaoPessoa;
import entidades.Endereco;
import entidades.Enderecopessoa;
import entidades.Pessoa;
import entidades.Socio;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alunoarea1
 */
public class Logradouros extends javax.swing.JDialog {

 private Socio s;
 private List<Enderecopessoa> enderecos;
    /** Creates new form Logradouros */
    public Logradouros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
      
        setEditableComponentes(false);
    }
    
   public Logradouros(java.awt.Frame parent, boolean modal, List<Enderecopessoa> enderecos , Socio s){
       
       this(parent, modal);
       this.enderecos = enderecos;
       this.s = s;
       carregarCampos();      
       
   }
   
   
    private void carregarCampos(){
        
        List<Endereco> ends = new DaoEndereco().BuscarTodosEnderecos();
               
        if(!ends.isEmpty() && jComboBox1.getItemCount() == 0){
            
             jComboBox1.addItem("");
                jComboBox2.addItem("");
                jComboBox3.addItem("");
                jComboBox4.addItem("");
                jComboBox5.addItem("");
                jComboBox6.addItem("");
                jComboBox7.addItem("");
                jComboBox8.addItem("");
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
            jTextField1.setText(String.valueOf(enderecos.get(0).getNumero()));
            jTextField2.setEditable(true);
             jComboBox2.setEnabled(true);
             jButtonAdicionar2.setEnabled(true);
             
        } if(size >= 2){
            
             jTextField2.setEditable(false);
             jComboBox2.setEnabled(false);
             jButtonAdicionar2.setEnabled(false);
              jButton2.setEnabled(true);
            jTextField2.setText(String.valueOf(enderecos.get(1).getNumero()));
            jTextField3.setEditable(true);
             jComboBox3.setEnabled(true);
             jButtonAdicionar3.setEnabled(true);
              
             jComboBox2.setSelectedItem(enderecos.get(1).getIdEndereco().getTipo()+" "+enderecos.get(1).getIdEndereco().getNome());
        } if(size >= 3){
            
             jTextField3.setEditable(false);
             jComboBox3.setEnabled(false);
             jButtonAdicionar3.setEnabled(false);
              jButton3.setEnabled(true);
            jTextField3.setText(String.valueOf(enderecos.get(2).getNumero()));
            
             jTextField4.setEditable(true);
             jComboBox4.setEnabled(true);
             jButtonAdicionar4.setEnabled(true);
             
             jComboBox3.setSelectedItem(enderecos.get(2).getIdEndereco().getTipo()+" "+enderecos.get(2).getIdEndereco().getNome());
        } if(size >= 4){
            
             jTextField4.setEditable(false);
             jComboBox4.setEnabled(false);
             jButtonAdicionar4.setEnabled(false);
              jButton4.setEnabled(true);
            jTextField4.setText(String.valueOf(enderecos.get(3).getNumero()));
             jTextField5.setEditable(true);
             jComboBox5.setEnabled(true);
             jButtonAdicionar5.setEnabled(true);
             
             jComboBox4.setSelectedItem(enderecos.get(3).getIdEndereco().getTipo()+" "+enderecos.get(3).getIdEndereco().getNome());
        }if(size >= 5){
            
            jTextField5.setEditable(false);
             jComboBox5.setEnabled(false);
             jButtonAdicionar5.setEnabled(false);
              jButton5.setEnabled(true);
            jTextField5.setText(String.valueOf(enderecos.get(4).getNumero()));
             jTextField6.setEditable(true);
             jComboBox6.setEnabled(true);
             jButtonAdicionar6.setEnabled(true);
             
             jComboBox5.setSelectedItem(enderecos.get(4).getIdEndereco().getTipo()+" "+enderecos.get(4).getIdEndereco().getNome());
            
        }if(size >= 6){
            
            jTextField6.setEditable(false);
             jComboBox6.setEnabled(false);
             jButtonAdicionar6.setEnabled(false);
              jButton6.setEnabled(true);
            jTextField6.setText(String.valueOf(enderecos.get(5).getNumero()));
             jTextField7.setEditable(true);
             jComboBox7.setEnabled(true);
             jButtonAdicionar7.setEnabled(true);
             
             jComboBox6.setSelectedItem(enderecos.get(5).getIdEndereco().getTipo()+" "+enderecos.get(5).getIdEndereco().getNome());
        } if(size >= 7){
            
            jTextField7.setEditable(false);
             jComboBox7.setEnabled(false);
             jButtonAdicionar7.setEnabled(false);
              jButton7.setEnabled(true);
            jTextField7.setText(String.valueOf(enderecos.get(6).getNumero()));
             jTextField8.setEditable(true);
             jComboBox8.setEnabled(true);
             jButtonAdicionar8.setEnabled(true);
             
             jComboBox7.setSelectedItem(enderecos.get(6).getIdEndereco().getTipo()+" "+enderecos.get(6).getIdEndereco().getNome());
        } if(size >= 8){
             
             jTextField8.setEditable(false);
             jComboBox8.setEnabled(false);
             jButtonAdicionar8.setEnabled(false);
              jButton8.setEnabled(true);
            jTextField8.setText(String.valueOf(enderecos.get(7).getNumero()));
             jComboBox8.setSelectedItem(enderecos.get(7).getIdEndereco().getTipo()+" "+enderecos.get(7).getIdEndereco().getNome());
        }if(size > 8){
            
            JOptionPane.showMessageDialog(this, "Você atingiu o número máximo de endereços","Erro",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void setEditableComponentes(boolean edit){
        
        jTextField1.setEditable(edit);
        
        jTextField2.setEditable(edit);
        jTextField3.setEditable(edit);
        jTextField4.setEditable(edit);
        jTextField5.setEditable(edit);
        jTextField6.setEditable(edit);
        jTextField7.setEditable(edit);
        jTextField8.setEditable(edit);
     
        jComboBox1.setEnabled(edit);
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
        
        jButton2.setEnabled(edit);
        jButton3.setEnabled(edit);
        jButton4.setEnabled(edit);
        jButton5.setEnabled(edit);
        jButton6.setEnabled(edit);
        jButton7.setEnabled(edit);
        jButton8.setEnabled(edit);
        
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jButtonAdicionar2.setText("Adicionar");
        jButtonAdicionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar2ActionPerformed(evt);
            }
        });

        jButtonAdicionar3.setText("Adicionar");
        jButtonAdicionar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar3ActionPerformed(evt);
            }
        });

        jButtonAdicionar4.setText("Adicionar");
        jButtonAdicionar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar4ActionPerformed(evt);
            }
        });

        jButtonAdicionar5.setText("Adicionar");
        jButtonAdicionar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar5ActionPerformed(evt);
            }
        });

        jButtonAdicionar7.setText("Adicionar");
        jButtonAdicionar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar7ActionPerformed(evt);
            }
        });

        jButtonAdicionar8.setText("Adicionar");
        jButtonAdicionar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar8ActionPerformed(evt);
            }
        });

        jButtonAdicionar6.setText("Adicionar");
        jButtonAdicionar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar6ActionPerformed(evt);
            }
        });

        jLabel1.setText("Número");

        jLabel2.setText("Logradouro");

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Remover");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Remover");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Remover");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Remover");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAdicionar2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAdicionar3)
                                    .addComponent(jButtonAdicionar4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAdicionar5)
                                    .addComponent(jButtonAdicionar6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5)
                                    .addComponent(jButton6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAdicionar7)
                                    .addComponent(jButtonAdicionar8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7)
                                    .addComponent(jButton8)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(238, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAdicionar2, jButtonAdicionar3, jButtonAdicionar4, jButtonAdicionar5, jButtonAdicionar6, jButtonAdicionar7, jButtonAdicionar8});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdicionar3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdicionar4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAdicionar5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAdicionar6)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAdicionar7)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAdicionar8)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8)))))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAdicionar2, jButtonAdicionar3, jButtonAdicionar4, jButtonAdicionar5, jButtonAdicionar6, jButtonAdicionar7, jButtonAdicionar8});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar2ActionPerformed
       
        adicionar(jComboBox2, jTextField2);
        
    }//GEN-LAST:event_jButtonAdicionar2ActionPerformed

    
    private void adicionar(JComboBox comboAtual, JTextField textoAtual){
        
          if(!textoAtual.getText().equals("") && !comboAtual.getSelectedItem().equals("")){
            if(new DaoEnderecoPessoa().EnderecopessoaporNumero(Integer.parseInt(textoAtual.getText())) == null ){
            int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja adicionar esse endereço? ","Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(op == JOptionPane.YES_OPTION){
                
                
                try{
                    
                    Endereco e = new DaoEndereco().BuscarEnderecoCompleto((String) comboAtual.getSelectedItem());
                    Pessoa p = this.s.getIdPessoa();
                    List<Enderecopessoa> ends = p.getEnderecopessoaList();
                    Enderecopessoa ep = new Enderecopessoa();
                    
                   
                    ep.setIdEndereco(e);
                    
//                    if(new DaoEnderecoPessoa().EnderecopessoaporNumero(Integer.parseInt(textoAtual.getText())) != null){
//                        
//                        throw new Exception("Número ja existe");
//                        
//                    }
                    ep.setNumero(Integer.parseInt(textoAtual.getText()));
                    ep.setIdPessoa(p);
                    ends.add(ep);
                    p.setEnderecopessoaList(ends);
                    
                    new DaoPessoa().AlterarPessoa(p);
                    
                    JOptionPane.showMessageDialog(this,"Endereço adicionado com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
                  
                    carregarCampos();
                }catch(Exception e){
                    
                    
                    JOptionPane.showMessageDialog(this, "Erro "+e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            }else{
                
                JOptionPane.showMessageDialog(this, "Número ou Endereço ja existente para esse sócio","Erro",JOptionPane.ERROR_MESSAGE);
                
            }
        }else{
            
            JOptionPane.showMessageDialog(this, "Preencha todos os campos","Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
       remover(jTextField2);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void remover(JTextField textoAtual){
        
         int op = JOptionPane.showConfirmDialog(this,"Deseja excluir o endereço? ","Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(op == JOptionPane.YES_OPTION){
            try{
        
                Enderecopessoa ep = new DaoEnderecoPessoa().EnderecopessoaporNumero(Integer.parseInt(textoAtual.getText()));
                this.enderecos.remove(ep);
                new DaoEnderecoPessoa().ApagarEnderecopessoa(ep);
                
        JOptionPane.showMessageDialog(this, "Endereço excluido com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
       limparCampos();
       setEditableComponentes(false);
        carregarCampos();
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(this, "Erro","Erro", JOptionPane.ERROR_MESSAGE);
                
            }
        }
        
        
    }
    
    private void jButtonAdicionar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar3ActionPerformed
       adicionar(jComboBox3, jTextField3);
    }//GEN-LAST:event_jButtonAdicionar3ActionPerformed

    private void jButtonAdicionar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar4ActionPerformed
       adicionar(jComboBox4, jTextField4);
    }//GEN-LAST:event_jButtonAdicionar4ActionPerformed

    private void jButtonAdicionar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar5ActionPerformed
        adicionar(jComboBox5, jTextField5);
    }//GEN-LAST:event_jButtonAdicionar5ActionPerformed

    private void jButtonAdicionar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar6ActionPerformed
        adicionar(jComboBox6, jTextField6);
    }//GEN-LAST:event_jButtonAdicionar6ActionPerformed

    private void jButtonAdicionar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar7ActionPerformed
        adicionar(jComboBox7, jTextField7);
    }//GEN-LAST:event_jButtonAdicionar7ActionPerformed

    private void jButtonAdicionar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar8ActionPerformed
       adicionar(jComboBox8, jTextField8);
    }//GEN-LAST:event_jButtonAdicionar8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        remover(jTextField3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        remover(jTextField4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        remover(jTextField5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        remover(jTextField6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       remover(jTextField7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        remover(jTextField8);
    }//GEN-LAST:event_jButton8ActionPerformed

    
    
    private void limparCampos(){
        
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jComboBox6.setSelectedIndex(0);
        jComboBox7.setSelectedIndex(0);
        jComboBox8.setSelectedIndex(0);
        
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
