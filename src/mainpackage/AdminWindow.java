package mainpackage;

import java.awt.*;

public class AdminWindow extends javax.swing.JFrame {

    private static AdminWindow adminWindow = null;

    public AdminWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        adminMainPanel = new javax.swing.JPanel();
        loginMainPanel = new javax.swing.JPanel();
        loginPanels = new javax.swing.JPanel();
        adminLoginPanel = new javax.swing.JPanel();
        idAdminTextField = new javax.swing.JTextField();
        numeContTextField = new javax.swing.JTextField();
        parolaContTextField = new javax.swing.JTextField();
        idAdminLabel = new javax.swing.JLabel();
        numeContLabel = new javax.swing.JLabel();
        parolaContLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        createNewAccountButton = new javax.swing.JButton();
        createAccountPanel = new javax.swing.JPanel();
        idAdminCATextField = new javax.swing.JTextField();
        idAdminCALabel = new javax.swing.JLabel();
        numeContCALabel = new javax.swing.JLabel();
        numeContCATextField = new javax.swing.JTextField();
        parolaContCAtLabel = new javax.swing.JLabel();
        parolaContCATextField = new javax.swing.JTextField();
        backCAButton = new javax.swing.JButton();
        createAccountButton = new javax.swing.JButton();
        parolaContCAtLabel1 = new javax.swing.JLabel();
        parolaContCATextField1 = new javax.swing.JTextField();
        adminMenuPanel = new javax.swing.JSplitPane();
        leftSideAdminPanel = new javax.swing.JPanel();
        menusAdminButton = new javax.swing.JButton();
        categoriesAdminButton = new javax.swing.JButton();
        productsAdminButton = new javax.swing.JButton();
        ingredientsAdminButton = new javax.swing.JButton();
        menusCategoriesAdminButton = new javax.swing.JButton();
        categoriesProductsAdminButton = new javax.swing.JButton();
        recipesAdminButton = new javax.swing.JButton();
        productTypeAdminButton = new javax.swing.JButton();
        ordersAdminButton = new javax.swing.JButton();
        rightSideAdminPanel = new javax.swing.JPanel();
        menusAdminPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        categoriesAdminPanel = new javax.swing.JPanel();
        productsAdminPanel = new javax.swing.JPanel();
        ingredientsAdminPanel = new javax.swing.JPanel();
        menusCategoriesAdminPanel = new javax.swing.JPanel();
        categoriesProductsAdminPanel = new javax.swing.JPanel();
        recipesAdminPanel = new javax.swing.JPanel();
        productTypeAdminPanel = new javax.swing.JPanel();
        ordersAdminPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fereastra Admin");

        adminMainPanel.setPreferredSize(new java.awt.Dimension(1280, 720));
        adminMainPanel.setLayout(new java.awt.CardLayout());

        loginMainPanel.setPreferredSize(new java.awt.Dimension(1280, 720));

        loginPanels.setBackground(new java.awt.Color(102, 0, 51));
        loginPanels.setLayout(new java.awt.CardLayout());

        adminLoginPanel.setBackground(new java.awt.Color(102, 51, 0));
        adminLoginPanel.setForeground(new java.awt.Color(102, 0, 51));

        idAdminTextField.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N

