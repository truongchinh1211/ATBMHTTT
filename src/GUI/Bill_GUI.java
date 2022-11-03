/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.Bill_BUS;
import BUS.ReceivedNote_BUS;
import DTO.Bill;
import DTO.BillDetail;
import DTO.ReceivedNote;
import DTO.ReceivedNoteDetail;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bum
 */
public class Bill_GUI extends javax.swing.JPanel {

    /**
     * Creates new form Bill_GUI
     */
    private DefaultTableModel model;
    private ReceivedNote_BUS rnBUS;
    private Bill_BUS bBUS;
    private ArrayList<ReceivedNote> rnL = new ArrayList<>();
    private ArrayList<Bill> bL= new ArrayList<>();
    
    public Bill_GUI() {
        initComponents();
        rnBUS = new ReceivedNote_BUS();
        rnL = rnBUS.load_Data();
        bBUS= new Bill_BUS();
        bL=bBUS.LoadData();
        loadrnTable();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        button1 = new Custom.Button();
        roundPanel1 = new Custom.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        blTable = new javax.swing.JTable();
        listTitle = new javax.swing.JLabel();
        roundPanel2 = new Custom.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        billTitle = new javax.swing.JLabel();
        staffOutput = new javax.swing.JLabel();
        timeOutput = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        value2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idOutput = new javax.swing.JLabel();
        P_COutput = new javax.swing.JLabel();
        value3 = new javax.swing.JLabel();
        value5 = new javax.swing.JLabel();
        value6 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        P_CLabel = new javax.swing.JLabel();
        staffLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        value1 = new javax.swing.JLabel();
        value2Label = new javax.swing.JLabel();
        value3Label = new javax.swing.JLabel();
        nhapBtn = new Custom.Button();
        banBtn = new Custom.Button();

        setBackground(new java.awt.Color(51, 51, 51));
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1043, 636));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, 226, 35));

        button1.setBackground(new java.awt.Color(255, 255, 255));
        button1.setBorder(null);
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        button1.setColor(new java.awt.Color(255, 255, 255));
        button1.setColorClick(new java.awt.Color(228, 228, 228));
        button1.setColorOver(new java.awt.Color(255, 255, 255));
        button1.setFocusable(false);
        button1.setRadius(5);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, 55, 35));

        roundPanel1.setBackground(new java.awt.Color(204, 204, 204));

        blTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Date", "Tên nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        blTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(blTable);
        if (blTable.getColumnModel().getColumnCount() > 0) {
            blTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 73, -1, -1));

        listTitle.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        listTitle.setForeground(new java.awt.Color(255, 255, 255));
        listTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listTitle.setText("Danh sách phiếu nhập hàng");
        listTitle.setToolTipText("");
        add(listTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 42, 515, -1));

        roundPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<<Logo>>");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        roundPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 36, 398, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("<<Tên cửa hàng>>");
        jLabel17.setAutoscrolls(true);
        roundPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 64, 398, -1));

        billTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        billTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        billTitle.setText("Phiếu nhập hàng");
        billTitle.setAutoscrolls(true);
        roundPanel2.add(billTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 96, 398, -1));
        roundPanel2.add(staffOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        timeOutput.setToolTipText("");
        roundPanel2.add(timeOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("------------------------------------");
        roundPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 221, 262, -1));

        detailTable.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "TÊN HÀNG", "SIZE", "Đ.GIÁ", "SL", "T.TIỀN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(detailTable);
        if (detailTable.getColumnModel().getColumnCount() > 0) {
            detailTable.getColumnModel().getColumn(0).setPreferredWidth(120);
            detailTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            detailTable.getColumnModel().getColumn(2).setPreferredWidth(40);
            detailTable.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        roundPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 252, 398, 228));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("đ");
        roundPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 10, -1));

        value2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        value2.setToolTipText("");
        roundPanel2.add(value2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 80, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setText("Địa chỉ : trường đại học Sài Gòn");
        roundPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 190, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel6.setText("Contact : 0909-XXX-153");
        roundPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 230, -1));
        roundPanel2.add(idOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));
        roundPanel2.add(P_COutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        value3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        value3.setToolTipText("");
        roundPanel2.add(value3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 80, -1));

        value5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        value5.setText("đ");
        roundPanel2.add(value5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 10, -1));

        value6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        value6.setText("đ");
        roundPanel2.add(value6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 10, -1));

        idLabel.setText("Số hóa đơn:");
        roundPanel2.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        P_CLabel.setText("Nhà cung cấp:");
        roundPanel2.add(P_CLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        staffLabel.setText("Thu ngân:");
        roundPanel2.add(staffLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel15.setText("Thời gian:");
        roundPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Tổng cộng:");
        roundPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 70, -1));

        value1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        roundPanel2.add(value1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 70, -1));

        value2Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        value2Label.setText("Thuế:");
        roundPanel2.add(value2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 220, -1));

        value3Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        value3Label.setText("Thành tiền:");
        roundPanel2.add(value3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 80, -1));

        add(roundPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, 600));

        nhapBtn.setBorder(null);
        nhapBtn.setForeground(new java.awt.Color(51, 51, 51));
        nhapBtn.setText("Nhập");
        nhapBtn.setEnabled(false);
        nhapBtn.setFocusable(false);
        nhapBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nhapBtn.setRadius(10);
        nhapBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhapBtnMouseClicked(evt);
            }
        });
        add(nhapBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 84, 33));

        banBtn.setBorder(null);
        banBtn.setForeground(new java.awt.Color(51, 51, 51));
        banBtn.setText("Bán");
        banBtn.setFocusable(false);
        banBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        banBtn.setRadius(10);
        banBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                banBtnMouseClicked(evt);
            }
        });
        add(banBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 84, 33));
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void banBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_banBtnMouseClicked
        if(!nhapBtn.isEnabled()){
            model = (DefaultTableModel)detailTable.getModel();
            model.setRowCount(0);
            nhapBtn.setEnabled(true);
            banBtn.setEnabled(false);
            listTitle.setText("Danh sách hóa đơn bán hàng");
            billTitle.setText("Hóa đơn");
            P_CLabel.setText("Tên khách hàng:");
            value2Label.setText("Tiền nhận:");
            value3Label.setText("Tiền thừa:");
            refresh();
            loadbTable();
        }
    }//GEN-LAST:event_banBtnMouseClicked

    private void nhapBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhapBtnMouseClicked
        if(nhapBtn.isEnabled()){
            model = (DefaultTableModel)detailTable.getModel();
            model.setRowCount(0);
            nhapBtn.setEnabled(false);
            banBtn.setEnabled(true);
            listTitle.setText("Danh sách phiếu nhập hàng");
            billTitle.setText("Phiếu nhập hàng");
            P_CLabel.setText("Nhà cung cấp:");
            value2Label.setText("Thuế:");
            value3Label.setText("Thành tiền:");
            refresh();
            loadrnTable();
        }
    }//GEN-LAST:event_nhapBtnMouseClicked

    private void blTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blTableMouseClicked

        int i = blTable.getSelectedRow();
        if(!nhapBtn.isEnabled()){
        ReceivedNote rn = rnL.get(i);
        loadrnDetail(rn.getDetail());
        idOutput.setText(rn.getId());
        timeOutput.setText(rn.getDate());
        P_COutput.setText(rn.getSupplier());
        staffOutput.setText(rn.getStaffName());
        value1.setText(String.valueOf(rn.getTotalValue()));
        double a = rn.getTotalValue() * 0.1;
        value2.setText(String.valueOf(a));
        value3.setText(String.valueOf(rn.getTotalValue()-a));
        }
        else{
            Bill b = bL.get(i);
            loadbDetail(b.getBillDetail());
            idOutput.setText(b.getBill_ID());
            timeOutput.setText(b.getDate());
            P_COutput.setText(b.getCustomerName());
            staffOutput.setText(b.getStaffName());
            value1.setText(String.valueOf(b.getTotalValue()));
            value2.setText(String.valueOf(b.getReceivedMoney()));
            value3.setText(String.valueOf(b.getExcessMoney()));
            
        }
    }//GEN-LAST:event_blTableMouseClicked

        public void refresh(){
        idOutput.setText("");
        timeOutput.setText("");
        staffOutput.setText("");
        P_COutput.setText("");
        value1.setText("");
        value2.setText("");
        value3.setText("");
    } 
    
    public void loadrnTable(){
        model = (DefaultTableModel)blTable.getModel();
        model.setRowCount(0);
        for (ReceivedNote rnL1 : rnL) {
            String id=rnL1.getId();
            String date= rnL1.getDate();
            String staffName = rnL1.getStaffName();
            Object[] row = new Object[]{id,date,staffName};
            model.addRow(row);
        }
    }
    
        public void loadbTable(){
        model = (DefaultTableModel)blTable.getModel();
        model.setRowCount(0);
        for (Bill bL1 : bL) {
            String id=bL1.getBill_ID();
            String date= bL1.getDate();
            String staffName = bL1.getStaffName();
            Object[] row = new Object[]{id,date,staffName};
            model.addRow(row);
        }
    }
    
    public void loadrnDetail(ArrayList<ReceivedNoteDetail> rnd){
        model = (DefaultTableModel)detailTable.getModel();
        model.setRowCount(0);
        for(ReceivedNoteDetail rnd1 : rnd){
            String productName = rnd1.getProductName();
            String productSize = rnd1.getSize();
            String productUnitPrice = String.valueOf(rnd1.getUnitPrice());
            String productQuantity = String.valueOf(rnd1.getQuantity());
            String productValue = String.valueOf(rnd1.getPrice())+"đ";
            Object[] row = new Object[]{productName,productSize,productUnitPrice,productQuantity,productValue};
            model.addRow(row);
        }
    }
    public void loadbDetail(ArrayList<BillDetail> bd){
        model = (DefaultTableModel)detailTable.getModel();
        model.setRowCount(0);
        for(BillDetail bd1 : bd){
            String productName = bd1.getProductName();
            String productSize = bd1.getSize();
            String productUnitPrice = String.valueOf(bd1.getUnitPrice());
            String productQuantity = String.valueOf(bd1.getAmount());
            String productValue = String.valueOf(bd1.getTotalValue())+"đ";
            Object[] row = new Object[]{productName,productSize,productUnitPrice,productQuantity,productValue};
            model.addRow(row);
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel P_CLabel;
    private javax.swing.JLabel P_COutput;
    private Custom.Button banBtn;
    private javax.swing.JLabel billTitle;
    private javax.swing.JTable blTable;
    private Custom.Button button1;
    private javax.swing.JTable detailTable;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idOutput;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel listTitle;
    private Custom.Button nhapBtn;
    private Custom.RoundPanel roundPanel1;
    private Custom.RoundPanel roundPanel2;
    private javax.swing.JLabel staffLabel;
    private javax.swing.JLabel staffOutput;
    private javax.swing.JLabel timeOutput;
    private javax.swing.JLabel value1;
    private javax.swing.JLabel value2;
    private javax.swing.JLabel value2Label;
    private javax.swing.JLabel value3;
    private javax.swing.JLabel value3Label;
    private javax.swing.JLabel value5;
    private javax.swing.JLabel value6;
    // End of variables declaration//GEN-END:variables
}
