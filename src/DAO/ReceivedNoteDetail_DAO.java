/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import Cipher.AESCipher;
import DTO.ReceivedNote;
import DTO.ReceivedNoteDetail;
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
public class ReceivedNoteDetail_DAO {

    private connectDB cB = new connectDB();

    public ArrayList<ReceivedNoteDetail> LoadDetail(String id) {
        String sql = "SELECT * FROM received_note_detail "
                + "WHERE Received_Note_ID='" + id + "'";
        ArrayList<ReceivedNoteDetail> rndList = new ArrayList<>();
        try (Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                ReceivedNoteDetail rnd = new ReceivedNoteDetail();
                rnd.setProductId(rs.getString("Product_ID"));
                rnd.setSize(rs.getString("Size"));
                rnd.setQuantity(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString("Quantity"))));
                rnd.setUnitPrice(Double.parseDouble(AESCipher.getInstance().decrypt(rs.getString("UnitPrice"))));
                rnd.setPrice(Double.parseDouble(AESCipher.getInstance().decrypt(rs.getString("Price"))));
                rndList.add(rnd);
            }
        } catch (Exception e) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return rndList;
    }

    public ArrayList<statisticalObject> countReceivedProductByDay(String date) {
        String sql = "SELECT product_id,Size, SUM(AES_DECRYPT(FROM_BASE64(Quantity),'"+AESCipher.getInstance().getKey()+"')) AS amount FROM received_note_detail,received_note \n"
                + "WHERE received_note.Received_Note_ID=received_note_detail.Received_Note_ID "
                + "AND DATE(AES_DECRYPT(FROM_BASE64(Date),'"+AESCipher.getInstance().getKey()+"')) = '" + date + "'\n"
                + "GROUP BY Product_id,Size";
        ArrayList<statisticalObject> soL = new ArrayList<>();
        try (Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                statisticalObject so = new statisticalObject();
                so.setId(rs.getString("Product_id"));
                so.setDescription(rs.getString("Size"));
                so.setValue(rs.getInt("amount"));
                soL.add(so);
            }
        } catch (SQLException e) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return soL;
    }
        public ArrayList<statisticalObject> countReceivedProductByDay(String sdate,String edate) {
        String sql = "SELECT product_id,Size, SUM(AES_DECRYPT(FROM_BASE64(Quantity),'"+AESCipher.getInstance().getKey()+"')) AS amount FROM received_note_detail,received_note \n"
                + "WHERE received_note.Received_Note_ID=received_note_detail.Received_Note_ID "
                + "AND DATE(AES_DECRYPT(FROM_BASE64(Date),'"+AESCipher.getInstance().getKey()+"')) BETWEEN '" + sdate + "' AND '"+edate+"' \n"
                + "GROUP BY Product_id,Size";
        ArrayList<statisticalObject> soL = new ArrayList<>();
        try (Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                statisticalObject so = new statisticalObject();
                so.setId(rs.getString("Product_id"));
                so.setDescription(rs.getString("Size"));
                so.setValue(rs.getInt("amount"));
                soL.add(so);
            }
        } catch (SQLException e) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return soL;
    }
    public int totalReceivedProductByDay(String Date) {
        int n = 0;
        String sql = "SELECT SUM(AES_DECRYPT(FROM_BASE64(Quantity),'"+AESCipher.getInstance().getKey()+"')) AS amount FROM received_note_detail,received_note\n"
                + "WHERE received_note.Received_Note_ID=received_note_detail.Received_Note_ID \n"
                + "AND DATE(AES_DECRYPT(FROM_BASE64(Date),'"+AESCipher.getInstance().getKey()+"')) = '" + Date + "'";
        try (Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
            if (rs.next()) {
                n = rs.getInt("amount");
            }
        } catch (SQLException e) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    //Phat
    public boolean insert(ReceivedNoteDetail rnd) {
        try {
            String sql = "INSERT INTO received_note_detail(Received_Note_ID,Product_ID,Size,UnitPrice,Quantity,Price)"
                    + " VALUES('" + rnd.getReceivedNoteID() + "','" + rnd.getProductId() + "','" + rnd.getSize() + "','" 
                    + AESCipher.getInstance().encrypt(String.valueOf(rnd.getUnitPrice()))  + "','" 
                    + AESCipher.getInstance().encrypt(String.valueOf(rnd.getQuantity())) + "','" 
                    + AESCipher.getInstance().encrypt(String.valueOf(rnd.getPrice())) + "')";
            try {
                Connection conn = cB.getConnect();
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
            } catch (SQLException e) {
                Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
            }
        } catch (Exception e) {
            System.out.println("An error has occured at insert function in ReceivedNoteDetail_DAO class");
            System.out.println(e);
        }
        return true;
    }
    public ArrayList<statisticalObject> CountReceivedProductByMonth(String month,String year){
        ArrayList<statisticalObject> soL = new ArrayList<>();
        String sql="SELECT Product_id,Size, SUM(AES_DECRYPT(FROM_BASE64(Quantity),'"+AESCipher.getInstance().getKey()+"')) AS amount FROM received_note,received_note_detail\n" +
                    "WHERE received_note.Received_Note_ID = received_note_detail.Received_Note_ID\n" +
                    "AND MONTH(AES_DECRYPT(FROM_BASE64(received_note.Date),'"+AESCipher.getInstance().getKey()+"')) = '"+month+"' \n" +
                    "AND YEAR(AES_DECRYPT(FROM_BASE64(received_note.Date),'"+AESCipher.getInstance().getKey()+"')) = '"+year+"' \n" +
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
