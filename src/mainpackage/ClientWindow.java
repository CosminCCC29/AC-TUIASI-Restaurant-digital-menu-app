package mainpackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ButtonType;
import javax.swing.*;
import mainpackage.ClientWindowPanels.BauturiPanel;

public class ClientWindow extends javax.swing.JFrame {
    
    
    private ApplicationWindow appWindow;
    public ArrayList<ArrayList<String>> produseleMele = new ArrayList<>();  
    public PreparedStatement selectProduct;
    
    BauturiPanel bauturiPanel = new BauturiPanel();    
    GridBagLayout layout = new GridBagLayout();
    
    public ClientWindow(ApplicationWindow appWindow) {
        
        this.appWindow = appWindow;
        initComponents();
        int ct=0;
             
        try {
            Connection conn = appWindow.getDataBaseConnection().getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nume_categorie FROM CATEGORII WHERE Meniuri_nr_meniu = 1");
            selectProduct = conn.prepareStatement("SELECT p.nume_produs, p.pret FROM Categorii c, Produse p, categorii_produse cp  WHERE c.nume_categorie = ? AND c.Meniuri_nr_meniu = 1 AND p.nr_produs = cp.Produse_nr_produs AND c.nr_categorie = cp.Categorii_nr_categorie");
            
            while(rs.next())
            {
                //button settings
                //
                
                String buttonText = rs.getString(1);
                
                selectProduct.setString(1, buttonText);
                ResultSet rs2 = selectProduct.executeQuery();

                JButton btn= new JButton();
                btn.setText(buttonText);
                btn.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                btn.setActionCommand("SchimbarePanouMeniuClient");
                
                GridBagConstraints gridBagConstraints;  
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.fill = GridBagConstraints.BOTH;
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = ct++;
                gridBagConstraints.ipadx = 32;
                gridBagConstraints.ipady = 27;
                CtgPanel.setBackground(new Color(174, 40, 37));
                CtgPanel.add(btn, gridBagConstraints);
                         
                //panel settings
                ////////////////
                // VARIABILA panel REPREZINTA PANELUL ADAUGAT IN DYNAMIC PANEL SI IN CARE SE VOR ADAUGA PRODUSELE
                
                JPanel panel = new JPanel();      
                panel.setBackground(new Color(201, 184, 56));
                panel.setName(btn.getText());                   
                DynamicPanel.add(panel,btn.getText());
                
                //PANEL CARE CONTINE FIECARE PRODUS
                /////////////////////////////////////
                while(rs2.next())
                {
                    String nume_produs = rs2.getString(1);
                    String pret = rs2.getString(2);
                    
                    //ADAUGARE PANEL PENTRU FIECARE PRODUS DIN CATEGORIA SELECTATA
                    
                    JPanel produsPanel = new JPanel(new BorderLayout());
                    produsPanel.setPreferredSize(new Dimension(300,250));
                    produsPanel.setBackground(new Color(180,114,71));
                    produsPanel.setName(nume_produs);
                    panel.add(produsPanel,nume_produs);
                    ///////////////////////////////////
                    
                    
                    //ADAUGARE TEXT AREA IN FIECARE PANEL AL UNUI PRODUS
                    
                    JTextArea descriereProdus = new javax.swing.JTextArea();
                    descriereProdus.setBounds(0,75,250,75);
                    descriereProdus.setColumns(10);
                    descriereProdus.setRows(3);
                    descriereProdus.setVisible(true);                 
                    descriereProdus.setText(nume_produs+" - "+pret+" lei");
                    descriereProdus.setFont(new Font("TimesRoman",Font.PLAIN,16));                  
                    descriereProdus.setLineWrap(true);
                    descriereProdus.setEditable(false);   
                    produsPanel.add(descriereProdus,BorderLayout.CENTER);
                    
                    ////////////////////////////////////////////////////
                    
                    //ADAUGAREA UNEI POZE PENTRU PRODUS
                    
                    JLabel foodPicture = new javax.swing.JLabel();
                    foodPicture.setBackground(new Color(255, 255, 255));
                    foodPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    foodPicture.setSize(new Dimension(200,150)); 
                    ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("/Poze/"+nume_produs+".jpg")).getImage().getScaledInstance(foodPicture.getWidth(), foodPicture.getHeight(), Image.SCALE_SMOOTH));
                    foodPicture.setIcon(img);
                    foodPicture.setVerifyInputWhenFocusTarget(false);
                    produsPanel.add(foodPicture, BorderLayout.NORTH);
    
                    ///////////////////////////////////
                    
                    //ADAUGARE BUTON ADD FIECARUI PRODUS
                    JButton button= new JButton("Add");
                    button.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                    button.setActionCommand("Add");
               
                    gridBagConstraints = new java.awt.GridBagConstraints();
                    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                    gridBagConstraints.gridx = 0;
                    gridBagConstraints.gridy = ct;
                    gridBagConstraints.ipadx = 75;
                    gridBagConstraints.ipady = 160;
                    produsPanel.add(button, BorderLayout.EAST);
                    
                    /////////////////////////////////////////
                                      
                    ///ADAUGAREA BUTOANE + - PENTRU SELECTAREA CANTITATII DIN FIECARE PRODUS
                    JPanel numarProdusePanel = new JPanel(new BorderLayout());
                    JButton leftB = new JButton("-");
                    JButton leftR = new JButton("+");
                    leftB.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                    leftR.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                    leftB.setActionCommand("MINUS");
                    leftR.setActionCommand("PLUS");
                    JTextField numarProduseTextField = new JTextField("0");
                    numarProduseTextField.setEditable(false);
                    
                    numarProdusePanel.add(leftB, BorderLayout.WEST);
                    numarProdusePanel.add(numarProduseTextField, BorderLayout.CENTER);
                    numarProdusePanel.add(leftR, BorderLayout.EAST);
                    
                    produsPanel.add(numarProdusePanel, BorderLayout.SOUTH);
                }
            }
            
