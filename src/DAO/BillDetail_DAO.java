/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import Cipher.AESCipher;
import DTO.BillDetail;
import DTO.statisticalObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bum
 */
public class BillDetail_DAO {
    private connectDB cB = new connectDB();
    public ArrayList<BillDetail> LoadDetail(String id){
        ArrayList<BillDetail> bdL = new ArrayList<>();
        String sql="SELECT * FROM bill_detail  " +
"                   WHERE Bill_id = '"+ id +"'";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
        while(rs.next()){
            BillDetail bd = new BillDetail();
            bd.setBillId(rs.getString("Bill_id"));
            bd.setProductId(rs.getString("Product_id"));
            bd.setSize(rs.getString("Size"));
            bd.setQuantity(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString("Quantity"))));
            bd.setTotalValue(Double.parseDouble(AESCipher.getInstance().decrypt(rs.getString("TotalValue"))));
            bd.setPercent(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString("percent"))));
            bdL.add(bd);
            }
        }catch(Exception e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return bdL;
    }
    
    public Boolean insert(BillDetail bd) {
        int rowAffected  = 0;
        String sql = "INSERT INTO `bill_detail`(`Bill_id`, `Product_id`, `Size`, `Quantity`, `TotalValue`, `percent`) VALUES (?,?,?,?,?,?)";
        try (Connection conn = cB.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);){
            pstm.setString(1, bd.getBillId());
            pstm.setString(2, bd.getProductId());
            pstm.setString(3, bd.getSize());
            pstm.setString(4, AESCipher.getInstance().encrypt(String.valueOf(bd.getQuantity())));
            pstm.setString(5, AESCipher.getInstance().encrypt(String.valueOf(bd.getTotalValue())));
            pstm.setString(6, AESCipher.getInstance().encrypt(String.valueOf(bd.getPercent())));
            rowAffected = pstm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(BillDetail_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    public ArrayList<statisticalObject> countSoldProductByDay(String date)
        {
            ArrayList<statisticalObject> soL = new ArrayList<>();
            String sql="SELECT product_id,Size, SUM(AES_DECRYPT(FROM_BASE64(Quantity),'"+AESCipher.getInstance().getKey()+"')) AS amount FROM bill_detail,bill \n" +
                            "WHERE Bill.Bill_ID=bill_detail.Bill_id "
                        +   "AND DATE(AES_DECRYPT(FROM_BASE64(Date),'"+AESCipher.getInstance().getKey()+"')) = '"+date+"'\n" +
                            "GROUP BY Product_id,Size";
            try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){ 
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setId(rs.getString("Product_id"));
                    so.setDescription(rs.getString("Size"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
            }catch(Exception e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }
        public ArrayList<statisticalObject> countSoldProductByDay(String sdate,String eDate)
        {
            ArrayList<statisticalObject> soL = new ArrayList<>();
            String sql="SELECT product_id,Size, SUM(AES_DECRYPT(FROM_BASE64(Quantity),'"+AESCipher.getInstance().getKey()+"')) AS amount FROM bill_detail,bill \n" +
                            "WHERE Bill.Bill_ID=bill_detail.Bill_id "
                        +   "AND DATE(AES_DECRYPT(FROM_BASE64(Date),'"+AESCipher.getInstance().getKey()+"')) BETWEEN '"+sdate+"' AND '"+eDate+"' \n" +
                            "GROUP BY Product_id,Size";
            try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){ 
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setId(rs.getString("Product_id"));
                    so.setDescription(rs.getString("Size"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
            }catch(Exception e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }
    public int totalSoldProductByDay(String Date){
        int n=0;
        String sql="SELECT product_id,Size, SUM(AES_DECRYPT(FROM_BASE64(Quantity),'"+AESCipher.getInstance().getKey()+"')) AS amount FROM bill_detail,bill \n" +
                            "WHERE Bill.Bill_ID=bill_detail.Bill_id "
                        +   "AND DATE(AES_DECRYPT(FROM_BASE64(Date),'"+AESCipher.getInstance().getKey()+"')) = '"+Date+"'";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            if(rs.next()) n = rs.getInt("amount");
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return n;
    }
    public ArrayList<statisticalObject> CountSoldProductByMonth(String month,String year){
        ArrayList<statisticalObject> soL = new ArrayList<>();
        String sql="SELECT Product_id,Size, SUM(AES_DECRYPT(FROM_BASE64(Quantity),'"+AESCipher.getInstance().getKey()+"')) AS amount FROM bill_detail,bill \n" +
                    "WHERE bill.Bill_ID = bill_detail.Bill_id\n" +
                    "AND MONTH(AES_DECRYPT(FROM_BASE64(Bill.Date),'"+AESCipher.getInstance().getKey()+"')) = '"+month+"' \n" +
                    "AND YEAR(AES_DECRYPT(FROM_BASE64(Bill.Date),'"+AESCipher.getInstance().getKey()+"')) = '"+year+"' \n" +
                    "GROUP BY Product_id,Size";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setId(rs.getString("Product_id"));
                    so.setDescription(rs.getString("Size"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return soL;
    }
}
