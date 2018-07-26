/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao;

import com.videorental.model.Category;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface CategoryDAO {

    int createCategory(Category ct) throws ClassNotFoundException, SQLException;

    int updateCategory(Category ct) throws ClassNotFoundException, SQLException;

    int deleteCategory(Category ct) throws ClassNotFoundException, SQLException;

    List<Category> allCategory() throws ClassNotFoundException, SQLException;

    String getCategoryById(int id) throws ClassNotFoundException, SQLException;
}
