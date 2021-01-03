package mainpackage;

import EventHandling.AppActionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import mainpackage.ClientWindowPanels.BauturiPanel;
import oracle.jpub.runtime.MutableArray;

public class ClientWindow extends javax.swing.JFrame {
    
    
    private ApplicationWindow appWindow;
    
    public ArrayList<ArrayList<String>> produseleMele = new ArrayList<ArrayList<String>>();
    
    public PreparedStatement selectProduct;
    
    BauturiPanel bauturiPanel = new BauturiPanel();
     
    GridBagLayout layout = new GridBagLayout();
    
    public ClientWindow(ApplicationWindow appWindow) {
        
        this.appWindow = appWindow;
        initComponents();
        int ct=3;
     
        
        
        try {
            Connection conn = appWindow.getDataBaseConnection().getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nume_categorie FROM CATEGORII WHERE Meniuri_nr_meniu=1");
            String str = "SELECT p.nume_produs, p.pret FROM Categorii c, Produse p, categorii_produse cp  WHERE c.nume_categorie = ? AND c.Meniuri_nr_meniu = 1 AND p.nr_produs = cp.Produse_nr_produs AND c.nr_categorie = cp.Categorii_nr_categorie";
            selectProduct = conn.prepareStatement(str);
            
            while(rs.next())
            {
                //button settings
                //
                
                javax.swing.JButton btn= new JButton();
                String x = rs.getString(1);
                
                selectProduct.setString(1, x);
                ResultSet rs2 = selectProduct.executeQuery();
                System.out.println("Produsele din categoria "+x+" sunt:");
              
                System.out.println("\n\n");
                
                btn.setText(x);
                
                java.awt.GridBagConstraints gridBagConstraints;
               
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = ct;
                gridBagConstraints.ipadx = 32;
                gridBagConstraints.ipady = 27;
                CtgPanel.add(btn, gridBagConstraints);
                ct++;
                
                btn.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                btn.setActionCommand("Geeks");
                
                
                //panel settings
                ////////////////
                // VARIABILA panel REPREZINTA PANELUL ADAUGAT IN DYNAMIC PANEL SI IN CARE SE VOR ADAUGA PRODUSELE
                
                JPanel panel = new JPanel();
                
                panel.setBackground(Color.yellow);
                panel.setName(btn.getText());
                              
                DynamicPanel.add(panel,btn.getText());
                
                //PANEL CARE CONTINE FIECARE PRODUS
                /////////////////////////////////////
                while(rs2.next())
                {
                    String y = rs2.getString(1);
                    String z = rs2.getString(2);
                    
                    //ADAUGARE PANEL PENTRU FIECARE PRODUS DIN CATEGORIA SELECTATA
                    
                    JPanel produsPanel = new JPanel(new BorderLayout());

                    produsPanel.setPreferredSize(new Dimension(250,150));
                    produsPanel.setBackground(Color.BLUE);
                    produsPanel.setName(y);
                    panel.add(produsPanel,y);
                    
                    ///////////////////////////////////
                    
                    
                    //ADAUGARE TEXT AREA IN FIECARE PANEL AL UNUI PRODUS
                    
                    JTextArea jTextArea1 = new javax.swing.JTextArea();
                    jTextArea1.setBounds(0,75,250,75);

                    jTextArea1.setColumns(10);
                    jTextArea1.setRows(3);
                    jTextArea1.setVisible(true);
                    
                    jTextArea1.setText(y+" >>> "+z+" lei");
                    jTextArea1.setFont(new Font("TimesRoman",Font.PLAIN,16));
                    
                    jTextArea1.setLineWrap(true);
                    jTextArea1.setEditable(false);
                    
                       
                    produsPanel.add(jTextArea1,BorderLayout.SOUTH);
                    
                    ////////////////////////////////////////////////////
                    
                    
                    //ADAUGAREA UNEI POZE PENTRU PRODUS
                    
                    JLabel foodPicture = new javax.swing.JLabel();
                    ImageIcon myfood = new ImageIcon("/Poze/food1.png");
                    
                    foodPicture.setBackground(new java.awt.Color(255, 255, 255));
                    foodPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    foodPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Poze/apa_plata.jpg"))); // NOI18N
                    foodPicture.setVerifyInputWhenFocusTarget(false);
                    produsPanel.add(foodPicture);
                    
                    
                    ///////////////////////////////////
                    
                    //ADAUGARE BUTON ADD FIECARUI PRODUS
                    javax.swing.JButton button= new JButton();
                    button.setText("Add");
               
                    gridBagConstraints = new java.awt.GridBagConstraints();
                    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy = ct;
                    gridBagConstraints.ipadx = 75;
                    gridBagConstraints.ipady = 160;
                    produsPanel.add(button, BorderLayout.LINE_END);
                    button.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                    button.setActionCommand("Add");
                    /////////////////////////////////////////
                    
                }
            }
            
            //ADAUGARE BUTON PENTRU FINALIZARE COMANDA
            
            javax.swing.JButton button= new JButton();
                button.setText("Vizualizare Comanda");
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = ct;
                gridBagConstraints.ipadx = 32;
                gridBagConstraints.ipady = 27;
                CtgPanel.add(button, gridBagConstraints);
                button.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                button.setActionCommand("vizualize");
                ct++;
            
            //////////////////////////////////////////
            
            //ADAUGARE BUTON DE BACK DIN MENIUL CLIENT IN CEL DE PORNIRE
            javax.swing.JButton button1= new JButton();
                button1.setText("Back");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = ct;
                gridBagConstraints.ipadx = 32;
                gridBagConstraints.ipady = 27;
                CtgPanel.add(button1, gridBagConstraints);
                button1.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                button1.setActionCommand("Back");
            
            /////////////////////////////////////////////////////////////
            
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void vizualizeOrder(ActionEvent e)
    {
        int costComanda = 0;
        int par=1;
        JPanel commandPanel = new JPanel(new GridBagLayout());
                
        commandPanel.setBackground(Color.RED);
        commandPanel.setName("Finalizare Comanda");
        commandPanel.setVisible(true);
        DynamicPanel.add(commandPanel,"Finalizare comanda");
        
        
        //Adaugare text box in vizualizare comanda
        JTextArea jTextArea1 = new javax.swing.JTextArea();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1.setBounds(0,0,1000,1000);
        jScrollPane2.setBounds(0, 0, 400, 400);
        
        jScrollPane2.setPreferredSize(new Dimension(500,500));
                    
        jTextArea1.setColumns(10);
        jTextArea1.setRows(3);
        jTextArea1.setVisible(true);
        jScrollPane2.setViewportView(jTextArea1);
        
        for(ArrayList<String> list:produseleMele)
        {
            for(String str:list)
            {
                if(par % 2 ==1 )
                {
                    jTextArea1.append(">>> ");
                }
                jTextArea1.append(str+"              ");
                if(par % 2 == 0)
                {
                    int i=Integer.parseInt(str);
                    costComanda = costComanda + i;
                    jTextArea1.append("\n");
                }
                par++;
            }
        }
        jTextArea1.append("\nCost total comanda: "+costComanda+" lei\n");
        
        jTextArea1.setFont(new Font("TimesRoman",Font.PLAIN,16));
                    
        jTextArea1.setLineWrap(true);
        jTextArea1.setEditable(false);
                    
                       
        //commandPanel.add(jTextArea1,BorderLayout.CENTER);
        commandPanel.add(jScrollPane2);
        
        //ADAUGARE BUTON PENTRU FINALIZARE COMANDA
            
            javax.swing.JButton button= new JButton();
                button.setText("Finalizare Comanda");
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.gridx = 5;
                gridBagConstraints.gridy = 5;
                gridBagConstraints.ipadx = 32;
                gridBagConstraints.ipady = 27;
                button.setSize(new Dimension(20,20));
                commandPanel.add(button,gridBagConstraints);
                button.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                button.setActionCommand("finalize");
               
        //////////////////////////////////////////
        
        CardLayout cardLayout;
        cardLayout = (CardLayout) DynamicPanel.getLayout();
        cardLayout.show(DynamicPanel, "Finalizare comanda");
        
        displayOrder();
        
    }
    
    public void displayOrder()
    {
        System.out.println("\n\n\n\n");
        for(ArrayList<String> list:produseleMele)
        {
            for(String str:list)
            {
                System.out.println(str);
            }
        }
    }
    
    public void BackFunction()
    {
        System.out.println("Buton de back");
        appWindow.stopClientWindow();
        appWindow = new ApplicationWindow();
        appWindow.setVisible(true);     
    }

    public void startAction(ActionEvent e)
    {
        CardLayout cardLayout;
        cardLayout = (CardLayout) DynamicPanel.getLayout();
        javax.swing.JButton tmpJButton = (javax.swing.JButton)e.getSource();
        cardLayout.show(DynamicPanel, tmpJButton.getText());
    }
    
    public void addProducts(ActionEvent e)
    {
        javax.swing.JButton tmpJButton = (javax.swing.JButton)e.getSource();
        System.out.println(tmpJButton.getParent().getName());
        
        
        try {
            Connection conn = appWindow.getDataBaseConnection().getConnection();
            Statement st = conn.createStatement();
            String str = "SELECT p.pret FROM Produse p WHERE p.nume_produs = ?";
            selectProduct = conn.prepareStatement(str);
            selectProduct.setString(1,tmpJButton.getParent().getName());
            ResultSet rs = selectProduct.executeQuery();
            while(rs.next())
            {
                String y = rs.getString(1);
                produseleMele.add(new ArrayList<String>(Arrays.asList(tmpJButton.getParent().getName(),y)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        CtgPanel = new javax.swing.JPanel();
        DynamicPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fereastra meniu client");

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CtgPanel.setBackground(new java.awt.Color(204, 51, 0));
        CtgPanel.setLayout(new java.awt.GridBagLayout());
        mainPanel.add(CtgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, -1));

        DynamicPanel.setBackground(new java.awt.Color(204, 153, 0));
        DynamicPanel.setLayout(new java.awt.CardLayout());
        mainPanel.add(DynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 0, 1260, 720));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CtgPanel;
    public javax.swing.JPanel DynamicPanel;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
