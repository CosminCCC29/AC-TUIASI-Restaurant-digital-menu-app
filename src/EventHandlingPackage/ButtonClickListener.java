/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventHandlingPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mainpackage.ApplicationWindow;

/**
 *
 * @author cosmi
 */
public class ButtonClickListener implements ActionListener {

    private ApplicationWindow applicationWindow;
    
    ButtonClickListener(ApplicationWindow applicationWindow)
    {
        this.applicationWindow = applicationWindow;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        switch(command)
        {
            case "Admin":
                applicationWindow.setVisible(false);
                applicationWindow.startAdminWindow();
                break;
                
            case "Client":
                applicationWindow.setVisible(false);
                applicationWindow.startClientWindow();
                break;        
        }
    }
    
}
