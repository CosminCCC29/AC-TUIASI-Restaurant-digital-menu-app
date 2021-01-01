package mainpackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import mainpackage.Panels.BauturiPanel;
import mainpackage.Panels.PizzaPanel;
import mainpackage.Panels.SupePanel;

public class ClientWindow extends javax.swing.JFrame {

    private static ClientWindow clientWindow = null;
    
    GridBagLayout layout = new GridBagLayout();
    PizzaPanel p1;
    SupePanel p2;
    BauturiPanel p3;
    
    public ClientWindow() {
        initComponents();
        p1 = new PizzaPanel();
        p2 = new SupePanel();
        p3 = new BauturiPanel();
        DynamicPanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(p1,c);
        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(p3,c);
        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(p2,c);
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
    }
    
    /*private void resizeImages()
    {
        ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("/Logo Restaurant.jpg")).getImage().getScaledInstance(this.logoLabel.getWidth(), this.logoLabel.getHeight(), Image.SCALE_SMOOTH));
        this.logoLabel.setIcon(img);
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        CtgPanel = new javax.swing.JPanel();
        btnClientPanel1 = new javax.swing.JButton();
        btnClientPanel2 = new javax.swing.JButton();
        btnClientPanel3 = new javax.swing.JButton();
        DynamicPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fereastra meniu client");

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CtgPanel.setBackground(new java.awt.Color(204, 51, 0));

        btnClientPanel1.setText("Pizza");
        btnClientPanel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientPanel1ActionPerformed(evt);
            }
        });

        btnClientPanel2.setText("Supe");
        btnClientPanel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientPanel2ActionPerformed(evt);
            }
        });

        btnClientPanel3.setText("Bauturi");
        btnClientPanel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientPanel3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CtgPanelLayout = new javax.swing.GroupLayout(CtgPanel);
        CtgPanel.setLayout(CtgPanelLayout);
        CtgPanelLayout.setHorizontalGroup(
            CtgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CtgPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(CtgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClientPanel3)
                    .addGroup(CtgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnClientPanel2)
                        .addComponent(btnClientPanel1)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        CtgPanelLayout.setVerticalGroup(
            CtgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CtgPanelLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(btnClientPanel1)
                .addGap(67, 67, 67)
                .addComponent(btnClientPanel2)
                .addGap(67, 67, 67)
                .addComponent(btnClientPanel3)
                .addContainerGap(395, Short.MAX_VALUE))
        );

        mainPanel.add(CtgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, -1));

        DynamicPanel.setBackground(new java.awt.Color(204, 153, 0));

        javax.swing.GroupLayout DynamicPanelLayout = new javax.swing.GroupLayout(DynamicPanel);
        DynamicPanel.setLayout(DynamicPanelLayout);
        DynamicPanelLayout.setHorizontalGroup(
            DynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1260, Short.MAX_VALUE)
        );
        DynamicPanelLayout.setVerticalGroup(
            DynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        mainPanel.add(DynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 0, 1260, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientPanel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientPanel1ActionPerformed
        // TODO add your handling code here:
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
    }//GEN-LAST:event_btnClientPanel1ActionPerformed

    private void btnClientPanel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientPanel2ActionPerformed
        // TODO add your handling code here:
        p1.setVisible(false);
        p2.setVisible(true);
        p3.setVisible(false);
    }//GEN-LAST:event_btnClientPanel2ActionPerformed

    private void btnClientPanel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientPanel3ActionPerformed
        // TODO add your handling code here:
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(true);
    }//GEN-LAST:event_btnClientPanel3ActionPerformed

    public static void startClientWindow() {

        if(clientWindow == null)
        {
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    clientWindow = new ClientWindow();
                    clientWindow.setVisible(true);
                }
            });
        }
    }
    
    public static ClientWindow getClientWindow()
    {
        return clientWindow;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CtgPanel;
    private javax.swing.JPanel DynamicPanel;
    private javax.swing.JButton btnClientPanel1;
    private javax.swing.JButton btnClientPanel2;
    private javax.swing.JButton btnClientPanel3;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
