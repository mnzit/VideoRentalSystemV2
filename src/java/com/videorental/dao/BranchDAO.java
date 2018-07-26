/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao;

import com.videorental.model.Branch;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface BranchDAO {

    int createBranch(Branch b) throws ClassNotFoundException, SQLException;

    int updateBranch(Branch b) throws ClassNotFoundException, SQLException;

    int deleteBranch(Branch b) throws ClassNotFoundException, SQLException;

    List<Branch> allBranch() throws ClassNotFoundException, SQLException;

    List<Branch> getBranchById(int id) throws ClassNotFoundException, SQLException;
    
}

