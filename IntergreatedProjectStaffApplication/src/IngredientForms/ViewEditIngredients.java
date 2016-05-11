package IngredientForms;

import Classes.Ingredient;
import Classes.Supplier;
import Utilities.IntergratedProjectStaffApplication;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ViewEditIngredients extends javax.swing.JFrame {


    ArrayList<String> lstIngredientModel;
    ArrayList<Ingredient> originalIngredient = new ArrayList<>();
    ArrayList<Ingredient> searchedIngredient = new ArrayList<>();
    ArrayList<Supplier> supplierList = new ArrayList<>();
    Ingredient currentIngredient;
    boolean searchActivated = false;
    int currentSelection = 0;
    int radCurrentStock = 0;
    int radBuyLimit = 0;
    
    public ViewEditIngredients() {
        initComponents();
        formSetup();
    }

    public ViewEditIngredients(Supplier currentSupplier) {
        initComponents();
        formSetup();
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        btnClose1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSearchName = new javax.swing.JTextField();
        cboSearchSupplier = new javax.swing.JComboBox<>();
        txtSearchCurrentStock = new javax.swing.JTextField();
        txtSearchBuyLimit = new javax.swing.JTextField();
        radStockHigher = new javax.swing.JRadioButton();
        radStockLower = new javax.swing.JRadioButton();
        radLimitLower = new javax.swing.JRadioButton();
        radLimitHigher = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstIngredient = new javax.swing.JList<>();
        txtUnitValue = new javax.swing.JTextField();
        cboSupplier = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCurrentStock = new javax.swing.JTextField();
        txtCostPerUnit = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBuyLimit = new javax.swing.JTextField();
        btnAddIngredient = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnSearchSupplier = new javax.swing.JToggleButton();

        btnClose1.setText("Close");
        btnClose1.setToolTipText("");
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ingredients");

        jLabel2.setText("Name :");

        jLabel3.setText("Supplier :");
        jLabel3.setEnabled(false);

        jLabel4.setText("Current Stock (g, ml) :");

        jLabel5.setText("Buy Limit (g, ml) :");

        cboSearchSupplier.setMaximumRowCount(999);
        cboSearchSupplier.setEnabled(false);

        buttonGroup1.add(radStockHigher);
        radStockHigher.setSelected(true);
        radStockHigher.setText("Higher");

        buttonGroup1.add(radStockLower);
        radStockLower.setText("Lower");

        buttonGroup2.add(radLimitLower);
        radLimitLower.setText("Lower");

        buttonGroup2.add(radLimitHigher);
        radLimitHigher.setSelected(true);
        radLimitHigher.setText("Higher");

        lstIngredient.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstIngredient);

        jLabel6.setText("Cost per Unit (£) :");

        jLabel7.setText("Buy in Limit (g, ml) :");

        jLabel8.setText("Unit Value (g, ml) :");

        jLabel9.setText("Supplier :");

        jLabel10.setText("Name :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Ingredient Details");

        jLabel12.setText("Current Stock (g, ml) :");

        btnAddIngredient.setText("Add Ingredient");
        btnAddIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddIngredientActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnConfirm.setText("Confirm");
        btnConfirm.setToolTipText("");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.setToolTipText("");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.setToolTipText("");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSearchSupplier.setText("Search With Supplier");
        btnSearchSupplier.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSearchSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(cboSearchSupplier, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSearchName))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSearchCurrentStock, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                    .addComponent(txtSearchBuyLimit))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(radStockHigher)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radStockLower))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(radLimitHigher)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radLimitLower))
                                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtUnitValue)
                                                    .addComponent(txtCostPerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtName)
                                            .addComponent(cboSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtBuyLimit)
                                            .addComponent(txtCurrentStock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddIngredient)))
                                .addContainerGap(20, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnClose))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchCurrentStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radStockHigher)
                    .addComponent(radStockLower))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(cboSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchBuyLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radLimitHigher)
                    .addComponent(radLimitLower))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnSearchSupplier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cboSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtUnitValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCostPerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCurrentStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtBuyLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddIngredientActionPerformed
        if (Utilities.IntergratedProjectStaffApplication.addIngredient != null) {
            Utilities.IntergratedProjectStaffApplication.addIngredient.dispose();
        }
        Utilities.IntergratedProjectStaffApplication.addIngredient = new AddIngredient();
        Utilities.IntergratedProjectStaffApplication.addIngredient.setVisible(true);
    }//GEN-LAST:event_btnAddIngredientActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you wish to remove " + currentIngredient.getName() ,"Remove Ingredient", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            
            IntergratedProjectStaffApplication.JSPConnector.deleteIngredient(currentIngredient);
            
            originalIngredient.remove(currentIngredient);
            searchedIngredient.remove(currentIngredient);
            
            searchActivated = true;
            listLoad();
            
            Utilities.Utilities.infoBox("Ingredient removed : " + currentIngredient.getName(), "Ingredient Removed");
            lstIngredient.setSelectedIndex(0);
            }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        boolean validation;
        
        validation = Utilities.Utilities.nullCheck(txtName, "Name", "Name") && Utilities.Utilities.alphbetic(txtName.getText(), "", "") &&
                    Utilities.Utilities.nullCheck(txtUnitValue, "Unit Value", "Unit Value") && Utilities.Utilities.numericDecimal(txtUnitValue.getText(), "Unit Value", "Unit Value") &&
                    Utilities.Utilities.nullCheck(txtBuyLimit, "Buy Limit", "Buy Limit") && Utilities.Utilities.numericDecimal(txtBuyLimit.getText(), "Buy Limit", "Buy Limit") &&
                    Utilities.Utilities.nullCheck(txtCostPerUnit, "Cost Per Unit", "Cost Per Unit") && Utilities.Utilities.numericDecimal(txtCostPerUnit.getText(), "Cost Per Unit", "Cost Per Unit") &&
                    Utilities.Utilities.nullCheck(txtCurrentStock, "Current Stock", "Current Stock") && Utilities.Utilities.numericDecimal(txtCurrentStock.getText(), "Current Stock", "Current Stock");
        
        if (validation) {
            setCurrentIngredient();
            Utilities.IntergratedProjectStaffApplication.JSPConnector.updateIngredient(currentIngredient);
            
            searchActivated = true;
            listLoad();
            lstIngredient.setSelectedIndex(currentSelection);
            
            Utilities.Utilities.infoBox("Ingredient updated : " + currentIngredient.getName(), "Ingredient Updated");
        }
        
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose1ActionPerformed
    }//GEN-LAST:event_btnClose1ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        searchActivated = true;
        
        searchedIngredient.clear();
        
        String name = txtSearchName.getText();
        double currentStock = 0; //0 is empty value
        if (!txtSearchCurrentStock.getText().isEmpty())
            currentStock = Double.parseDouble(txtSearchCurrentStock.getText());
        
        double buyLimit = 0; //0 is empty value
        if (!txtSearchBuyLimit.getText().isEmpty())
            buyLimit = Double.parseDouble(txtSearchBuyLimit.getText());
        
        int supplier = supplierList.get(cboSupplier.getSelectedIndex()).getSupplierID();
        
        for (Ingredient ingredient : originalIngredient) {
            if ((name.isEmpty() || name.equalsIgnoreCase(ingredient.getName())) &&
                    (!btnSearchSupplier.isSelected() || (ingredient.getSupplierID() == supplier && btnSearchSupplier.isSelected())) &&
                    (currentStock == 0 || (ingredient.getCurrentStock() >= currentStock && radStockHigher.isSelected()) ||
                    (ingredient.getCurrentStock() <= currentStock && radStockLower.isSelected()) ) &&
                    (buyLimit == 0 || (ingredient.getBuyInLimit() >= currentStock && radLimitHigher.isSelected()) ||
                    (ingredient.getBuyInLimit() <= currentStock && radLimitLower.isSelected()))) {
                searchedIngredient.add(ingredient);
            }
        }
        
        //display message for no results
        if (searchedIngredient.isEmpty()) {
            for (Ingredient ingredient : originalIngredient) {
                searchedIngredient.add(ingredient);
            }
            txtSearchName.setText("");
            txtSearchBuyLimit.setText("");
            txtSearchCurrentStock.setText("");
            Utilities.Utilities.infoBox("No matching results - Resetting List", "Search results");
        }
        
        listLoad();
        lstIngredient.setSelectedIndex(0);        
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewEditIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEditIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEditIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEditIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEditIngredients().setVisible(true);
            }
        });
    }
    
    public void formSetup() {
        originalIngredient = Utilities.IntergratedProjectStaffApplication.JSPConnector.getAllIngredient();
        supplierList = Utilities.IntergratedProjectStaffApplication.JSPConnector.getAllSupplier();
        populateComboBox();
        for (Ingredient ingredient : originalIngredient) {
            searchedIngredient.add(ingredient);
        }
        listLoad();
        if (!searchedIngredient.isEmpty()) {
            lstIngredient.setSelectedIndex(0);
            setCurrentIngredientBox();
        }        
        
        setEventListeners();
    }
    
        public void listLoad() {
        
        lstIngredient.removeAll();
        
        if (!searchedIngredient.isEmpty()) {
            lstIngredientModel = new ArrayList<>();        
            String[] ingredientListArray;
            for (Ingredient ingredient : searchedIngredient) {
                lstIngredientModel.add(ingredient.getName());
                ingredientListArray = lstIngredientModel.toArray(new String[0]);
                lstIngredient.setListData(ingredientListArray); //set list
            }      
        }
    }
        
    public void setEventListeners() {
        lstIngredient.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!searchActivated) //this check only allows the action to take place when manually changed,
                    setCurrentIngredientBox(); // not when the list repopulates calling the listener
                else
                    searchActivated = false;
                currentSelection = lstIngredient.getSelectedIndex();
            }
        });
    }
    
    public void setCurrentIngredientBox() {        
        currentIngredient = searchedIngredient.get(lstIngredient.getSelectedIndex());
        txtName.setText(currentIngredient.getName());
        txtUnitValue.setText(String.valueOf(currentIngredient.getUnitValue()));
        txtCostPerUnit.setText(String.valueOf(currentIngredient.getCostPerUnit()));
        txtCurrentStock.setText(String.valueOf(currentIngredient.getCurrentStock()));
        txtBuyLimit.setText(String.valueOf(currentIngredient.getBuyInLimit()));
        
        for (Supplier supplier : supplierList) {
            if (supplier.getSupplierID() == currentIngredient.getSupplierID()) {
                cboSupplier.setSelectedIndex(supplierList.indexOf(supplier));
            }
        }        
    }
    
    public void setCurrentIngredient() {
        currentIngredient.setName(txtName.getText());
        currentIngredient.setBuyInLimit(Double.parseDouble(txtBuyLimit.getText()));
        currentIngredient.setCostPerUnit(Double.parseDouble(txtCostPerUnit.getText()));
        currentIngredient.setCurrentStock(Double.parseDouble(txtCurrentStock.getText()));
        currentIngredient.setUnitValue(Double.parseDouble(txtUnitValue.getText()));
        currentIngredient.setSupplierID(supplierList.get(cboSupplier.getSelectedIndex()).getSupplierID());
    }
    
    public void populateComboBox() {
        for (Supplier supplier : supplierList) {
            cboSupplier.addItem(supplier.getSupplierID() + " : " + supplier.getSupplierName());
            cboSearchSupplier.addItem(supplier.getSupplierID() + " : " + supplier.getSupplierName());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddIngredient;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnClose1;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JToggleButton btnSearchSupplier;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboSearchSupplier;
    private javax.swing.JComboBox<String> cboSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> lstIngredient;
    private javax.swing.JRadioButton radLimitHigher;
    private javax.swing.JRadioButton radLimitLower;
    private javax.swing.JRadioButton radStockHigher;
    private javax.swing.JRadioButton radStockLower;
    private javax.swing.JTextField txtBuyLimit;
    private javax.swing.JTextField txtCostPerUnit;
    private javax.swing.JTextField txtCurrentStock;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearchBuyLimit;
    private javax.swing.JTextField txtSearchCurrentStock;
    private javax.swing.JTextField txtSearchName;
    private javax.swing.JTextField txtUnitValue;
    // End of variables declaration//GEN-END:variables
}
