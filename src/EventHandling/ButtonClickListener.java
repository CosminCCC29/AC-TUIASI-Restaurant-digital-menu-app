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
import mainpackage.ClientWindow;

/**
 * s
 *
 * @author cosmi
 */
public class ButtonClickListener implements ActionListener {

    private ApplicationWindow appWindow;
    
    ButtonClickListener(ApplicationWindow appWindow)
    {
        this.appWindow = appWindow;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        CardLayout cardLayout;
        
        switch(command)
        {
            case "Admin":
                appWindow.setVisible(false);
                appWindow.startAdminWindow();
                break;

            case "Client":
                appWindow.setVisible(false);
                appWindow.startClientWindow();
                break;

            //////////////////////////// Meniu logare ////////////////////////////
            case "Creare cont nou":
                cardLayout = (CardLayout) appWindow.getAdminWindow().adminMainPanel.loginPanels.getLayout();
                cardLayout.show(appWindow.getAdminWindow().adminMainPanel.loginPanels, "card2");
                break;

            case "Înapoi":
                cardLayout = (CardLayout) appWindow.getAdminWindow().adminMainPanel.loginPanels.getLayout();
                cardLayout.show(appWindow.getAdminWindow().adminMainPanel.loginPanels, "card1");
                break;

            case "Logare":
                cardLayout = (CardLayout) appWindow.getAdminWindow().adminMainPanel.getLayout();
                cardLayout.show(appWindow.getAdminWindow().adminMainPanel, "card2");
                break;

            case "ButonMeniuAdmin":
                cardLayout = (CardLayout) appWindow.getAdminWindow().adminMainPanel.rightSideAdminPanel.getLayout();
                javax.swing.JButton tmpJButton = (javax.swing.JButton)e.getSource();
                cardLayout.show(appWindow.getAdminWindow().adminMainPanel.rightSideAdminPanel, tmpJButton.getText());
                break;
                
            case "ButoaneMeniuriAdmin":
                appWindow.getAdminWindow().adminMainPanel.menusAdminPanel.startAction(e);
                break;
                
            case "SchimbarePanouMeniuClient":
                appWindow.clientWindow.startAction(e);
                break;
            case "Back":
                appWindow.clientWindow.BackFunction();
                break;
            case "vizualize":
                appWindow.clientWindow.vizualizeOrder(e);
                break;
            case "Add":
                appWindow.clientWindow.addProducts(e);
                break;
        }

    }

}
