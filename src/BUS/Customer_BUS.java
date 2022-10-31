/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Customer_DAO;
import DTO.Customer;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Customer_BUS {
    private ArrayList<Customer> cusList;
    private Customer_DAO cusDAO;
    
    public Customer_BUS() {
        cusList = new ArrayList<Customer>();
        cusDAO = new Customer_DAO();
        cusList = cusDAO.read();
    }
    
    
    public Boolean checkPrimaryKeyConstrains(Customer ct) {
        for(Customer i : cusList) {
            if(i.getCustomerId().equals(ct.getCustomerId())) {
                System.out.println("Customer' id invalid!");
                return false;
            }
        }
        return true;   
    }
    
    public String addCustomer(Customer ct) {
        String messege = "";
        if(checkPrimaryKeyConstrains(ct)) {
            if(cusDAO.create(ct)) {
//                cusList.add(ct);
                messege = "Thêm khách hàng mới thành công!";
            }
        }
        else messege = "Thêm thất bại, mã id bị trùng!";
        return messege;
    }
    
    public String updateCustomer(Customer ct) {
        String messege = "";
        if(cusDAO.update(ct)) {
            messege = "Cập nhật thông tin khách hàng thành công!";
        }
        else messege = "Mã id không tồn tại!";
        return messege;
    }
    
    public String deleteCustomer(String id) {
        String messege = "";
        if(cusDAO.delete(id)) {
            messege = "Đã xóa dữ liệu khách hàng!";
        }
        else messege = "Rất tiếc, đã có lỗi xảy ra!";
        return messege;
    }
    
    public Customer findCustomerById(String id) {
        Customer ct = cusDAO.findById(id);
        if(ct == null) {
            return null;
        }
        return ct;
    }
    
    public ArrayList<Customer> filterCustomerByPurchase(String filter) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        customerList = cusDAO.filter(filter);
        return customerList;
    }
}