/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Scofield
 */
public class Promotion extends javax.swing.JFrame {

    /**
     * Creates new form Promotion
     */
     Connection con; 
     Statement stmt;
     ResultSet rs;
    public Promotion() {
        initComponents();
         DoConnect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     private void DoConnect(){
        try{
          
       Connection conn=null;
    Class.forName("com.mysql.jdbc.Driver");    
 String url="jdbc:mysql://localhost:3306/laboratoire"; 
 con=DriverManager.getConnection(url,"root","");
 stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
 
   
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(820, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID Eneignant");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(223, 109, 100, 15);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(341, 106, 158, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Type de Promotion:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(193, 185, 130, 15);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Maitre Assisant-Maitre de conferences");
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(341, 164, 240, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Maitre de conferences-Professeur");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(341, 205, 240, 23);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava2/images/Education.png"))); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 300, 170, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Date promotion");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(223, 259, 100, 15);

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(341, 253, 184, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Ajouter une promotion ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(298, 11, 290, 55);

        jLabel5.setIcon(new javax.swing.ImageIcon("F:\\PROJET JAVA 2\\ajout.jpg")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -6, 820, 500);

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Menu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Se Deconnecter");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            String cin=jTextField1.getText();
            String date=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
            PreparedStatement st=con.prepareStatement("select cin from enseignant where cin= ?");
            st.setString(1, cin);
            rs=st.executeQuery();
            
            if(!rs.next())
                JOptionPane.showMessageDialog(this, "cet enseignant n'existe pas");
                else{
                        if(buttonGroup1.getSelection().equals(jRadioButton1.getModel())){
                        PreparedStatement s=con.prepareStatement("select cin,grade from enseignant where cin=? and lower(grade)=?");
                        s.setString(1, cin);
                        s.setString(2, "maitre assistant");
                        rs=s.executeQuery();
                        if(!rs.next())
                            JOptionPane.showMessageDialog(this, "Vous ne pouvez pas effectuer ce type de promotion");
                        else{
                            PreparedStatement s1=con.prepareStatement("insert into promotion values(?,?,?,?) ");
                            s1.setString(1, cin);
                            s1.setString(2, date);
                            s1.setString(3, "Maitre Assistant");
                            s.setString(4, "Maitre de Conferences");
                            s1.execute();
                             PreparedStatement s2=con.prepareStatement("update enseignant set grade=?,datederdiplome=? where cin=?");
                            s2.setString(1, "Maitre de Coneferences");
                            s2.setString(2, date);
                            s2.setString(3,cin);
                            s2.execute();
                            JOptionPane.showMessageDialog(this, "Promotion ajoutée");
                            
                        }
                                }
                        else{
                             PreparedStatement s=con.prepareStatement("select cin,grade from enseignant where cin=? and lower(grade)=?");
                        s.setString(1, cin);
                        s.setString(2, "maitre de conferences");
                        rs=s.executeQuery();
                        if(!rs.next())
                            JOptionPane.showMessageDialog(this, "Vous ne pouvez pas effectuer ce type de promotion");
                        else{
                            PreparedStatement s1=con.prepareStatement("insert into promotion values(?,?,?,?) ");
                            s1.setString(1, cin);
                            s1.setString(2, date);
                            s1.setString(3, "Maitre de Conferences");
                            s1.setString(4, "Professeur");
                            s1.execute();
                            PreparedStatement s2=con.prepareStatement("update enseignant set grade=?,datederdiplome=? where cin=?");
                            s2.setString(1, "Professeur");
                            s2.setString(2, date);
                             s2.setString(3,cin);
                            s2.execute();
                            JOptionPane.showMessageDialog(this, "Promotion ajoutée");
                            
                        }
                            
                            
                            
                        }
                
                        }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
          this.setVisible(false);
        new PrevChercheur().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Promotion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Promotion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}