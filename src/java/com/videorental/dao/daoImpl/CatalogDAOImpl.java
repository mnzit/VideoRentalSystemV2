/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao.daoImpl;

import com.videorental.dao.CatalogDAO;
import com.videorental.model.Catalog;
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
public class CatalogDAOImpl implements CatalogDAO {

    private DBFunction db = new DBFunction();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createCatalog(Catalog c) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.INSERT_CATALOG, new String[]{"CATALOG_NO"});
        pstm.setInt(1, c.getBranch_no());
        pstm.setString(2, c.getCatalog_name());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int updateCatalog(Catalog c) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.UPDATE_CATALOG, new String[]{"CATALOG_NO"});
        pstm.setInt(1, c.getBranch_no());
        pstm.setString(2, c.getCatalog_name());
        pstm.setInt(3, c.getCatalog_no());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int deleteCatalog(Catalog c) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.DELETE_CATALOG, new String[]{"CATALOG_NO"});
        pstm.setInt(1, c.getCatalog_no());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public List<Catalog> allCatalog() throws ClassNotFoundException, SQLException {
        List<Catalog> allCatalogs = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_CATALOG, new String[]{"CATALOG_NO"});
        rs = db.retrieve();
        while (rs.next()) {
            Catalog c = new Catalog();
            c.setCatalog_no(rs.getInt(1));
            c.setBranch_no(rs.getInt(2));
            c.setCatalog_name(rs.getString(3));
            allCatalogs.add(c);
        }

        db.close();
        return allCatalogs;
    }

    @Override
    public List<Catalog> getCatalogById(int id) throws ClassNotFoundException, SQLException {
        List<Catalog> allCatalogs = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_CATALOG_BY_NO, new String[]{"CATALOG_NO"});
        pstm.setInt(1, id);
        rs = db.retrieve();
        while (rs.next()) {
            Catalog c = new Catalog();
            c.setCatalog_no(rs.getInt(1));
            c.setBranch_no(rs.getInt(2));
            c.setCatalog_name(rs.getString(3));
            allCatalogs.add(c);
        }

        db.close();
        return allCatalogs;
    }

    @Override
    public String getCatalogByNo(int id) throws ClassNotFoundException, SQLException {
        String i ="";
         db.connect();
        pstm = db.preparedStm(DBQueries.GET_CATALOG_NAME_BY_ID, new String[]{"CATALOG_NO"});
        pstm.setInt(1, id);
        rs = db.retrieve();
        while (rs.next()) {
           i = rs.getString(1);
        }

        db.close();
        return i;
    }

}
