/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Staff_DAO;
import DTO.Staff;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class Staff_BUS {
    private ArrayList<Staff> staffList;
    private Staff_DAO staffDAO;
    
    public Staff_BUS() throws Exception{
        staffList = new ArrayList<Staff>();
        staffDAO = new Staff_DAO();
        staffList = staffDAO.readStaffs();
    }
    
    public ArrayList<Staff> readStaffsData() throws Exception {
        return staffDAO.readStaffs();
    }
    public Staff readByName(String name) {
        return staffDAO.readByName(name);
    }
    public Staff readById(String id){
        return staffDAO.readById(id);
    }
    
    public Boolean checkPrimaryKey(Staff sf) {
        for(Staff iStaff: staffList) {
            if (iStaff.getStaffId().equals(sf.getStaffId())) {
                System.out.println("Mã nhân viên không hợp lệ");
                return false;
            }
        }
        return true;
    }
    
    public Boolean addStaffString(Staff sf) throws Exception {
        if (checkPrimaryKey(sf)) {
            if (staffDAO.createStaff(sf)) return true;
        }
        return false;
        
    }
    
    public Boolean updateStaffString(Staff sf) throws Exception {
        if (staffDAO.updateStaff(sf)) return true;
        return false;
    }
    
    public Boolean deleteStaffString(String id) {
        
        if (staffDAO.deleteStaff(id)) return true;
        return false;
    }
    
    public ArrayList<Staff> searchStaff(String wordString, String column) {
        return staffDAO.searchStaff(wordString, column);
    }

    public String autoStaffID() {
        return staffDAO.autoStaffId();
    }
    
    public String getNameById(String id) {
        String name = staffDAO.getNameByID(id);
        if (name == null) return "";
        return name;
    }
    
    public Boolean phoneStaffExisted(String id, String phone) throws Exception {
        if (staffDAO.phoneExisted(id, phone)) return true;
        return false;
    }
    
    
    
    
}
