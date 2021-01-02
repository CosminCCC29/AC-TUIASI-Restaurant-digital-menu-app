/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage.AdminWindowPanels;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mainpackage.ApplicationWindow;

/**
 *
 * @author cosmi
 */
public class MenusAdminPanel extends javax.swing.JPanel {

    /**
     * Creates new form menusAdminPanel
     */
    private ApplicationWindow appWindow;
    private boolean updatesOccurred = false;

    public MenusAdminPanel(ApplicationWindow appWindow) {
        this.appWindow = appWindow;
        initComponents();
        initActionListeners();
    }

    private void initActionListeners() {
        insertButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
        showButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
        deleteButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
        deleteBoxesButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
        updateButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
        saveButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
    }

    public void startAction(ActionEvent e) {
        JButton tmpEventButton = (JButton) e.getSource();

        Connection conn = appWindow.getDataBaseConnection().getConnection();

        DefaultTableModel tblModel;
        String nr_meniu;
        String nume_meniu;
        String detalii_suplimentare_meniu;
        String data_crearii;

        switch (tmpEventButton.getText()) {
            case "Inserare":

                if (numeMeniuTextField.getText().equals("") && detaliiSuplimentareTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Casetele sunt goale.");
                    break;
                }

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date(System.currentTimeMillis());
                String currentDate = formatter.format(date);

                tblModel = (DefaultTableModel) this.menusTable.getModel();
                nr_meniu = (tblModel.getRowCount() == 0)? String.valueOf(0) : (menusTable.getValueAt(tblModel.getRowCount() - 1, 0)).toString();
                nr_meniu = String.valueOf(Integer.parseInt(nr_meniu) + 1);
                
                String tfData[] = {nr_meniu, numeMeniuTextField.getText(), detaliiSuplimentareTextField.getText(), currentDate};
                tblModel.addRow(tfData);

                updatesOccurred = true;
                break;

            case "Sterge casetele":
                numeMeniuTextField.setText("");
                detaliiSuplimentareTextField.setText("");
                break;

            case "Modificare":

                tblModel = (DefaultTableModel) menusTable.getModel();

                if (menusTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Tabelul este gol.");
                } else if (menusTable.getSelectedRowCount() == 1) {

                    nr_meniu = tblModel.getValueAt(menusTable.getSelectedRow(), 0).toString();
                    nume_meniu = numeMeniuTextField.getText();
                    detalii_suplimentare_meniu = detaliiSuplimentareTextField.getText();
                    data_crearii = tblModel.getValueAt(menusTable.getSelectedRow(), 3).toString();

                    tblModel.setValueAt(nr_meniu, menusTable.getSelectedRow(), 0);
                    tblModel.setValueAt(nume_meniu, menusTable.getSelectedRow(), 1);
                    tblModel.setValueAt(detalii_suplimentare_meniu, menusTable.getSelectedRow(), 2);
                    tblModel.setValueAt(data_crearii, menusTable.getSelectedRow(), 3);

                    updatesOccurred = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Selecteaza un singur rand pentru a modifica.");
                }

                break;

            case "Sterge":

                tblModel = (DefaultTableModel) menusTable.getModel();

                if (menusTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Tabelul este gol.");
                } else if (menusTable.getSelectedRowCount() == 1) {
                    tblModel.removeRow(menusTable.getSelectedRow());
                    updatesOccurred = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Selecteaza un singur rand pentru a sterge.");
                }
                break;

            case "Afisare":

                try {
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT nr_meniu, nume_meniu, detalii_suplimentare_meniu, data_crearii FROM Meniuri");

                    tblModel = (DefaultTableModel) menusTable.getModel();
                    tblModel.setRowCount(0);

                    while (rs.next()) {
                        nr_meniu = String.valueOf(rs.getShort("nr_meniu"));
                        nume_meniu = rs.getString("nume_meniu");
                        detalii_suplimentare_meniu = rs.getString("detalii_suplimentare_meniu");
                        data_crearii = rs.getDate("data_crearii").toString();

                        String tblData[] = {nr_meniu, nume_meniu, detalii_suplimentare_meniu, data_crearii};
                        tblModel = (DefaultTableModel) this.menusTable.getModel();
                        tblModel.addRow(tblData);
                    }

                    updatesOccurred = false;

                } catch (SQLException ex) {
                    Logger.getLogger(MenusAdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "Salveaza modificarile":

                if (!updatesOccurred) {
                    JOptionPane.showMessageDialog(this, "Trebuie sa modificati tabelul pentru a putea salva.");
                    break;
                }

                tblModel = (DefaultTableModel) menusTable.getModel();

                try {

                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT nr_meniu, nume_meniu, detalii_suplimentare_meniu, data_crearii FROM Meniuri");
                    
                    long idxDatabase = 0;
                    long idxJTableRows = 0;
                        
                    while(rs.next())
                    {
                        
                        
                        
                        
                    }
                    
                    for (int i = 0; i < tblModel.getRowCount(); ++i) {
                        nr_meniu = tblModel.getValueAt(i, 0).toString();
                        nume_meniu = tblModel.getValueAt(i, 1).toString();
                        detalii_suplimentare_meniu = (tblModel.getValueAt(i, 2) == null) ? null : tblModel.getValueAt(i, 2).toString();
                        data_crearii = tblModel.getValueAt(i, 3).toString();
                    }

                } catch (Exception ex) {
                    Logger.getLogger(MenusAdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

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
        java.awt.GridBagConstraints gridBagConstraints;

        menusScrollPanel = new javax.swing.JScrollPane();
        menusTable = new javax.swing.JTable();
        menusPanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        insertUpdatePanel = new javax.swing.JPanel();
        numeMeniuLabel = new javax.swing.JLabel();
        detaliiSuplimentareLabel = new javax.swing.JLabel();
        numeMeniuTextField = new javax.swing.JTextField();
        detaliiSuplimentareTextField = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();
        deleteBoxesButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1065, 718));

        menusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nr_meniu", "nume_meniu", "detalii_suplimentare", "data_creare"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        menusTable.getTableHeader().setReorderingAllowed(false);
        menusTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menusTableMouseClicked(evt);
            }
        });
        menusTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                menusTableKeyReleased(evt);
            }
        });
        menusScrollPanel.setViewportView(menusTable);

        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        deleteButton.setText("Sterge");
        deleteButton.setActionCommand("ButoaneMeniuriAdmin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 13, 14);
        buttonsPanel.add(deleteButton, gridBagConstraints);

        showButton.setText("Afisare");
        showButton.setActionCommand("ButoaneMeniuriAdmin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 13, 14);
        buttonsPanel.add(showButton, gridBagConstraints);

        updateButton.setText("Modificare");
        updateButton.setActionCommand("ButoaneMeniuriAdmin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 13, 14);
        buttonsPanel.add(updateButton, gridBagConstraints);

        numeMeniuLabel.setText("nume_menu:");

        detaliiSuplimentareLabel.setText("detalii_suplimentare:");

        insertButton.setText("Inserare");
        insertButton.setActionCommand("ButoaneMeniuriAdmin");

        deleteBoxesButton.setText("Sterge casetele");
        deleteBoxesButton.setActionCommand("ButoaneMeniuriAdmin");

        saveButton.setText("Salveaza modificarile");
        saveButton.setActionCommand("ButoaneMeniuriAdmin");

        javax.swing.GroupLayout insertUpdatePanelLayout = new javax.swing.GroupLayout(insertUpdatePanel);
        insertUpdatePanel.setLayout(insertUpdatePanelLayout);
        insertUpdatePanelLayout.setHorizontalGroup(
            insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertUpdatePanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detaliiSuplimentareLabel)
                    .addComponent(numeMeniuLabel))
                .addGap(18, 18, 18)
                .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detaliiSuplimentareTextField)
                    .addComponent(numeMeniuTextField))
                .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertUpdatePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(insertUpdatePanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBoxesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(87, 87, 87))
        );
        insertUpdatePanelLayout.setVerticalGroup(
            insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertUpdatePanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeMeniuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeMeniuLabel)
                    .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detaliiSuplimentareTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detaliiSuplimentareLabel)
                    .addComponent(deleteBoxesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout menusPanelLayout = new javax.swing.GroupLayout(menusPanel);
        menusPanel.setLayout(menusPanelLayout);
        menusPanelLayout.setHorizontalGroup(
            menusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insertUpdatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        menusPanelLayout.setVerticalGroup(
            menusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insertUpdatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menusPanelLayout.createSequentialGroup()
                        .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menusScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
            .addComponent(menusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menusScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menusTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusTableMouseClicked

        DefaultTableModel tblModel = (DefaultTableModel) this.menusTable.getModel();

        String nr_meniu = tblModel.getValueAt(menusTable.getSelectedRow(), 0).toString();
        String nume_meniu = tblModel.getValueAt(menusTable.getSelectedRow(), 1).toString();
        String detalii_suplimentare_meniu = (tblModel.getValueAt(menusTable.getSelectedRow(), 2) == null) ? "" : tblModel.getValueAt(menusTable.getSelectedRow(), 2).toString();

        numeMeniuTextField.setText(nr_meniu);
        numeMeniuTextField.setText(nume_meniu);
        detaliiSuplimentareTextField.setText(detalii_suplimentare_meniu);
    }//GEN-LAST:event_menusTableMouseClicked

    private void menusTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menusTableKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            DefaultTableModel tblModel = (DefaultTableModel) this.menusTable.getModel();
            String nr_meniu = tblModel.getValueAt(menusTable.getSelectedRow(), 0).toString();
            String nume_meniu = tblModel.getValueAt(menusTable.getSelectedRow(), 1).toString();
            String detalii_suplimentare_meniu = (tblModel.getValueAt(menusTable.getSelectedRow(), 2) == null) ? "" : tblModel.getValueAt(menusTable.getSelectedRow(), 2).toString();

            numeMeniuTextField.setText(nr_meniu);
            numeMeniuTextField.setText(nume_meniu);
            detaliiSuplimentareTextField.setText(detalii_suplimentare_meniu);
        }
    }//GEN-LAST:event_menusTableKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton deleteBoxesButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel detaliiSuplimentareLabel;
    private javax.swing.JTextField detaliiSuplimentareTextField;
    private javax.swing.JButton insertButton;
    private javax.swing.JPanel insertUpdatePanel;
    private javax.swing.JPanel menusPanel;
    private javax.swing.JScrollPane menusScrollPanel;
    private javax.swing.JTable menusTable;
    private javax.swing.JLabel numeMeniuLabel;
    private javax.swing.JTextField numeMeniuTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton showButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
