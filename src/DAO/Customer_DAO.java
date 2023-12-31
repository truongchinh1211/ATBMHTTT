
package DAO;

import Cipher.AESCipher;
import DTO.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer_DAO{
    
    connectDB cn = new connectDB();
    
    public Customer_DAO() {}
    
    public ArrayList<Customer> read() {
        ArrayList<Customer> customerList = new ArrayList<>();
        String sql = "SELECT * FROM `customer` WHERE `Customer_id` != 'C0' AND `IsDeleted` !='1'";
        
        try (Connection conn = cn.getConnect(); Statement stm = conn.createStatement();){
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                Customer ct = new Customer();
                ct.setCustomerId(rs.getString(1));
                ct.setCustomerName(AESCipher.getInstance().decrypt(rs.getNString(2)));
                ct.setCustomerBirthYear(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString(3)))); //or '^.{4}'
                ct.setPhoneNum(AESCipher.getInstance().decrypt(rs.getString(4)));
                ct.setPurchaseTimes(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString(5))));
                customerList.add(ct);
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerList;
    }

    public ArrayList<String> readAllID() {
        ArrayList<String> idList = new ArrayList<>();
        String sql = "SELECT `Customer_id` FROM `customer` WHERE `Customer_id` != 'C0'";
        try(Connection conn = cn.getConnect(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                idList.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idList;
    }

    public Boolean create(Customer ct) {
        int rowAffected = 0;
        String sql = "INSERT INTO `customer`(`Customer_id`, `Customer_name`, `YearOfBirth`, `phoneNum`, `Purchase_Time`, `IsDeleted`) VALUES (?,?,?,?,?,?)";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, ct.getCustomerId());
            pstm.setString(2, AESCipher.getInstance().encrypt(ct.getCustomerName()));
            pstm.setString(3, AESCipher.getInstance().encrypt(String.valueOf(ct.getCustomerBirthYear())));
            pstm.setString(4, AESCipher.getInstance().encrypt(ct.getPhoneNum()));
            pstm.setString(5, AESCipher.getInstance().encrypt(String.valueOf(ct.getPurchaseTimes())));
            pstm.setInt(6, 0);
            rowAffected = pstm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0;
    }

    public Boolean update(Customer ct) {
        int rowAffected = 0;
        String sql = "UPDATE `customer` SET `Customer_name`=?,`YearOfBirth`=?,`phoneNum`=?,`Purchase_Time`=? WHERE `Customer_id`=?";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, ct.getCustomerName());
            pstm.setString(2, AESCipher.getInstance().encrypt(ct.getCustomerName()));
            pstm.setString(3, AESCipher.getInstance().encrypt(String.valueOf(ct.getCustomerBirthYear())));
            pstm.setString(4, AESCipher.getInstance().encrypt(ct.getPhoneNum()));
            pstm.setString(5, AESCipher.getInstance().encrypt(String.valueOf(ct.getPurchaseTimes())));
            rowAffected = pstm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0;
    }

    public Boolean updatePurchaseTime(String id, int purchaseTimes) {
        int rowAffected = 0;
        String sql = "UPDATE `customer` SET `Purchase_Time`=? WHERE Customer_id =?";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, AESCipher.getInstance().encrypt(String.valueOf(purchaseTimes)));
            pstm.setString(2, id);
            rowAffected = pstm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    
    public Boolean delete(String id) {
        int rowAffected = 0;
        String sql = "UPDATE `customer` SET `IsDeleted`='1' WHERE `Customer_id`=?";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, id);
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }

    public Customer findById(String id) {
        String sql = "SELECT `Customer_id`, `Customer_name`, `YearOfBirth`, `phoneNum`, `Purchase_Time` FROM `customer` "
                + "WHERE `Customer_id`= ? AND `Customer_id` != 'C0' AND `IsDeleted` != '1'";
        Customer ct = null;
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                ct = new Customer();
                ct.setCustomerId(rs.getString(1));
                ct.setCustomerName(AESCipher.getInstance().decrypt(rs.getNString(2)));
                ct.setCustomerBirthYear(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString(3)))); //or '^.{4}'
                ct.setPhoneNum(AESCipher.getInstance().decrypt(rs.getString(4)));
                ct.setPurchaseTimes(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString(5))));
            }
        } catch (Exception ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ct;
    }
    
    public String GetNameByID(String id){
        String name=null;
        try(Connection conn = cn.getConnect(); Statement stm = conn.createStatement();) {
            String sql= "SELECT customer_name FROM customer "
                    +   "WHERE customer_id = '"+id+"' ";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next())
                name=AESCipher.getInstance().decrypt(rs.getString("customer_name"));
        }catch(Exception e){}
        return name;
    }

    public Customer findByPhoneNum(String phoneNum) {
        String sql = "SELECT * FROM `customer` WHERE AES_DECRYPT(FROM_BASE64(phoneNum),'"+AESCipher.getInstance().getKey()+"') LIKE '"+ phoneNum +"' AND IsDeleted !=1";
        Customer ct = null;
        try(Connection conn = cn.getConnect(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                ct = new Customer();
                ct.setCustomerId(rs.getString(1));
                ct.setCustomerName(AESCipher.getInstance().decrypt(rs.getNString(2)));
                ct.setCustomerBirthYear(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString(3)))); //or '^.{4}'
                ct.setPhoneNum(AESCipher.getInstance().decrypt(rs.getString(4)));
                ct.setPurchaseTimes(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString(5))));
            }
        } catch (Exception ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ct;
    }
    
    public ArrayList<Customer> filter(String filter) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        String sqlGreaterThan = "SELECT * FROM `customer` WHERE CAST(AES_DECRYPT(FROM_BASE64(Purchase_Time),'"+AESCipher.getInstance().getKey()+"') AS SIGNED)) >= 5 AND `IsDeleted` != '1' AND `Customer_id` != 'C0'";
        String sqlSmallerThan = "SELECT * FROM `customer` WHERE CAST(AES_DECRYPT(FROM_BASE64(Purchase_Time),'"+AESCipher.getInstance().getKey()+"') AS SIGNED)) < 5 AND `IsDeleted` != '1' AND `Customer_id` != 'C0'";
        if(filter.equals("Tích lũy < 5")) {
            try(Connection conn = cn.getConnect(); Statement stm = conn.createStatement();) {
                ResultSet rs = stm.executeQuery(sqlSmallerThan);
                while(rs.next()) {
                    Customer ct = new Customer();
                    ct.setCustomerId(rs.getString(1));
                    ct.setCustomerName(AESCipher.getInstance().decrypt(rs.getNString(2)));
                    ct.setCustomerBirthYear(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString(3)))); //or '^.{4}'
                    ct.setPhoneNum(AESCipher.getInstance().decrypt(rs.getString(4)));
                    ct.setPurchaseTimes(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString(5))));
                    customerList.add(ct);
                }
            }
            catch (Exception ex) {
                Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            try(Connection conn = cn.getConnect(); Statement stm = conn.createStatement();) {
                ResultSet rs = stm.executeQuery(sqlGreaterThan);
                while(rs.next()) {
                    Customer ct = new Customer();
                    ct.setCustomerId(rs.getString(1));
                    ct.setCustomerName(AESCipher.getInstance().decrypt(rs.getNString(2)));
                    ct.setCustomerBirthYear(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString(3)))); //or '^.{4}'
                    ct.setPhoneNum(AESCipher.getInstance().decrypt(rs.getString(4)));
                    ct.setPurchaseTimes(Integer.parseInt(AESCipher.getInstance().decrypt(rs.getString(5))));
                    customerList.add(ct);
                }
            }
            catch (Exception ex) {
                Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return customerList;
    }
    
    public int checkPhoneNumExits(String phoneNum){
        String sql = "SELECT COUNT(Customer_id) FROM `customer` WHERE `phoneNum` = ?";
        try (Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);)  {
            pstm.setString(1, AESCipher.getInstance().encrypt(phoneNum));
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) return rs.getInt(1);
        } catch (Exception ex) {
                Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}