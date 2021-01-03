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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import mainpackage.ApplicationWindow;

/**
 *
 * @author cosmi
 */
public class MenusAdminPanel extends javax.swing.JPanel {

    /**
     * Creates new form menusAdminPanel
     */
    private final ApplicationWindow appWindow;
    private TableRowSorter<DefaultTableModel> tr;
    private List<RowSorter.SortKey> sortKeys;

    public MenusAdminPanel(ApplicationWindow appWindow) {
        this.appWindow = appWindow;
        initComponents();
        initFilter();

        setVisibleAll(false);
        initActionListeners();

    }

    private void initActionListeners() {
        insertButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
        showButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
        deleteButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
        deleteBoxesButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
        updateButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
        showButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
    }

    private void initFilter() {
        tr = new TableRowSorter<>((DefaultTableModel) menusTable.getModel());
        menusTable.setRowSorter(tr);

        sortKeys = new ArrayList<>();
        for (int i = 0; i < menusTable.getColumnCount(); ++i) {
            sortKeys.add(new RowSorter.SortKey(i, SortOrder.UNSORTED));
        }
    }

    public void startFilter() {
        tr.setRowFilter(RowFilter.regexFilter(filterTextField.getText()));
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
                } else if (!filterTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Stergeti textul din caseta filtrarii!");
                    break;
                }

                tr.setSortKeys(sortKeys);

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date(System.currentTimeMillis());
                String currentDate = formatter.format(date);

                tblModel = (DefaultTableModel) this.menusTable.getModel();

                nume_meniu = numeMeniuTextField.getText();
                detalii_suplimentare_meniu = detaliiSuplimentareTextField.getText();

                ////////////////////// Modificare baza de date //////////////////////
                try {
                    PreparedStatement prepSt = conn.prepareStatement("INSERT INTO Meniuri(nume_meniu, Administratori_id_admin, detalii_suplimentare_meniu) VALUES(?, ?, ?)");
                    prepSt.setString(1, nume_meniu);
                    prepSt.setInt(2, 1);
                    prepSt.setString(3, detalii_suplimentare_meniu);
                    prepSt.execute();

                    ResultSet rs = conn.createStatement().executeQuery("SELECT MAX(nr_meniu) FROM Meniuri");
                    rs.next();
                    nr_meniu = rs.getString(1);
                    Object tfData[] = {Integer.parseInt(nr_meniu), nume_meniu, detalii_suplimentare_meniu, currentDate};
                    tblModel.addRow(tfData);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }

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

                    nr_meniu = tblModel.getValueAt(menusTable.convertRowIndexToModel(menusTable.getSelectedRow()), 0).toString();
                    nume_meniu = numeMeniuTextField.getText();
                    detalii_suplimentare_meniu = detaliiSuplimentareTextField.getText();
                    data_crearii = tblModel.getValueAt(menusTable.getSelectedRow(), 3).toString();

                    String tmp_nume_meniu = nume_meniu;
                    String tmp_detalii_suplimentare_meniu = detalii_suplimentare_meniu;

                    try {

                        tblModel.setValueAt(nr_meniu, menusTable.convertRowIndexToModel(menusTable.getSelectedRow()), 0);
                        tblModel.setValueAt(nume_meniu, menusTable.convertRowIndexToModel(menusTable.getSelectedRow()), 1);
                        tblModel.setValueAt(detalii_suplimentare_meniu, menusTable.convertRowIndexToModel(menusTable.getSelectedRow()), 2);
                        tblModel.setValueAt(data_crearii, menusTable.convertRowIndexToModel(menusTable.getSelectedRow()), 3);

                        PreparedStatement prepSelectSt = conn.prepareStatement("SELECT * FROM Meniuri WHERE nr_meniu = ?");
                        prepSelectSt.setShort(1, Short.parseShort(nr_meniu));
                        ResultSet resultSelectSet = prepSelectSt.executeQuery();
                        resultSelectSet.next();

                        if (!nume_meniu.equals(resultSelectSet.getString("nume_meniu"))) {
                            PreparedStatement prepUpdateSt1 = conn.prepareStatement("UPDATE Meniuri SET nume_meniu = ? WHERE nr_meniu = ?");
                            prepUpdateSt1.setString(1, nume_meniu);
                            prepUpdateSt1.setShort(2, Short.parseShort(nr_meniu));
                            prepUpdateSt1.execute();
                        }

                        if (!detalii_suplimentare_meniu.equals(resultSelectSet.getString("detalii_suplimentare_meniu"))) {
                            PreparedStatement prepUpdateSt2 = conn.prepareStatement("UPDATE Meniuri SET detalii_suplimentare_meniu = ? WHERE nr_meniu = ?");
                            prepUpdateSt2.setString(1, detalii_suplimentare_meniu);
                            prepUpdateSt2.setShort(2, Short.parseShort(nr_meniu));
                            prepUpdateSt2.execute();
                        }

                    } catch (SQLException ex) {

                        tblModel.setValueAt(tmp_nume_meniu, menusTable.convertRowIndexToModel(menusTable.getSelectedRow()), 1);
                        tblModel.setValueAt(tmp_detalii_suplimentare_meniu, menusTable.convertRowIndexToModel(menusTable.getSelectedRow()), 2);
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Selecteaza un singur rand pentru a modifica.");

                }

