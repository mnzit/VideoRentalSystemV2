/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao.daoImpl;

import com.videorental.dao.BranchDAO;
import com.videorental.model.Branch;
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
public class BranchDAOImpl implements BranchDAO {

    private DBFunction db = new DBFunction();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createBranch(Branch b) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.INSERT_BRANCH, new String[]{"BRANCH_NO"});
        pstm.setString(1, b.getStreet());
        pstm.setString(2, b.getCity());
        pstm.setString(3, b.getState());
        pstm.setInt(4, b.getZip_code());
        if (db.update() == 1) {

            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int updateBranch(Branch b) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.UPDATE_BRANCH, new String[]{"BRANCH_NO"});
        pstm.setString(1, b.getStreet());
        pstm.setString(2, b.getCity());
        pstm.setString(3, b.getState());
        pstm.setInt(4, b.getZip_code());
        pstm.setInt(5, b.getBranch_no());
        if (db.update() == 1) {

            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int deleteBranch(Branch b) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.DELETE_BRANCH, new String[]{"BRANCH_NO"});
        pstm.setInt(1, b.getBranch_no());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public List<Branch> allBranch() throws ClassNotFoundException, SQLException {
        List<Branch> allBranch = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_BRANCH, new String[]{"BRANCH_NO"});
        rs = db.retrieve();
        while (rs.next()) {
            Branch b = new Branch();
            b.setBranch_no(rs.getInt(1));
             b.setStreet(rs.getString(2));
            b.setCity(rs.getString(3));
            b.setState(rs.getString(4));        
            b.setZip_code(rs.getInt(5));
            allBranch.add(b);
        }
        db.close();
        return allBranch;
    }

    @Override
    public List<Branch> getBranchById(int id) throws ClassNotFoundException, SQLException {
        List<Branch> branch = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_BRANCH_BY_NO,new String[]{"BRANCH_NO"});
        pstm.setInt(1, id);
        rs = db.retrieve();
        while (rs.next()) {
            Branch b = new Branch();
            b.setBranch_no(rs.getInt(1));
            b.setCity(rs.getString(2));
            b.setState(rs.getString(3));
            b.setStreet(rs.getString(4));
            b.setZip_code(rs.getInt(5));
            branch.add(b);
        }
        db.close();
        return branch;
    }

}
