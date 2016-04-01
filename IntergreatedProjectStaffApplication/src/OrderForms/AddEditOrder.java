package OrderForms;

import Classes.Ingredient;
import Classes.OrderStock;
import Classes.Orders;
import Classes.Supplier;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddEditOrder extends javax.swing.JFrame {


    ArrayList<Supplier> suppliers = new ArrayList<>();
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    ArrayList<Boolean> orderDone = new ArrayList<>();
    ArrayList<OrderStock> newStock = new ArrayList<>();
    Supplier currentSupplier;
    Orders order = null;
    DefaultTableModel tableModel;
    int addEdit = 0; //default to add
    
    public AddEditOrder(Orders order) {
        initComponents();
        addEdit = 1;
        this.order = order;
        txtDate.setText(String.valueOf(order.getDateEstimateArrival()));
        setupForm();
    }

    public AddEditOrder() {
        initComponents();
        setupForm();
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnAddToOrder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboSupplier = new javax.swing.JComboBox<>();
        txtDate = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        pnlTable = new javax.swing.JPanel();
        lblOrderDone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Order");

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnOrder.setText("Confirm");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnAddToOrder.setText("Add Item to Order");
        btnAddToOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToOrderActionPerformed(evt);
            }
        });

        jLabel2.setText("Supplier :");

        cboSupplier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSupplierItemStateChanged(evt);
            }
        });

        jLabel3.setText("Estimated Arrival :");

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboSupplier, 0, 135, Short.MAX_VALUE)
                            .addComponent(txtDate))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddToOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblOrderDone))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnOrder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddToOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderDone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnAddToOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToOrderActionPerformed
        if (Utilities.IntergratedProjectStaffApplication.addToOrder != null) {
            Utilities.IntergratedProjectStaffApplication.addToOrder.dispose();
        }
        Utilities.IntergratedProjectStaffApplication.addToOrder = new AddToOrder(currentSupplier);
        Utilities.IntergratedProjectStaffApplication.addToOrder.setVisible(true);
    }//GEN-LAST:event_btnAddToOrderActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        boolean validation = false;
        
        if (tableModel.getDataVector().isEmpty()) {
            Utilities.Utilities.infoBox("Order must contain at least one object", "Order Stock");
        } else if (LocalDate.parse(txtDate.getText()).isBefore(LocalDate.now())) {
            Utilities.Utilities.infoBox("Arrival date must be for today or after", "Arrival Date");
        } else
            validation = true;

        if (validation ) {
            if (addEdit == 0) {
                order.setOrderID(Utilities.IntergratedProjectStaffApplication.JSPConnector.addOrder(order));
                Utilities.Utilities.infoBox("Order Added", "Order Added");
                Utilities.IntergratedProjectStaffApplication.viewOrders.newOrder(order);
                orderDone.set(cboSupplier.getSelectedIndex(), true);
                if (cboSupplier.getSelectedIndex() != (suppliers.size()-1))
                    cboSupplier.setSelectedIndex(cboSupplier.getSelectedIndex()+1);
                else
                    lblOrderDone.setText("Order has recently been sent");
            } else if (addEdit == 1) {
                
                for (OrderStock stock : newStock)
                    Utilities.IntergratedProjectStaffApplication.JSPConnector.addOrderStock(stock);
                
                for (int i = 0; i < order.getOrderStocks().size() - newStock.size(); i++)
                    Utilities.IntergratedProjectStaffApplication.JSPConnector.updateOrderStock(order.getOrderStocks().get(i));
                
                Utilities.IntergratedProjectStaffApplication.viewOrders.updateCurrentObject(order.getTotal(), order.getNoOfItems());
                
                Utilities.Utilities.infoBox("Order Updated", "Order Updated");
                newStock.clear();
                
            }
        }
        
    }//GEN-LAST:event_btnOrderActionPerformed

    private void cboSupplierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSupplierItemStateChanged
            
            if (tableModel != null) {
                currentSupplier = suppliers.get(cboSupplier.getSelectedIndex());
                tableModel.setRowCount(0);
                generateOrder();
                txtDate.setText(order.getDateEstimateArrival().toString());
                if (orderDone.get(cboSupplier.getSelectedIndex()))
                    lblOrderDone.setText("Order has recently been sent");
                else
                    lblOrderDone.setText("");
            }
    }//GEN-LAST:event_cboSupplierItemStateChanged

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
            java.util.logging.Logger.getLogger(AddEditOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEditOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEditOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEditOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEditOrder().setVisible(true);
            }
        });
    }
    
    public void setupForm() {
        suppliers = Utilities.IntergratedProjectStaffApplication.JSPConnector.getAllSupplier();        
        for (Supplier supplier : suppliers) {
            cboSupplier.addItem(supplier.getSupplierName());
            orderDone.add(false);
        }
        
        ingredients = Utilities.IntergratedProjectStaffApplication.JSPConnector.getAllIngredient();
        
        createTable();
    }
    
    public void createTable() {
        String cols[] = {"Ingredient", "Units To Order", "Total Price (£)"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1; //all cells false
            }
        };
        
        
        if (order != null) {
            for (Supplier supplier : suppliers) {
                if (supplier.getSupplierID() == order.getSupplierID()) {
                    currentSupplier = supplier;
                    break;
                }
            }
            
            for (OrderStock stock : order.getOrderStocks()) {
                
                String name = "";
                Double price = 0.0;
                
                for (Ingredient ingredient : ingredients) {
                    if (stock.getIngredientID() == ingredient.getIngredientID()) {
                        name = ingredient.getName();
                        price = stock.getUnitAmount() * ingredient.getCostPerUnit();
                        break;
                    }
                }
                Object[] data = { name ,stock.getUnitAmount(), price};
                tableModel.addRow(data);
                cboSupplier.setEnabled(false);
            }
        } else { //generate order
            cboSupplier.setSelectedIndex(0);
            currentSupplier = suppliers.get(0);
            generateOrder();
            txtDate.setText(order.getDateEstimateArrival().toString());
        }
        JTable table = new JTable(tableModel);
        table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        
        JScrollPane spTable = new JScrollPane(table);
        pnlTable.setLayout(new BorderLayout());
        pnlTable.add(spTable, BorderLayout.SOUTH); 
    }
    
    public void generateOrder() {
        
        LocalDate date = LocalDate.now().plusDays(1);
        
        order = new Orders(currentSupplier.getSupplierID(), 0, 0 , date);
        
        for (Ingredient ingredient : ingredients) {
            if (order.getSupplierID() == ingredient.getSupplierID()) {
                double difference = ingredient.getBuyInLimit() - ingredient.getCurrentStock();
                if (difference > 0) {
                    int amount = (int)Math.ceil(difference / ingredient.getUnitValue());

                    //edit order object
                    OrderStock stock = new OrderStock(ingredient.getIngredientID(), amount);                
                    order.getOrderStocks().add(stock);
                    order.setTotal(order.getTotal() + amount * ingredient.getCostPerUnit());
                    order.setNoOfItems(order.getNoOfItems() + amount);

                    //set table
                    Object[] data = { ingredient.getName() ,amount, amount*ingredient.getCostPerUnit()};
                    tableModel.addRow(data);
                
                }
            }        
        }
    }
    
    public void updatePrice (int row) {
        int amount = Integer.parseInt(tableModel.getValueAt(row, 1).toString());
        int ingredientID = order.getOrderStocks().get(row).getIngredientID();
        double totalPrice = 0.0;                        

        for (Ingredient ingredient : ingredients) {
            if (ingredient.getIngredientID() == ingredientID){
                totalPrice = amount*ingredient.getCostPerUnit();
            }                                
        }

        //update object and table
        order.setTotal(order.getTotal() + amount - Double.parseDouble(tableModel.getValueAt(row, 2).toString()));
        tableModel.setValueAt(totalPrice, row, 2);
    }
    
    public void addToOrder(OrderStock stock, String name, Double price) {
        
        boolean stockFound = false;
        
        for (OrderStock existingStock : order.getOrderStocks()) { //check if stock is in list and update if so
            if (existingStock.getIngredientID() == stock.getIngredientID()) {
                int row = order.getOrderStocks().indexOf(existingStock);
                int units = Integer.parseInt(tableModel.getValueAt(row, 1).toString()) + stock.getUnitAmount();
                tableModel.setValueAt(units, row, 1);
                tableModel.setValueAt(units*price, row, 2);
                order.getOrderStocks().get(row).setUnitAmount(units);
                order.setTotal(order.getTotal() + (price * stock.getUnitAmount()));
                order.setNoOfItems(order.getNoOfItems() + stock.getUnitAmount());
                Utilities.Utilities.infoBox("Ingredient Updated with " + stock.getUnitAmount() + " units.", "Ingredient Updated");
                stockFound = true;
                break;
            }
        }
        if (!stockFound) { //else add new
            if (addEdit == 0)
                stock.setOrderID(order.getOrderID());
            else if (addEdit == 1)
                newStock.add(stock);

            order.getOrderStocks().add(stock);

            Object[] data = { name, stock.getUnitAmount(), price*stock.getUnitAmount()};
            tableModel.addRow(data);
            Utilities.Utilities.infoBox("Ingredient Added with " + stock.getUnitAmount() + " units.", "Ingredient Added");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToOrder;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnOrder;
    private javax.swing.JComboBox<String> cboSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblOrderDone;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JFormattedTextField txtDate;
    // End of variables declaration//GEN-END:variables
}