                break;

            case "Sterge":

                tblModel = (DefaultTableModel) menusTable.getModel();

                if (menusTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Tabelul este gol.");
                } else if (menusTable.getSelectedRowCount() == 1) {

                    nume_meniu = menusTable.getValueAt(menusTable.convertRowIndexToModel(menusTable.getSelectedRow()), 2).toString();
                    
                    try {
                        PreparedStatement prepSt = conn.prepareStatement("DELETE FROM Meniuri WHERE nr_meniu = (SELECT nr_meniu FROM Meniuri WHERE nume_meniu = ?)");
                        prepSt.setString(1, nume_meniu);
                        prepSt.execute();

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }

                    tblModel.removeRow(menusTable.convertRowIndexToModel(menusTable.getSelectedRow()));
                } else {
                    JOptionPane.showMessageDialog(this, "Selecteaza un singur rand pentru a sterge.");
                }
                break;

            case "Afisare":

                tr.setSortKeys(sortKeys);
                setVisibleAll(true);

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

                        Object tblData[] = {Integer.parseInt(nr_meniu), nume_meniu, detalii_suplimentare_meniu, data_crearii};
                        tblModel = (DefaultTableModel) this.menusTable.getModel();
                        tblModel.addRow(tblData);
                    }

                } catch (SQLException ex) {
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
        filterTextField = new javax.swing.JTextField();
        filterLabel = new javax.swing.JLabel();

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
                        .addComponent(deleteBoxesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(142, Short.MAX_VALUE))
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

        filterTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterTextFieldKeyReleased(evt);
            }
        });

        filterLabel.setText("Filter:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menusScrollPanel)
            .addComponent(menusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(filterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(menusScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setVisibleAll(boolean value) {
        this.insertUpdatePanel.setVisible(value);
        this.deleteButton.setVisible(value);
        this.updateButton.setVisible(value);
    }

    private void filterTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextFieldKeyReleased
        startFilter();
    }//GEN-LAST:event_filterTextFieldKeyReleased

    private void menusTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menusTableKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            String nume_meniu = menusTable.getValueAt(menusTable.getSelectedRow(), 1).toString();
            String detalii_suplimentare_meniu = (menusTable.getValueAt(menusTable.getSelectedRow(), 2) == null) ? "" : menusTable.getValueAt(menusTable.getSelectedRow(), 2).toString();

            numeMeniuTextField.setText(nume_meniu);
            detaliiSuplimentareTextField.setText(detalii_suplimentare_meniu);
        }
    }//GEN-LAST:event_menusTableKeyReleased

    private void menusTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusTableMouseClicked

        String nume_meniu = menusTable.getValueAt(menusTable.getSelectedRow(), 1).toString();
        String detalii_suplimentare_meniu = (menusTable.getValueAt(menusTable.getSelectedRow(), 2) == null) ? "" : menusTable.getValueAt(menusTable.getSelectedRow(), 2).toString();

        numeMeniuTextField.setText(nume_meniu);
        detaliiSuplimentareTextField.setText(detalii_suplimentare_meniu);

    }//GEN-LAST:event_menusTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton deleteBoxesButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel detaliiSuplimentareLabel;
    private javax.swing.JTextField detaliiSuplimentareTextField;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JTextField filterTextField;
    private javax.swing.JButton insertButton;
    private javax.swing.JPanel insertUpdatePanel;
    private javax.swing.JPanel menusPanel;
    private javax.swing.JScrollPane menusScrollPanel;
    private javax.swing.JTable menusTable;
    private javax.swing.JLabel numeMeniuLabel;
    private javax.swing.JTextField numeMeniuTextField;
    private javax.swing.JButton showButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
