/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandling;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mainpackage.ApplicationWindow;

/**
 * s
 *
 * @author cosmi
 */
public class ButtonClickListener implements ActionListener {

    private final ApplicationWindow applicationWindow;

    ButtonClickListener(ApplicationWindow applicationWindow) {
        this.applicationWindow = applicationWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        CardLayout cardLayout;

        switch (command) {
            //////////////////////////// Meniu principal ////////////////////////////
            case "Admin":
                applicationWindow.setVisible(false);
                applicationWindow.startAdminWindow();
                break;

            case "Client":
                applicationWindow.setVisible(false);
                applicationWindow.startClientWindow();
                break;

            //////////////////////////// Meniu logare ////////////////////////////
            case "Creare cont nou":
                cardLayout = (CardLayout) applicationWindow.getAdminWindow().adminMainPanel.loginPanels.getLayout();
                cardLayout.show(applicationWindow.getAdminWindow().adminMainPanel.loginPanels, "card2");
                break;

            case "Înapoi":
                cardLayout = (CardLayout) applicationWindow.getAdminWindow().adminMainPanel.loginPanels.getLayout();
                cardLayout.show(applicationWindow.getAdminWindow().adminMainPanel.loginPanels, "card1");
                break;

            case "Logare":
                cardLayout = (CardLayout) applicationWindow.getAdminWindow().adminMainPanel.getLayout();
                cardLayout.show(applicationWindow.getAdminWindow().adminMainPanel, "card2");
                break;

            case "ButonMeniuAdmin":

                cardLayout = (CardLayout) applicationWindow.getAdminWindow().adminMainPanel.rightSideAdminPanel.getLayout();
                javax.swing.JButton tmpJButton = (javax.swing.JButton)e.getSource();
                cardLayout.show(applicationWindow.getAdminWindow().adminMainPanel.rightSideAdminPanel, tmpJButton.getText());
                    
                break;
        }
    }

}
