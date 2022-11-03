/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Josie
 */
public class Decentralization_GUI extends javax.swing.JPanel {

    /**
     * Creates new form Decentralization_GUI
     */
    public Decentralization_GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupChiTietQuyen = new javax.swing.ButtonGroup();
        roundPanel1 = new Custom.RoundPanel();
        pnlDecentralizationList = new Custom.RoundPanel();
        scrDanhSachQuyen = new javax.swing.JScrollPane();
        tblDanhSachQuyen = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new Custom.Button();
        roundPanel3 = new Custom.RoundPanel();
        btnAdd = new Custom.Button();
        btnFix = new Custom.Button();
        btnDelete = new Custom.Button();
        btnImport = new Custom.Button();
        btnExport = new Custom.Button();

        setPreferredSize(new java.awt.Dimension(1070, 652));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setPreferredSize(new java.awt.Dimension(1070, 652));

        pnlDecentralizationList.setBackground(new java.awt.Color(245, 245, 245));
        pnlDecentralizationList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        scrDanhSachQuyen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        scrDanhSachQuyen.setPreferredSize(new java.awt.Dimension(470, 423));

        tblDanhSachQuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Quyền", "Tên Quyền", "Chi Tiết Quyền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrDanhSachQuyen.setViewportView(tblDanhSachQuyen);

        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch.setPreferredSize(new java.awt.Dimension(64, 19));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        btnSearch.setColor(new java.awt.Color(255, 255, 255));
        btnSearch.setColorClick(new java.awt.Color(255, 255, 255));
        btnSearch.setColorOver(new java.awt.Color(242, 152, 174));
        btnSearch.setPreferredSize(new java.awt.Dimension(16, 16));
        btnSearch.setRadius(5);

        javax.swing.GroupLayout pnlDecentralizationListLayout = new javax.swing.GroupLayout(pnlDecentralizationList);
        pnlDecentralizationList.setLayout(pnlDecentralizationListLayout);
        pnlDecentralizationListLayout.setHorizontalGroup(
            pnlDecentralizationListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDecentralizationListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDecentralizationListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrDanhSachQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDecentralizationListLayout.setVerticalGroup(
            pnlDecentralizationListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDecentralizationListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDecentralizationListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrDanhSachQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(245, 245, 245));
        roundPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdd.setText("Thêm");
        btnAdd.setColor(new java.awt.Color(255, 255, 255));
        btnAdd.setColorClick(new java.awt.Color(255, 255, 255));
        btnAdd.setColorOver(new java.awt.Color(242, 152, 174));
        btnAdd.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAdd.setInheritsPopupMenu(true);
        btnAdd.setRadius(15);

        btnFix.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFix.setText("Sửa");
        btnFix.setColor(new java.awt.Color(255, 255, 255));
        btnFix.setColorClick(new java.awt.Color(255, 255, 255));
        btnFix.setColorOver(new java.awt.Color(242, 152, 174));
        btnFix.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnFix.setInheritsPopupMenu(true);
        btnFix.setRadius(15);

        btnDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.setText("Xóa");
        btnDelete.setColor(new java.awt.Color(255, 255, 255));
        btnDelete.setColorClick(new java.awt.Color(255, 255, 255));
        btnDelete.setColorOver(new java.awt.Color(242, 152, 174));
        btnDelete.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnDelete.setInheritsPopupMenu(true);
        btnDelete.setRadius(15);

        btnImport.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImport.setText("Nhập Excel");
        btnImport.setColor(new java.awt.Color(255, 255, 255));
        btnImport.setColorClick(new java.awt.Color(255, 255, 255));
        btnImport.setColorOver(new java.awt.Color(242, 152, 174));
        btnImport.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnImport.setInheritsPopupMenu(true);
        btnImport.setRadius(15);

        btnExport.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExport.setText("Xuất Excel");
        btnExport.setColor(new java.awt.Color(255, 255, 255));
        btnExport.setColorClick(new java.awt.Color(255, 255, 255));
        btnExport.setColorOver(new java.awt.Color(242, 152, 174));
        btnExport.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnExport.setInheritsPopupMenu(true);
        btnExport.setRadius(15);

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFix, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFix, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDecentralizationList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlDecentralizationList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Button btnAdd;
    private Custom.Button btnDelete;
    private Custom.Button btnExport;
    private Custom.Button btnFix;
    private javax.swing.ButtonGroup btnGroupChiTietQuyen;
    private Custom.Button btnImport;
    private Custom.Button btnSearch;
    private Custom.RoundPanel pnlDecentralizationList;
    private Custom.RoundPanel roundPanel1;
    private Custom.RoundPanel roundPanel3;
    private javax.swing.JScrollPane scrDanhSachQuyen;
    private javax.swing.JTable tblDanhSachQuyen;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
