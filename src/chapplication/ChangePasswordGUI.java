/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapplication;

import javax.swing.JOptionPane;

/**
 *
 * @author james.wolff
 */
public class ChangePasswordGUI extends javax.swing.JFrame {

    /**
     * Creates new form ChangePassword
     */
    public ChangePasswordGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        currPassLabel = new javax.swing.JLabel();
        currPassField = new javax.swing.JPasswordField();
        newPassField = new javax.swing.JPasswordField();
        confNewPassField = new javax.swing.JPasswordField();
        newPassLabel = new javax.swing.JLabel();
        confNewPassLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        currPassLabel.setText("Current Password:");

        currPassField.setBackground(new java.awt.Color(102, 102, 102));
        currPassField.setText("password|1");
        currPassField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                currPassFieldFocusGained(evt);
            }
        });

        newPassField.setBackground(new java.awt.Color(102, 102, 102));
        newPassField.setText("password|1");
        newPassField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newPassFieldFocusGained(evt);
            }
        });

        confNewPassField.setBackground(new java.awt.Color(102, 102, 102));
        confNewPassField.setText("password|1");
        confNewPassField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confNewPassFieldFocusGained(evt);
            }
        });

        newPassLabel.setText("New Password:");

        confNewPassLabel.setText("Confirm New Password:");

        confirmButton.setBackground(new java.awt.Color(51, 51, 51));
        confirmButton.setText("Confirm");
        confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmButtonMouseReleased(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(51, 51, 51));
        cancelButton.setText("Cancel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confNewPassField)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(confirmButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currPassLabel)
                            .addComponent(newPassLabel)
                            .addComponent(confNewPassLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(newPassField)
                    .addComponent(currPassField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confNewPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confNewPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseReleased
        String pass=currPassField.getText();
        String pass1=newPassField.getText();
        String pass2=confNewPassField.getText();
        if(ChapplicationGUI.localData.validPassword(ChapplicationGUI.getCurrentUser(), pass)){
            int confirm = JOptionPane.showOptionDialog(null,"Current password invalid","Invalid Input!", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(confirm==JOptionPane.CANCEL_OPTION){
                this.dispose();
            }
        }else if(!pass1.equals(pass2)){
            int confirm = JOptionPane.showOptionDialog(null,"Passwords do not match","Invalid Input!", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(confirm==JOptionPane.CANCEL_OPTION){
                this.dispose();
            }
        }else if(pass1.equals("password|1")){
            int confirm = JOptionPane.showOptionDialog(null,"Invalid Password","Invalid Input!", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(confirm==JOptionPane.CANCEL_OPTION){
                this.dispose();
            }
        }
    }//GEN-LAST:event_confirmButtonMouseReleased

    private void currPassFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_currPassFieldFocusGained
        currPassField.selectAll();
    }//GEN-LAST:event_currPassFieldFocusGained

    private void newPassFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPassFieldFocusGained
        newPassField.selectAll();
    }//GEN-LAST:event_newPassFieldFocusGained

    private void confNewPassFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confNewPassFieldFocusGained
        confNewPassField.selectAll();
    }//GEN-LAST:event_confNewPassFieldFocusGained

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
            java.util.logging.Logger.getLogger(ChangePasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePasswordGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPasswordField confNewPassField;
    private javax.swing.JLabel confNewPassLabel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JPasswordField currPassField;
    private javax.swing.JLabel currPassLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPassField;
    private javax.swing.JLabel newPassLabel;
    // End of variables declaration//GEN-END:variables
}