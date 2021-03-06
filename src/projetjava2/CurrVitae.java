/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Scofield
 */
public class CurrVitae extends javax.swing.JFrame {

    /**
     * Creates new form CurrVitae
     * 
     */
    Connection con; 
    Statement stmt;
    ResultSet rs;
    public CurrVitae() {
        initComponents();
        DoConnect();
    }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(610, 430));
        getContentPane().setLayout(null);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(194, 102, 196, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Donner votre CIN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(42, 115, 106, 14);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava2/images/cv (1).png"))); // NOI18N
        jButton1.setText("Imprimer votre cv");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 240, 204, 43);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Telecharger votre CV");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(108, 20, 380, 44);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Votre Niveau");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(42, 153, 106, 14);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mastere", "Doctorant", "Enseignant" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(194, 150, 196, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava2/images/cvback.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-6, 0, 610, 430);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Se Deconnecter");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

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
             PreparedStatement st;
             if(jComboBox1.getSelectedIndex()==0){
             st=con.prepareStatement("select  c.cin, c.nom,c.prenom,c.age,c.tel,c.email,m.intmemoire from chercheur c ,etmastere m where c.cin=? and m.cin=c.cin");
             st.setString(1, cin);
             }
             else if(jComboBox1.getSelectedIndex()==1){
             st=con.prepareStatement("select  c.cin, c.nom,c.prenom,c.age,c.tel,c.email,d.titrethese,d.statut from chercheur c ,doctorant d where c.cin=? and d.cin=c.cin");
              st.setString(1, cin);
             }
             else{
             st=con.prepareStatement("select  c.cin, c.nom,c.prenom,c.age,c.tel,c.email,e.grade,e.institut from chercheur c, enseignant e where c.cin=? and e.cin=c.cin");
                 st.setString(1, cin);
             }
           
            rs=st.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "ce chercheur n'existe pas ou n'est pas un "+jComboBox1.getSelectedItem().toString());
            }
            else{
                 PreparedStatement s1=con.prepareStatement("select pc.titre, pc.cin,p.datepub from production p,prodchercheur pc where pc.titre= p.titre and pc.cin=?");
                 s1.setString(1, cin);
                ResultSet rs1;
                rs1=s1.executeQuery();
                String nomFichier=rs.getString("nom")+rs.getString("prenom")+".txt";
                PrintWriter p=new PrintWriter(new FileWriter(nomFichier));
                p.println("-------------Curruculum Vitae-------------------\n\n");
                p.println("I-Information Personel:\n");
                p.println("Cin: "+rs.getString("cin"));
                p.println("Nom: "+rs.getString("nom"));
                p.println("Prenom: "+rs.getString("prenom"));
                p.println("Age: "+rs.getString("age"));
                p.println("Telephone: "+rs.getString("tel"));
                p.println("Email: "+rs.getString("email"));
                p.println("Niveau: "+jComboBox1.getSelectedItem().toString());
                if(jComboBox1.getSelectedIndex()==0){
                    p.println("Intitule du Memoire du mastere : "+rs.getString("intmemoire"));
                }
                else if(jComboBox1.getSelectedIndex()==1){
                    p.println("Titre These : "+rs.getString("titrethese"));
                    p.println("Statut: "+rs.getString("statut"));
                }
                else{
                    p.println("Grade: "+rs.getString("grade"));
                    p.println("Institut: "+rs.getString("institut"));
                }
                p.println("\nII-Production:\n");
                while(rs1.next()){
                    p.println("Titre : "+rs1.getString("titre"));
                    p.println("Date de publication : "+rs1.getDate("datepub"));
                }
                p.close();
                JOptionPane.showMessageDialog(null, "Cv impimé avec succes");
                
                
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        new PrevChercheur().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(CurrVitae.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrVitae.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrVitae.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrVitae.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrVitae().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
