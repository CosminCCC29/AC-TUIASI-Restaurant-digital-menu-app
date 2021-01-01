package mainpackage;

import java.awt.*;
import javax.swing.*;

public class ApplicationWindow extends javax.swing.JFrame {

    private static ApplicationWindow applicationWindow;
    
    
    private final static int WINDOWWIDTH = 1280;
    private final static int WINDOWHEIGHT = 720;
    
    public ApplicationWindow() {
        applicationWindow = null;
        initComponents();
        resizeImages();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        mainButtonsPanel = new javax.swing.JPanel();
        adminButton = new javax.swing.JButton();
        clientButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meniu restaurant");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1280, 755));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        mainPanel.setPreferredSize(new java.awt.Dimension(1280, 720));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setBackground(new java.awt.Color(255, 255, 255));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Poze/Logo Restaurant.jpg"))); // NOI18N
        logoLabel.setVerifyInputWhenFocusTarget(false);
        mainPanel.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 490, 400));

        leftPanel.setBackground(new java.awt.Color(102, 51, 0));

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        mainPanel.add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 720));

        rightPanel.setBackground(new java.awt.Color(102, 51, 0));

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        mainPanel.add(rightPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, -1));

        mainButtonsPanel.setBackground(new java.awt.Color(102, 51, 0));
        mainButtonsPanel.setForeground(new java.awt.Color(255, 255, 255));
        mainButtonsPanel.setPreferredSize(new java.awt.Dimension(444, 270));
        mainButtonsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminButton.setBackground(new java.awt.Color(255, 255, 255));
        adminButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        adminButton.setText("Admin");
        adminButton.setPreferredSize(new java.awt.Dimension(60, 20));
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });
        mainButtonsPanel.add(adminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 130, 40));

        clientButton.setBackground(new java.awt.Color(255, 255, 255));
        clientButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        clientButton.setText("Client");
        clientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientButtonActionPerformed(evt);
            }
        });
        mainButtonsPanel.add(clientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 130, 40));

        mainPanel.add(mainButtonsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, -1, -1));

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

        mainPanel.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        
        AdminWindow.startAdminWindow();
        ApplicationWindow.getApplicationWindow().setVisible(false);
    }//GEN-LAST:event_adminButtonActionPerformed

    private void clientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientButtonActionPerformed
        // TODO add your handling code here:
        ClientWindow.startClientWindow();
        ApplicationWindow.getApplicationWindow().setVisible(false);
    }//GEN-LAST:event_clientButtonActionPerformed

    private void resizeImages()
    {
        ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("/Poze/Logo Restaurant.jpg")).getImage().getScaledInstance(this.logoLabel.getWidth(), this.logoLabel.getHeight(), Image.SCALE_SMOOTH));
        this.logoLabel.setIcon(img);
    }

    public static void startApplicationWindow()
    {
        if(applicationWindow == null)
        {
            applicationWindow = new ApplicationWindow();
            applicationWindow.setVisible(true);
        }
    }
    
    public static ApplicationWindow getApplicationWindow()
    {
            return applicationWindow;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButton;
    private javax.swing.JButton clientButton;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainButtonsPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration//GEN-END:variables
}
