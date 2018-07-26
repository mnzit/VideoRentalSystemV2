/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao.daoImpl;

import com.videorental.dao.VideoCopiesDAO;
import com.videorental.model.VideoCopies;
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
public class VideoCopiesDAOImpl implements VideoCopiesDAO {

    private DBFunction db = new DBFunction();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createVideoCopies(VideoCopies vc) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.INSERT_VIDEO_COPIES, new String[]{"COPY_NO"});
        pstm.setInt(1, vc.getVideo_no());
        pstm.setBoolean(2, vc.isStatus());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int updateVideoCopies(VideoCopies vc) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteVideoCopies(VideoCopies vc) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.DELETE_VIDEO_COPIES, new String[]{"COPY_NO"});
        pstm.setInt(1, vc.getCopy_no());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;

    }

    @Override
    public List<VideoCopies> allVideoCopies() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VideoCopies> getVideoCopiesById(int id) throws ClassNotFoundException, SQLException {
        List<VideoCopies> vcById = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm("select * from video_copies where video_no = ?", new String[]{"COPY_NO"});
        pstm.setInt(1, id);
        rs = db.retrieve();
        while (rs.next()) {
            VideoCopies vc = new VideoCopies();
            vc.setCopy_no(rs.getInt(1));
            vc.setVideo_no(rs.getInt(2));
            vc.setStatus(rs.getBoolean(3));
            vcById.add(vc);
        }
        db.close();
        return vcById;
    }

    @Override
    public int deleteCopiesByid(int id) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.DELETE_VIDEO_COPIES_BY_VIDEO_NO, new String[]{"COPY_NO"});
        pstm.setInt(1, id);
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

}
