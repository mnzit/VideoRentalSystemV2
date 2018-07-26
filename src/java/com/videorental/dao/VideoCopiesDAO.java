/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao;

import com.videorental.model.VideoCopies;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface VideoCopiesDAO {

    int createVideoCopies(VideoCopies vc) throws ClassNotFoundException, SQLException;

    int updateVideoCopies(VideoCopies vc) throws ClassNotFoundException, SQLException;

    int deleteVideoCopies(VideoCopies vc) throws ClassNotFoundException, SQLException;

    List<VideoCopies> allVideoCopies() throws ClassNotFoundException, SQLException;

    List<VideoCopies> getVideoCopiesById(int id) throws ClassNotFoundException, SQLException;
    
    int deleteCopiesByid(int id)throws ClassNotFoundException, SQLException;
}
