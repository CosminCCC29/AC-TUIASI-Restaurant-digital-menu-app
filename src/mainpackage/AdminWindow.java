package mainpackage;
public class AdminWindow extends javax.swing.JFrame {

    private static AdminWindow adminWindow = null;
    
    public AdminWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fereastra Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void startAdminWindow() {

        if(adminWindow == null)
        {
        
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    adminWindow = new AdminWindow();
                    adminWindow.setVisible(true);
                }
            });
        }
    }

    public static AdminWindow getApplicationWindow()
    {
        return adminWindow;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
};
