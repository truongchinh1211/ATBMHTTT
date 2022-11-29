/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.Account_BUS;
import BUS.DecentralizationDetail_BUS;
import BUS.Decentralization_BUS;
import DTO.Account;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josie
 */
public class Account_GUI extends javax.swing.JPanel implements checkPermission{
    
    private ArrayList<String> listDecentralize = new ArrayList<String>();
    private Decentralization_BUS dcBUS = new Decentralization_BUS();
    private DecentralizationDetail_BUS dcdtBUS = new DecentralizationDetail_BUS();
    private int permissionType;
    Account_BUS accountBUS = new Account_BUS();
    ArrayList<Account> listAccount;
    String dcdt = "";
    
    public Account_GUI(int permissionType, String dcdt_Id) {
        listAccount = accountBUS.loadDataAccount();
        initComponents();
        loadAccountList(listAccount);
        this.permissionType = permissionType;
        Vector comboBoxItems = new Vector();
        listDecentralize = dcBUS.readAllId();
        comboBoxItems.add("Chưa xác định");
        for(String decentralize_id : listDecentralize){
            comboBoxItems.add(decentralize_id);
        }
        cbbDecentralizeId.setModel(new DefaultComboBoxModel(comboBoxItems));
        this.dcdt = dcdt_Id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Custom.RoundPanel();
        roundPanel3 = new Custom.RoundPanel();
        lblAccountIDConfig = new javax.swing.JLabel();
        txtAccountID = new javax.swing.JTextField();
        lblUserNameConfig = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblPasswordConfig = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtStaffID = new javax.swing.JTextField();
        lblStaffIDConfig = new javax.swing.JLabel();
        btnAdd = new Custom.Button();
        btnUpdate = new Custom.Button();
        btnRefresh = new Custom.Button();
        btnDelete = new Custom.Button();
        lblTypeConfig = new javax.swing.JLabel();
        cbbDecentralizeId = new javax.swing.JComboBox<>();
        roundPanel2 = new Custom.RoundPanel();
        cbbSearchFilter = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new Custom.Button();
        scrAccountList = new javax.swing.JScrollPane();
        tblAccountList = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1015, 650));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblAccountIDConfig.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAccountIDConfig.setText("Mã tài khoản:");

        txtAccountID.setEditable(false);
        txtAccountID.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtAccountID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountIDActionPerformed(evt);
            }
        });

        lblUserNameConfig.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblUserNameConfig.setText("Tên người dùng:");

        txtUserName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        lblPasswordConfig.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPasswordConfig.setText("Mật khẩu:");

        txtPassword.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        txtStaffID.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        lblStaffIDConfig.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblStaffIDConfig.setText("Mã nhân viên:");

        btnAdd.setBackground(new java.awt.Color(240, 240, 240));
        btnAdd.setBorder(null);
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plus.png"))); // NOI18N
        btnAdd.setText("  Add    ");
        btnAdd.setColor(new java.awt.Color(240, 240, 240));
        btnAdd.setColorClick(new java.awt.Color(240, 235, 235));
        btnAdd.setColorOver(new java.awt.Color(255, 255, 255));
        btnAdd.setFocusPainted(false);
        btnAdd.setRadius(20);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(240, 240, 240));
        btnUpdate.setBorder(null);
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wrench.png"))); // NOI18N
        btnUpdate.setText("  Update");
        btnUpdate.setColor(new java.awt.Color(240, 240, 240));
        btnUpdate.setColorClick(new java.awt.Color(240, 235, 235));
        btnUpdate.setColorOver(new java.awt.Color(255, 255, 255));
        btnUpdate.setFocusPainted(false);
        btnUpdate.setRadius(20);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(240, 240, 240));
        btnRefresh.setBorder(null);
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/refresh.png"))); // NOI18N
        btnRefresh.setText("  Refresh");
        btnRefresh.setColor(new java.awt.Color(240, 240, 240));
        btnRefresh.setColorClick(new java.awt.Color(240, 235, 235));
        btnRefresh.setColorOver(new java.awt.Color(255, 255, 255));
        btnRefresh.setFocusPainted(false);
        btnRefresh.setRadius(20);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(240, 240, 240));
        btnDelete.setBorder(null);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete.png"))); // NOI18N
        btnDelete.setText("  Delete");
        btnDelete.setColor(new java.awt.Color(240, 240, 240));
        btnDelete.setColorClick(new java.awt.Color(240, 235, 235));
        btnDelete.setColorOver(new java.awt.Color(255, 255, 255));
        btnDelete.setFocusPainted(false);
        btnDelete.setRadius(20);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblTypeConfig.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTypeConfig.setText("Mã quyền:");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblTypeConfig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPasswordConfig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAccountIDConfig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUserNameConfig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStaffIDConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStaffID)
                            .addComponent(txtPassword)
                            .addComponent(txtUserName)
                            .addComponent(txtAccountID, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(cbbDecentralizeId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountIDConfig)
                    .addComponent(txtAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserNameConfig)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswordConfig)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTypeConfig)
                    .addComponent(cbbDecentralizeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStaffIDConfig)
                    .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        cbbSearchFilter.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbbSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã tài khoản", "Tên tài khoản", "Loại", "Mã nhân viên" }));
        cbbSearchFilter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbbSearchFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchFilterActionPerformed(evt);
            }
        });

        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        btnSearch.setColor(new java.awt.Color(255, 255, 255));
        btnSearch.setColorClick(new java.awt.Color(255, 255, 255));
        btnSearch.setColorOver(new java.awt.Color(242, 152, 174));
        btnSearch.setRadius(5);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        scrAccountList.setBackground(new java.awt.Color(242, 242, 242));
        scrAccountList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10), new java.awt.Color(102, 102, 102))); // NOI18N
        scrAccountList.setName(""); // NOI18N
        scrAccountList.setPreferredSize(new java.awt.Dimension(470, 423));

        tblAccountList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblAccountList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã tài khoản", "Tên tài khoản", "Mật khẩu", "Mã quyền", "Mã nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAccountList.setRowHeight(30);
        tblAccountList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAccountListMouseClicked(evt);
            }
        });
        scrAccountList.setViewportView(tblAccountList);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrAccountList, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrAccountList, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(!txtSearch.getText().isEmpty()) {
            ArrayList<Account> resultList = accountBUS.searchAccount(txtSearch.getText(), cbbSearchFilter.getSelectedItem() + "");
            loadAccountList(resultList);
            refresh();
        }
        else {
            loadAccountList(listAccount);
            refresh();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtAccountIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccountIDActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblAccountListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccountListMouseClicked
        int i = tblAccountList.getSelectedRow();
        Account selectedAccount = null;
        for(Account acc:listAccount){
            if(acc.getAccountId().equals(tblAccountList.getModel().getValueAt(i, 0))){
                selectedAccount = acc;
                break;
            }
        }
        if(selectedAccount!=null){
            txtAccountID.setText(selectedAccount.getAccountId());
            txtUserName.setText(selectedAccount.getUsername());
            txtPassword.setText(selectedAccount.getPassword());
            String decentralizeId = selectedAccount.getDecetralizeId()==null? "Chưa xác định" : selectedAccount.getDecetralizeId();
            cbbDecentralizeId.setSelectedItem(decentralizeId);
            txtStaffID.setText(selectedAccount.getStaffId());
        }
    }//GEN-LAST:event_tblAccountListMouseClicked

    private void cbbSearchFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSearchFilterActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
            this.permissionType = dcdtBUS.readById(this.dcdt).getIsAccount();
            if(this.permissionType!=2){
                this.hienThiErrorMess();
                return;
            }
            String newID;
            newID = accountBUS.autoID();
            if (isInputEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống thông tin tài khoản!");
            }
            else if(accountBUS.accountNameExisted(newID, txtUserName.getText()))
                JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại!");
            else {
                Account acc = new Account(newID, txtUserName.getText(), txtPassword.getText(),
                        cbbDecentralizeId.getSelectedItem().toString(), txtStaffID.getText(), false);
                if(accountBUS.inserAccount(acc)) {
                    JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!");
                    listAccount = accountBUS.loadDataAccount();
                    loadAccountList(listAccount);
                    refresh();
                }
                
            }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsAccount();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if(isInputEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin!");
        }
        else {
            int i = tblAccountList.getSelectedRow();
            Account selectedAccount = null;
            for(Account acc:listAccount){
                if(acc.getAccountId().equals(tblAccountList.getModel().getValueAt(i, 0))){
                    selectedAccount = acc;
                    break;
                }
            }
            Account acc = new Account(selectedAccount.getAccountId(),txtUserName.getText(), txtPassword.getText(),
            cbbDecentralizeId.getSelectedItem().toString(), txtStaffID.getText(), false);
            if(accountBUS.updateAccount(acc)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin tài khoản thành công!");
                listAccount = accountBUS.loadDataAccount();
                loadAccountList(listAccount);
                refresh();
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        this.permissionType = dcdtBUS.readById(this.dcdt).getIsAccount();
        if(this.permissionType!=2){
            this.hienThiErrorMess();
            return;
        }
        if(txtAccountID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần xóa!");
        }
        else {
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa tài khoản?","Warning",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//              tblAccountList.getModel().getValueAt(i, 0));
                if(accountBUS.deleteAccount(txtAccountID.getText())) {
                    JOptionPane.showMessageDialog(this, "Xóa tài khoản thành công!");
                    listAccount = accountBUS.loadDataAccount();
                    loadAccountList(listAccount);
                    refresh();
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    
    private void loadAccountList(ArrayList<Account> listAccount) {
        DefaultTableModel model = (DefaultTableModel) tblAccountList.getModel();
        model.setRowCount(0);
        String decentralizeId=null;
        for(Account acc : listAccount) {
            decentralizeId = acc.getDecetralizeId() == null ? "Chưa xác định" : acc.getDecetralizeId();
            model.addRow(new Object[]{acc.getAccountId(), acc.getUsername(), acc.getPassword(), decentralizeId, acc.getStaffId()});
        }
    }
    
    private void refresh() {
        txtAccountID.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        txtStaffID.setText("");
        cbbDecentralizeId.setSelectedIndex(0);
        ListSelectionModel model = tblAccountList.getSelectionModel();
        model.removeSelectionInterval(tblAccountList.getRowCount(),0);
    }
    
    private boolean isInputEmpty() {
        return txtUserName.getText().isEmpty()
                || txtPassword.getText().isEmpty()
                || txtStaffID.getText().isEmpty();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Button btnAdd;
    private Custom.Button btnDelete;
    private Custom.Button btnRefresh;
    private Custom.Button btnSearch;
    private Custom.Button btnUpdate;
    private javax.swing.JComboBox<String> cbbDecentralizeId;
    private javax.swing.JComboBox<String> cbbSearchFilter;
    private javax.swing.JLabel lblAccountIDConfig;
    private javax.swing.JLabel lblPasswordConfig;
    private javax.swing.JLabel lblStaffIDConfig;
    private javax.swing.JLabel lblTypeConfig;
    private javax.swing.JLabel lblUserNameConfig;
    private Custom.RoundPanel roundPanel1;
    private Custom.RoundPanel roundPanel2;
    private Custom.RoundPanel roundPanel3;
    private javax.swing.JScrollPane scrAccountList;
    private javax.swing.JTable tblAccountList;
    private javax.swing.JTextField txtAccountID;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStaffID;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
