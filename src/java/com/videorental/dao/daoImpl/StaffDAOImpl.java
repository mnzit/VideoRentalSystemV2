/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao.daoImpl;

import com.videorental.dao.StaffDAO;
import com.videorental.model.Staff;
import com.videorental.util.DBFunction;
import com.videorental.util.DBQueries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class StaffDAOImpl implements StaffDAO {

    private DBFunction db = new DBFunction();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createStaff(Staff s) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.INSERT_STAFF, new String[]{"STAFF_NO"});
        pstm.setInt(1, s.getBranch_no());
        pstm.setString(2, s.getName());
        pstm.setInt(3, s.getSalary());
        pstm.setString(4, s.getPosition());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int updateStaff(Staff s) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.UPDATE_STAFF, new String[]{"STAFF_NO"});
        pstm.setInt(1, s.getBranch_no());
        pstm.setString(2, s.getName());
        pstm.setString(3, s.getPosition());
        pstm.setInt(4, s.getSalary());
        pstm.setInt(5, s.getStaff_no());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int deleteStaff(Staff s) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.DELETE_STAFF, new String[]{"STAFF_NO"});
        pstm.setInt(1, s.getStaff_no());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public List<Staff> allStaffs() throws ClassNotFoundException, SQLException {
        List<Staff> allStaffs = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_STAFF, new String[]{"STAFF_NO"});
        rs = db.retrieve();
        while (rs.next()) {
            Staff s = new Staff();
            s.setStaff_no(rs.getInt(1));
            s.setBranch_no(rs.getInt(2));
            s.setName(rs.getString(3));
            s.setPosition(rs.getString(4));
            s.setSalary(rs.getInt(5));        
            allStaffs.add(s);
        }

        db.close();
        return allStaffs;
    }

    @Override
    public List<Staff> getStaffById(int id) throws ClassNotFoundException, SQLException {
         List<Staff> allStaffs = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_STAFF_BY_NO,new String[]{"STAFF_NO"});
        pstm.setInt(1, id);
        rs = db.retrieve();
        while (rs.next()) {
            Staff s = new Staff();
            s.setStaff_no(rs.getInt(1));
            s.setBranch_no(rs.getInt(2));
            s.setName(rs.getString(3));
            s.setPosition(rs.getString(4));
            s.setSalary(rs.getInt(5));        
            allStaffs.add(s);
        }

        db.close();
        return allStaffs;
    }

}
