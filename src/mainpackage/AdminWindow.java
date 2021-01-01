package mainpackage;

public class AdminWindow extends javax.swing.JFrame {

    private ApplicationWindow appWindow;

    public AdminWindow(ApplicationWindow appWindow) {

        this.appWindow = appWindow;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminMainPanel = new mainpackage.AdminWindowPanels.AdminMainPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fereastra Admin");
        getContentPane().add(adminMainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mainpackage.AdminWindowPanels.AdminMainPanel adminMainPanel;
    // End of variables declaration//GEN-END:variables
};
