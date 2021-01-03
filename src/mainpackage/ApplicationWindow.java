package mainpackage;

import Database.DataBaseConnection;
import EventHandling.AppActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ApplicationWindow extends javax.swing.JFrame {

    private AdminWindow adminWindow;
    public ClientWindow clientWindow;
    private final AppActionListener appActionListener;
    private final DataBaseConnection dataBaseConnection;
    
    public ApplicationWindow() {
        
        dataBaseConnection = new DataBaseConnection("bd-dc.cs.tuiasi.ro","1539","orcl","bd137","bd137");
        appActionListener = new AppActionListener(this);
        
        adminWindow = null;
        clientWindow = null;
        
        initComponents();
        initActionListeners();
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
        mainButtonsPanel.add(adminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 130, 40));

        clientButton.setBackground(new java.awt.Color(255, 255, 255));
        clientButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        clientButton.setText("Client");
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

    public void initActionListeners()
    {
        adminButton.addActionListener(appActionListener.getButtonClickListener());
        clientButton.addActionListener(appActionListener.getButtonClickListener());
    }
    
    public void startAdminWindow() {
        if(adminWindow == null)
        {
            adminWindow = new AdminWindow(this);
            adminWindow.setVisible(true);
        }
    }
    
    public void startClientWindow() {
        if(clientWindow == null)
        {
            clientWindow = new ClientWindow(this);
            clientWindow.setVisible(true);
        }
    }
    
    public void stopClientWindow()
    {
        if(clientWindow != null)
        {   
            clientWindow.setVisible(false);
            clientWindow = null;
        }
    }
    
    public AppActionListener getAppActionListener() {
        return appActionListener;
    }
    
    public DataBaseConnection getDataBaseConnection() {
        return dataBaseConnection;
    }
    
    public AdminWindow getAdminWindow() {
        return adminWindow;
    }
    
    public ClientWindow getClientWindow() {
        return clientWindow;
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