            //ADAUGARE BUTON PENTRU FINALIZARE COMANDA
            
            javax.swing.JButton button= new JButton();
                button.setText("Vizualizare Comanda");
                java.awt.GridBagConstraints gridBagConstraints;
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.fill = GridBagConstraints.BOTH;
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = ct++;
                gridBagConstraints.ipadx = 32;
                gridBagConstraints.ipady = 27;
                CtgPanel.add(button, gridBagConstraints);
                button.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                button.setActionCommand("vizualize");
            
            //////////////////////////////////////////
            
            //ADAUGARE BUTON DE BACK DIN MENIUL CLIENT IN CEL DE PORNIRE
            javax.swing.JButton button1= new JButton();
                button1.setText("Back");
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.fill = GridBagConstraints.BOTH;
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

    public void increaseTextArea(ActionEvent e)
    {
        JButton tmpJButton = (JButton)e.getSource();
        Component[] components = tmpJButton.getParent().getComponents();
        JTextField textField = new JTextField();
        textField = (JTextField)components[1];
        int i=Integer.parseInt(textField.getText());
        String s=String.valueOf(i+1);
        textField.setText(s);
    }
    
    public void decreaseTextArea(ActionEvent e)
    {
        JButton tmpJButton = (JButton)e.getSource();
        Component[] components = tmpJButton.getParent().getComponents();
        JTextField textField = new JTextField();
        textField = (JTextField)components[1];
        
        int i=Integer.parseInt(textField.getText());
        String s="";
        if(i>0)
        {
            s=String.valueOf(i-1);
        }
        else
        {
            s="0";
        }
        textField.setText(s);
    }
       
