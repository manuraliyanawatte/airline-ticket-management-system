/*
 * Ruchina Perera, Manura Liyanawatte, Susith Sugathapala, Nadun Ferdinando
 * SLIIT
 * Batch 2
 * ST 2
 *
 */
package main;

import dal.DBConnect;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;


public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUName = new javax.swing.JTextField();
        txtPW = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(700, 450));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(700, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setText("Airline Ticket Management System");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 190, 420, 80);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel2.setText("Username ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 260, 110, 30);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 270, 110, 21);

        txtUName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtUName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUName);
        txtUName.setBounds(140, 310, 200, 40);

        txtPW.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtPW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPWActionPerformed(evt);
            }
        });
        getContentPane().add(txtPW);
        txtPW.setBounds(360, 310, 200, 40);

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnClose.setText("X");
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose);
        btnClose.setBounds(560, 50, 40, 23);

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(480, 360, 80, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/bg.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 640, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUNameActionPerformed
        
    }//GEN-LAST:event_txtUNameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        DBConnect db = new DBConnect();
        Connection con = db.connect();//DB Connection
        int rowCount = 0;
        String sql = "select * from Staff where UName = '"+ txtUName.getText()+"' and PWord = '"+txtPW.getText()+"'";
        Staff staffObj = new Staff();
        try{
            Statement st = con.createStatement();
        
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(sql);

            // Iterate for the results row
            while (rs.next())
            {
                staffObj.setStaffID( rs.getString("StaffId"));
                staffObj.setStaffName( rs.getString("Name"));
                rowCount++;
            }
            st.close();
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
        if(rowCount > 0){
            Home hmObj = new Home(staffObj);
            this.setVisible(false);
            this.dispose();
            hmObj.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Login Failed.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPWActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtPW;
    private javax.swing.JTextField txtUName;
    // End of variables declaration//GEN-END:variables
}
