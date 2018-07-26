/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao.daoImpl;

import com.videorental.dao.CategoryDAO;
import com.videorental.model.Category;
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
public class CategoryDAOImpl implements CategoryDAO {

    private DBFunction db = new DBFunction();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createCategory(Category ct) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateCategory(Category ct) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteCategory(Category ct) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> allCategory() throws ClassNotFoundException, SQLException {
        List<Category> allCategory = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_CATEGORIES, new String[]{"CATEGORY_NO"});
        rs = db.retrieve();
        while (rs.next()) {
            Category ct = new Category();
            ct.setCategory_no(rs.getInt(1));
            ct.setCategory_name(rs.getString(2));
            allCategory.add(ct);
        }
        db.close();
        return allCategory;
    }

    @Override
    public String getCategoryById(int id) throws ClassNotFoundException, SQLException {
        db.connect();
        String i="";
        pstm = db.preparedStm(DBQueries.GET_CATEGORIES_NAME_BY_ID, new String[]{"CATEGORY_NO"});
        pstm.setInt(1,id);
        rs = db.retrieve();
        while (rs.next()) {
          i = rs.getString(1);
        }
        db.close();
        return i;
    }

}