    public void finalizeOrder(ActionEvent e)
    {
        try {
            Connection conn = appWindow.getDataBaseConnection().getConnection();
            int index = 1;
            String str = "BEGIN\n" +
                        "\n" +
                        "DECLARE\n" +
                        "    produse_comandate produse_comenzi.nr_produse_comandate%TYPE;\n" +
                        "    produs_in_reteta Ingrediente.id_ingredient%TYPE;\n" +
                        "    produs_in_stoc stocuri_produs.stoc_produs%TYPE;\n" +
                        "BEGIN\n" +
                        "\n" +
                        "    INSERT INTO Comenzi(id_comanda, data_comanda, nr_masa) VALUES(NULL,SYSDATE,3);\n";
            
            for(int i = 0; i< produseleMele.size() ; i++)
                {
                    str = str +  
                        "    BEGIN\n" +
                        "        produse_comandate := ?;\n" +
                        "        INSERT INTO produse_comenzi(nr_produse_comandate, Produse_nr_produs, Comenzi_id_comanda) VALUES(produse_comandate, (SELECT nr_produs FROM Produse WHERE nume_produs = ?), (SELECT MAX(id_comanda) FROM Comenzi));\n" +
                        "\n" +
                        "        SELECT COUNT(Produse_nr_produs) INTO produs_in_reteta FROM Retete r WHERE r.Produse_nr_produs = (SELECT nr_produs FROM Produse WHERE nume_produs = ?);\n" +
                        "        SELECT COUNT(Produse_nr_produs) INTO produs_in_stoc FROM stocuri_produs sp WHERE sp.Produse_nr_produs = (SELECT nr_produs FROM Produse WHERE nume_produs = ?);\n" +
                        "\n" +
                        "        IF (produs_in_reteta > 0) THEN\n" +
                        "            UPDATE Ingrediente i\n" +
                        "            SET stoc_ingredient = stoc_ingredient - produse_comandate * (SELECT r.cantitate_ingredient FROM Retete r WHERE r.Produse_nr_produs = (SELECT nr_produs FROM Produse WHERE nume_produs = ?) and r.Ingrediente_id_ingredient = i.id_ingredient)\n" +
                        "            WHERE EXISTS (SELECT 1 FROM Retete r WHERE Produse_nr_produs = (SELECT nr_produs FROM Produse WHERE nume_produs = ?) and r.Ingrediente_id_ingredient = i.id_ingredient);\n" +
                        "        ELSIF (produs_in_stoc > 0) THEN\n" +
                        "            UPDATE stocuri_produs sp\n" +
                        "            SET stoc_produs = stoc_produs - produse_comandate\n" +
                        "            WHERE sp.Produse_nr_produs = (SELECT nr_produs FROM Produse WHERE nume_produs = ?);\n" +
                        "        END IF;\n" +
                        "    END;\n";
            }
            str = str +"END;\n"+
                        "END;";
            selectProduct = conn.prepareStatement(str);
            for(int i = 0; i< produseleMele.size() ; i++)
            {
                String nume = produseleMele.get(i).get(0);
                String cantitate = produseleMele.get(i).get(2);
                if(index % 7 == 1)
                        selectProduct.setString(index, cantitate);
                selectProduct.setString(index+1, nume);
                selectProduct.setString(index+2, nume);
                selectProduct.setString(index+3, nume);
                selectProduct.setString(index+4, nume);
                selectProduct.setString(index+5, nume);
                selectProduct.setString(index+6, nume);
                index += 7;
            }
            
            ResultSet rs = selectProduct.executeQuery();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void vizualizeOrder(ActionEvent e)
    {
        int costComanda = 0;
        int par=1;
        JPanel commandPanel = new JPanel(new BorderLayout());
                
        commandPanel.setBackground(new Color(115,89,105));
        commandPanel.setName("Finalizare Comanda");
        commandPanel.setVisible(true);
        DynamicPanel.add(commandPanel,"Finalizare comanda");
        
        JLabel foodPicture = new JLabel();
        JLabel foodPicture2 = new JLabel();
        
        foodPicture.setBackground(new Color(255, 255, 255));
        foodPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Poze/food1.png"))); // NOI18N
        foodPicture.setVerifyInputWhenFocusTarget(false);
        commandPanel.add(foodPicture, BorderLayout.NORTH);
        
        foodPicture2.setBackground(new Color(255, 255, 255));
        foodPicture2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodPicture2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Poze/food1.png"))); // NOI18N
        foodPicture2.setVerifyInputWhenFocusTarget(false);
        commandPanel.add(foodPicture2, BorderLayout.SOUTH);
        
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
            int pret = 0;
            for(String str:list)
            {
                if(par % 3 ==1 )
                {
                    jTextArea1.append(">>> ");
                    jTextArea1.append(str+"              ");
                }
                if(par % 3 == 2)
                {
                    int i=Integer.parseInt(str);
                    pret=i;
                    jTextArea1.append(str+" lei");
                }
                if(par % 3 == 0)
                {
                    int i=Integer.parseInt(str);
                    costComanda = costComanda + pret *i;
                    jTextArea1.append("  x  "+str+"\n");
                }
                par++;
            }
        }
        jTextArea1.append("\nCost total comanda: "+costComanda+" lei\n");
        
        jTextArea1.setFont(new Font("TimesRoman",Font.PLAIN,16));
                    
        jTextArea1.setLineWrap(true);
        jTextArea1.setEditable(false);
                    
        commandPanel.add(jScrollPane2,BorderLayout.CENTER);
        
        //ADAUGARE BUTON PENTRU FINALIZARE COMANDA
            
            JButton button= new JButton();
                button.setText("Finalizare Comanda");
                GridBagConstraints gridBagConstraints;
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.fill = GridBagConstraints.BOTH;
                gridBagConstraints.gridx = 5;
                gridBagConstraints.gridy = 6;
                gridBagConstraints.ipadx = 32;
                gridBagConstraints.ipady = 27;
                button.setSize(new Dimension(20,20));
                commandPanel.add(button,BorderLayout.WEST);
                button.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                button.setActionCommand("finalize");
               
        //////////////////////////////////////////
        
        //ADAUGARE BUTON PENTRU GOLIRE COS COMANDA
            
            JButton emptyButton= new JButton();
                emptyButton.setText("Golire Cos");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.fill = GridBagConstraints.BOTH;
                gridBagConstraints.gridx = 6;
                gridBagConstraints.gridy = 7;
                gridBagConstraints.ipadx = 32;
                gridBagConstraints.ipady = 27;
                emptyButton.setSize(new Dimension(20,20));
                commandPanel.add(emptyButton,BorderLayout.EAST);
                emptyButton.addActionListener(appWindow.getAppActionListener().getButtonClickListener());
                emptyButton.setActionCommand("emptyOrder");
               
        //////////////////////////////////////////
        
        CardLayout cardLayout;
        cardLayout = (CardLayout) DynamicPanel.getLayout();
        cardLayout.show(DynamicPanel, "Finalizare comanda");

    }
    
    public void emptyOrderBag()
    {
        produseleMele.removeAll(produseleMele);
    }
    
    public void BackFunction()
    {
        this.setVisible(false);
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
        JButton tmpJButton = (JButton)e.getSource();
        
        Component[] components = tmpJButton.getParent().getComponents();
        
        //DEPLASARE PRIN COMPONENTELE PRODUSULUI MEU
        JPanel panouJPanel = new JPanel();
        panouJPanel = (JPanel)components[3];
        components = panouJPanel.getComponents();
        
        //DEPLASARE PRIN ELEMENTELE DIN PANELUL CARE FACE PARTE DIN PRODUSUL MEU
        JTextField textField = new JTextField();
        textField = (JTextField)components[1];
        int ct=Integer.parseInt(textField.getText());
        
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
                String a[] = new String[] { tmpJButton.getParent().getName(),y,String.valueOf(ct)};
                
                int ok = 1;
                int index = 0;
                for(int i = 0; i< produseleMele.size() ; i++)
                {
                    if(produseleMele.get(i).get(0) == a[0])
                    {
                        ok = 0;
                        index = i;
                    }
                }
                if(ok==1)
                    produseleMele.add(new ArrayList<String>(Arrays.asList(a)));
                else
                {
                    produseleMele.set(index, new ArrayList<String>(Arrays.asList(a)));
                }
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
