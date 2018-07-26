/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao;

import com.videorental.model.Catalog;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface CatalogDAO {

    int createCatalog(Catalog c) throws ClassNotFoundException, SQLException;

    int updateCatalog(Catalog c) throws ClassNotFoundException, SQLException;

    int deleteCatalog(Catalog c) throws ClassNotFoundException, SQLException;

    List<Catalog> allCatalog() throws ClassNotFoundException, SQLException;

    List<Catalog> getCatalogById(int id) throws ClassNotFoundException, SQLException;
    
    String getCatalogByNo(int id) throws ClassNotFoundException, SQLException;
}
