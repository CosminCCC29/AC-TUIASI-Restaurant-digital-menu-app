package mainpackage;

public class ClientWindow extends javax.swing.JFrame {

    private static ClientWindow clientWindow = null;
    
    public ClientWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fereastra meniu client");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1298, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    // End of variables declaration//GEN-END:variables
}