        numeContTextField.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        numeContTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeContTextFieldActionPerformed(evt);
            }
        });

        parolaContTextField.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N

        idAdminLabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        idAdminLabel.setForeground(new java.awt.Color(255, 255, 255));
        idAdminLabel.setText("ID ADMIN:");

        numeContLabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        numeContLabel.setForeground(new java.awt.Color(255, 255, 255));
        numeContLabel.setText("NUME CONT:");

        parolaContLabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        parolaContLabel.setForeground(new java.awt.Color(255, 255, 255));
        parolaContLabel.setText("PAROLA:");

        loginButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        loginButton.setText("Logare");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        createNewAccountButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        createNewAccountButton.setText("Creare cont nou");
        createNewAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewAccountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminLoginPanelLayout = new javax.swing.GroupLayout(adminLoginPanel);
        adminLoginPanel.setLayout(adminLoginPanelLayout);
        adminLoginPanelLayout.setHorizontalGroup(
            adminLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminLoginPanelLayout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addGroup(adminLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminLoginPanelLayout.createSequentialGroup()
                        .addGroup(adminLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeContLabel)
                            .addComponent(idAdminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(parolaContLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(adminLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(idAdminTextField)
                            .addComponent(numeContTextField)
                            .addComponent(parolaContTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(adminLoginPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(adminLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createNewAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(224, 224, 224))
        );
        adminLoginPanelLayout.setVerticalGroup(
            adminLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminLoginPanelLayout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(adminLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idAdminTextField)
                    .addComponent(idAdminLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(adminLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numeContTextField)
                    .addComponent(numeContLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(adminLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(parolaContTextField)
                    .addComponent(parolaContLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createNewAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );

        loginPanels.add(adminLoginPanel, "card1");

        createAccountPanel.setBackground(new java.awt.Color(102, 51, 0));
        createAccountPanel.setForeground(new java.awt.Color(102, 0, 51));

        idAdminCATextField.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N

        idAdminCALabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        idAdminCALabel.setText("ID ADMIN:");

        numeContCALabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        numeContCALabel.setText("NUME CONT:");

        numeContCATextField.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        numeContCATextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeContCATextFieldActionPerformed(evt);
            }
        });

        parolaContCAtLabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        parolaContCAtLabel.setText("PAROLA:");

        parolaContCATextField.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N

        backCAButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        backCAButton.setText("Înapoi");
        backCAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backCAButtonActionPerformed(evt);
            }
        });

        createAccountButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        createAccountButton.setText("Creare cont");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });

        parolaContCAtLabel1.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N
        parolaContCAtLabel1.setText("REPETA PAROLA:");

        parolaContCATextField1.setFont(new java.awt.Font("Segoe UI Historic", 0, 11)); // NOI18N

        javax.swing.GroupLayout createAccountPanelLayout = new javax.swing.GroupLayout(createAccountPanel);
        createAccountPanel.setLayout(createAccountPanelLayout);
        createAccountPanelLayout.setHorizontalGroup(
            createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAccountPanelLayout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createAccountPanelLayout.createSequentialGroup()
                        .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(parolaContCAtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numeContCALabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(createAccountPanelLayout.createSequentialGroup()
                                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idAdminCALabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(parolaContCAtLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)))
                        .addGap(32, 32, 32)
                        .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(idAdminCATextField)
                            .addComponent(numeContCATextField)
                            .addComponent(parolaContCATextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(parolaContCATextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(createAccountPanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backCAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(154, 154, 154))
        );
        createAccountPanelLayout.setVerticalGroup(
            createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAccountPanelLayout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idAdminCATextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idAdminCALabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeContCATextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeContCALabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parolaContCATextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(parolaContCAtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parolaContCATextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(parolaContCAtLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backCAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        loginPanels.add(createAccountPanel, "card2");

        javax.swing.GroupLayout loginMainPanelLayout = new javax.swing.GroupLayout(loginMainPanel);
        loginMainPanel.setLayout(loginMainPanelLayout);
        loginMainPanelLayout.setHorizontalGroup(
            loginMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginMainPanelLayout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(loginPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        loginMainPanelLayout.setVerticalGroup(
            loginMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginMainPanelLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(loginPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        adminMainPanel.add(loginMainPanel, "card1");

        adminMenuPanel.setDividerLocation(210);
        adminMenuPanel.setPreferredSize(new java.awt.Dimension(1280, 720));

        leftSideAdminPanel.setBackground(new java.awt.Color(102, 51, 0));
        leftSideAdminPanel.setLayout(new java.awt.GridBagLayout());

        menusAdminButton.setBackground(new java.awt.Color(204, 204, 204));
        menusAdminButton.setText("Meniuri");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        leftSideAdminPanel.add(menusAdminButton, gridBagConstraints);

        categoriesAdminButton.setText("Categorii");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        leftSideAdminPanel.add(categoriesAdminButton, gridBagConstraints);

        productsAdminButton.setText("Produse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        leftSideAdminPanel.add(productsAdminButton, gridBagConstraints);

        ingredientsAdminButton.setText("Ingrediente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        leftSideAdminPanel.add(ingredientsAdminButton, gridBagConstraints);

        menusCategoriesAdminButton.setText("Meniuri <-> Categorii");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        leftSideAdminPanel.add(menusCategoriesAdminButton, gridBagConstraints);

        categoriesProductsAdminButton.setText("Categorii <-> Produse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        leftSideAdminPanel.add(categoriesProductsAdminButton, gridBagConstraints);

        recipesAdminButton.setText("Retete");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        leftSideAdminPanel.add(recipesAdminButton, gridBagConstraints);

        productTypeAdminButton.setText("Tipuri aliment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        leftSideAdminPanel.add(productTypeAdminButton, gridBagConstraints);

        ordersAdminButton.setText("Comenzi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 49;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        leftSideAdminPanel.add(ordersAdminButton, gridBagConstraints);

        adminMenuPanel.setLeftComponent(leftSideAdminPanel);

        rightSideAdminPanel.setLayout(new java.awt.CardLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nume"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout menusAdminPanelLayout = new javax.swing.GroupLayout(menusAdminPanel);
        menusAdminPanel.setLayout(menusAdminPanelLayout);
        menusAdminPanelLayout.setHorizontalGroup(
            menusAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
        );
        menusAdminPanelLayout.setVerticalGroup(
            menusAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusAdminPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 533, Short.MAX_VALUE))
        );

        rightSideAdminPanel.add(menusAdminPanel, "card1");

        javax.swing.GroupLayout categoriesAdminPanelLayout = new javax.swing.GroupLayout(categoriesAdminPanel);
        categoriesAdminPanel.setLayout(categoriesAdminPanelLayout);
        categoriesAdminPanelLayout.setHorizontalGroup(
            categoriesAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        categoriesAdminPanelLayout.setVerticalGroup(
            categoriesAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        rightSideAdminPanel.add(categoriesAdminPanel, "card2");

        javax.swing.GroupLayout productsAdminPanelLayout = new javax.swing.GroupLayout(productsAdminPanel);
        productsAdminPanel.setLayout(productsAdminPanelLayout);
        productsAdminPanelLayout.setHorizontalGroup(
            productsAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        productsAdminPanelLayout.setVerticalGroup(
            productsAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        rightSideAdminPanel.add(productsAdminPanel, "card3");

        javax.swing.GroupLayout ingredientsAdminPanelLayout = new javax.swing.GroupLayout(ingredientsAdminPanel);
        ingredientsAdminPanel.setLayout(ingredientsAdminPanelLayout);
        ingredientsAdminPanelLayout.setHorizontalGroup(
            ingredientsAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        ingredientsAdminPanelLayout.setVerticalGroup(
            ingredientsAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        rightSideAdminPanel.add(ingredientsAdminPanel, "card4");

        javax.swing.GroupLayout menusCategoriesAdminPanelLayout = new javax.swing.GroupLayout(menusCategoriesAdminPanel);
        menusCategoriesAdminPanel.setLayout(menusCategoriesAdminPanelLayout);
        menusCategoriesAdminPanelLayout.setHorizontalGroup(
            menusCategoriesAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        menusCategoriesAdminPanelLayout.setVerticalGroup(
            menusCategoriesAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        rightSideAdminPanel.add(menusCategoriesAdminPanel, "card5");

        javax.swing.GroupLayout categoriesProductsAdminPanelLayout = new javax.swing.GroupLayout(categoriesProductsAdminPanel);
        categoriesProductsAdminPanel.setLayout(categoriesProductsAdminPanelLayout);
        categoriesProductsAdminPanelLayout.setHorizontalGroup(
            categoriesProductsAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        categoriesProductsAdminPanelLayout.setVerticalGroup(
            categoriesProductsAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        rightSideAdminPanel.add(categoriesProductsAdminPanel, "card6");

        javax.swing.GroupLayout recipesAdminPanelLayout = new javax.swing.GroupLayout(recipesAdminPanel);
        recipesAdminPanel.setLayout(recipesAdminPanelLayout);
        recipesAdminPanelLayout.setHorizontalGroup(
            recipesAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        recipesAdminPanelLayout.setVerticalGroup(
            recipesAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        rightSideAdminPanel.add(recipesAdminPanel, "card7");

        javax.swing.GroupLayout productTypeAdminPanelLayout = new javax.swing.GroupLayout(productTypeAdminPanel);
        productTypeAdminPanel.setLayout(productTypeAdminPanelLayout);
        productTypeAdminPanelLayout.setHorizontalGroup(
            productTypeAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        productTypeAdminPanelLayout.setVerticalGroup(
            productTypeAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        rightSideAdminPanel.add(productTypeAdminPanel, "card8");

        javax.swing.GroupLayout ordersAdminPanelLayout = new javax.swing.GroupLayout(ordersAdminPanel);
        ordersAdminPanel.setLayout(ordersAdminPanelLayout);
        ordersAdminPanelLayout.setHorizontalGroup(
            ordersAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        ordersAdminPanelLayout.setVerticalGroup(
            ordersAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        rightSideAdminPanel.add(ordersAdminPanel, "card9");

        adminMenuPanel.setRightComponent(rightSideAdminPanel);

        adminMainPanel.add(adminMenuPanel, "card2");

        getContentPane().add(adminMainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        CardLayout cardLayout = (CardLayout) adminMainPanel.getLayout();
        cardLayout.show(adminMainPanel, "card2");
    }//GEN-LAST:event_loginButtonActionPerformed

    private void createNewAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewAccountButtonActionPerformed
        CardLayout cardLayout = (CardLayout) loginPanels.getLayout();
        cardLayout.show(loginPanels, "card2");
    }//GEN-LAST:event_createNewAccountButtonActionPerformed

    private void numeContTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeContTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeContTextFieldActionPerformed

    private void numeContCATextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeContCATextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeContCATextFieldActionPerformed

    private void backCAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backCAButtonActionPerformed
        CardLayout cardLayout = (CardLayout) loginPanels.getLayout();
        cardLayout.show(loginPanels, "card1");
    }//GEN-LAST:event_backCAButtonActionPerformed

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createAccountButtonActionPerformed

    public static void startAdminWindow() {

        if (adminWindow == null) {

            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    adminWindow = new AdminWindow();
                    adminWindow.setVisible(true);
                }
            });
        }
    }

    public static AdminWindow getApplicationWindow() {
        return adminWindow;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminLoginPanel;
    private javax.swing.JPanel adminMainPanel;
    private javax.swing.JSplitPane adminMenuPanel;
    private javax.swing.JButton backCAButton;
    private javax.swing.JButton categoriesAdminButton;
    private javax.swing.JPanel categoriesAdminPanel;
    private javax.swing.JButton categoriesProductsAdminButton;
    private javax.swing.JPanel categoriesProductsAdminPanel;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JPanel createAccountPanel;
    private javax.swing.JButton createNewAccountButton;
    private javax.swing.JLabel idAdminCALabel;
    private javax.swing.JTextField idAdminCATextField;
    private javax.swing.JLabel idAdminLabel;
    private javax.swing.JTextField idAdminTextField;
    private javax.swing.JButton ingredientsAdminButton;
    private javax.swing.JPanel ingredientsAdminPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel leftSideAdminPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginMainPanel;
    private javax.swing.JPanel loginPanels;
    private javax.swing.JButton menusAdminButton;
    private javax.swing.JPanel menusAdminPanel;
    private javax.swing.JButton menusCategoriesAdminButton;
    private javax.swing.JPanel menusCategoriesAdminPanel;
    private javax.swing.JLabel numeContCALabel;
    private javax.swing.JTextField numeContCATextField;
    private javax.swing.JLabel numeContLabel;
    private javax.swing.JTextField numeContTextField;
    private javax.swing.JButton ordersAdminButton;
    private javax.swing.JPanel ordersAdminPanel;
    private javax.swing.JTextField parolaContCATextField;
    private javax.swing.JTextField parolaContCATextField1;
    private javax.swing.JLabel parolaContCAtLabel;
    private javax.swing.JLabel parolaContCAtLabel1;
    private javax.swing.JLabel parolaContLabel;
    private javax.swing.JTextField parolaContTextField;
    private javax.swing.JButton productTypeAdminButton;
    private javax.swing.JPanel productTypeAdminPanel;
    private javax.swing.JButton productsAdminButton;
    private javax.swing.JPanel productsAdminPanel;
    private javax.swing.JButton recipesAdminButton;
    private javax.swing.JPanel recipesAdminPanel;
    private javax.swing.JPanel rightSideAdminPanel;
    // End of variables declaration//GEN-END:variables
};
