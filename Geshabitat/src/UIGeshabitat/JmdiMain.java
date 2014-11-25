/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGeshabitat;

import java.awt.Dimension;
import java.awt.Frame;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nelson
 */
public class JmdiMain extends javax.swing.JFrame {

    /**
     * Creates new form jMdiMain
     */
    public JmdiMain() {
        initComponents();

        this.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jMainToolBar = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jbtProcurar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jbtProcurar1 = new javax.swing.JButton();
        jDesktopPaneMain = new javax.swing.JDesktopPane();
        jStatusBar = new javax.swing.JPanel();
        jLeftPanel = new javax.swing.JPanel();
        jLeftPanelLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBarraMenus = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Geshabitat");

        jMainToolBar.setFloatable(false);
        jMainToolBar.setToolTipText("");
        jMainToolBar.setFocusable(false);

        jSeparator1.setSeparatorSize(new java.awt.Dimension(20, 10));
        jMainToolBar.add(jSeparator1);

        jButton2.setText("Novo Login");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jMainToolBar.add(jButton2);

        jSeparator3.setSeparatorSize(new java.awt.Dimension(20, 10));
        jMainToolBar.add(jSeparator3);

        jbtProcurar.setText("Procurar3");
        jbtProcurar.setFocusable(false);
        jbtProcurar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtProcurar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtProcurarActionPerformed(evt);
            }
        });
        jMainToolBar.add(jbtProcurar);

        jSeparator4.setSeparatorSize(new java.awt.Dimension(20, 10));
        jMainToolBar.add(jSeparator4);

        jbtProcurar1.setText("Users");
        jbtProcurar1.setFocusable(false);
        jbtProcurar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtProcurar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtProcurar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtProcurar1ActionPerformed(evt);
            }
        });
        jMainToolBar.add(jbtProcurar1);

        jStatusBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jStatusBarLayout = new javax.swing.GroupLayout(jStatusBar);
        jStatusBar.setLayout(jStatusBarLayout);
        jStatusBarLayout.setHorizontalGroup(
            jStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jStatusBarLayout.setVerticalGroup(
            jStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jLeftPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jLeftPanelLayout = new javax.swing.GroupLayout(jLeftPanel);
        jLeftPanel.setLayout(jLeftPanelLayout);
        jLeftPanelLayout.setHorizontalGroup(
            jLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );
        jLeftPanelLayout.setVerticalGroup(
            jLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIGeshabitat/pictures/logotipo_habitat_trans.png"))); // NOI18N

        javax.swing.GroupLayout jLeftPanelLogoLayout = new javax.swing.GroupLayout(jLeftPanelLogo);
        jLeftPanelLogo.setLayout(jLeftPanelLogoLayout);
        jLeftPanelLogoLayout.setHorizontalGroup(
            jLeftPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jLeftPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLeftPanelLogoLayout.createSequentialGroup()
                    .addGap(0, 5, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
        jLeftPanelLogoLayout.setVerticalGroup(
            jLeftPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
            .addGroup(jLeftPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLeftPanelLogoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jMenu1.setText("File");
        jBarraMenus.add(jMenu1);

        jMenu2.setText("Edit");
        jBarraMenus.add(jMenu2);

        setJMenuBar(jBarraMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLeftPanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPaneMain)
                .addContainerGap())
            .addComponent(jMainToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jMainToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLeftPanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JinternalFrameLogin jfrmLogin = new JinternalFrameLogin();
        Dimension desktopSize = jDesktopPaneMain.getSize();
        Dimension frmLoginSize = jfrmLogin.getSize();
        
        jfrmLogin.setLocation((desktopSize.width - frmLoginSize.width)/2,
                              (desktopSize.height - frmLoginSize.height)/2);
          
        jfrmLogin.setVisible(true);
        
        jDesktopPaneMain.add(jfrmLogin);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbtProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtProcurarActionPerformed
        JinternalFrameMain jfrmMain = new JinternalFrameMain();

        jDesktopPaneMain.add(jfrmMain);
        
        try {
            jfrmMain.setMaximum(true);
        } catch (PropertyVetoException ex) {
        }
        jfrmMain.setVisible(true);
        
    }//GEN-LAST:event_jbtProcurarActionPerformed

    private void jbtProcurar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtProcurar1ActionPerformed
        JintFrmUserManagment jfrmUsers = new JintFrmUserManagment();
        
        Dimension desktopSize = jDesktopPaneMain.getSize();
        Dimension frmLoginSize = jfrmUsers.getSize();
        

        jDesktopPaneMain.add(jfrmUsers);
        

        jfrmUsers.setLocation((desktopSize.width - frmLoginSize.width)/2,
                             (desktopSize.height - frmLoginSize.height)/2);
  
        jfrmUsers.setVisible(true);
    }//GEN-LAST:event_jbtProcurar1ActionPerformed

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
            java.util.logging.Logger.getLogger(JmdiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JmdiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JmdiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JmdiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JmdiMain().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jBarraMenus;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPaneMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jLeftPanel;
    private javax.swing.JPanel jLeftPanelLogo;
    private javax.swing.JToolBar jMainToolBar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JPanel jStatusBar;
    private javax.swing.JButton jbtProcurar;
    private javax.swing.JButton jbtProcurar1;
    // End of variables declaration//GEN-END:variables
}
