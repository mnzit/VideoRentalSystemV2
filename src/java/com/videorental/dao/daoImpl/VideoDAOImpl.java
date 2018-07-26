/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao.daoImpl;

import com.videorental.dao.BranchDAO;
import com.videorental.dao.CatalogDAO;
import com.videorental.dao.CategoryDAO;
import com.videorental.dao.VideoCopiesDAO;
import com.videorental.dao.VideoDAO;
import com.videorental.model.Video;
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
public class VideoDAOImpl implements VideoDAO {

    private DBFunction db = new DBFunction();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private VideoCopiesDAO vcDAO = new VideoCopiesDAOImpl();

    @Override
    public int createVideo(Video v) throws ClassNotFoundException, SQLException {
        db.connect();
        int i = 0;
        int m = 1;
        int n = v.getNo_of_videos();
        pstm = db.preparedStm(DBQueries.INSERT_VIDEO, new String[]{"VIDEO_NO"});
        pstm.setInt(1, v.getBranch_no());
        pstm.setInt(2, v.getCatalog_no());
        pstm.setString(3, v.getTitle());
        pstm.setInt(4, v.getCategory_no_1());
        pstm.setInt(5, v.getCategory_no_2());
        pstm.setInt(6, v.getCategory_no_3());
        pstm.setInt(7, v.getDaily_rental_cost());
        pstm.setInt(8, v.getCost());
        pstm.setString(9, v.getMain_actor_1());
        pstm.setString(10, v.getMain_actor_2());
        pstm.setString(11, v.getMain_actor_3());
        pstm.setString(12, v.getMain_director_1());
        pstm.setString(13, v.getMain_director_2());
        pstm.setInt(14, v.getNo_of_videos());
        if (db.update() == 1) {
            i = db.insertedUid();
            while (m <= n) {
                VideoCopies vc = new VideoCopies();
                vc.setStatus(true);
                vc.setVideo_no(i);
                vcDAO.createVideoCopies(vc);
                m++;
            }
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int updateVideo(Video v) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteVideo(Video v) throws ClassNotFoundException, SQLException {
        vcDAO.deleteCopiesByid(v.getVideo_no());
        db.connect();
        pstm = db.preparedStm(DBQueries.DELETE_VIDEO, new String[]{"VIDEO_NO"});
        pstm.setInt(1, v.getVideo_no());
        if (db.update() == 1) {
            return 1;
        }
        db.connect();
        return 0;
    }

    @Override
        public List<Video> allVideo() throws ClassNotFoundException, SQLException {
        List<Video> allVideos = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_VIDEO, new String[]{"VIDEO_NO"});
        rs = db.retrieve();
        while (rs.next()) {
            Video v = new Video();
            CategoryDAO ctDAO = new CategoryDAOImpl();
            CatalogDAO cDAO = new CatalogDAOImpl();
            v.setVideo_no(rs.getInt(1));
            v.setBranch_no(rs.getInt(2));
            v.setCatalog_name(cDAO.getCatalogByNo(rs.getInt(3)));
            v.setTitle(rs.getString(4));
            v.setCategory_1_name(ctDAO.getCategoryById(rs.getInt(5)));
            v.setCategory_2_name(ctDAO.getCategoryById(rs.getInt(6)));
            v.setCategory_3_name(ctDAO.getCategoryById(rs.getInt(7)));
            v.setDaily_rental_cost(rs.getInt(8));
            v.setCost(rs.getInt(9));
            v.setMain_actor_1(rs.getString(10));
            v.setMain_actor_2(rs.getString(11));
            v.setMain_actor_3(rs.getString(12));
            v.setMain_director_1(rs.getString(13));
            v.setMain_director_2(rs.getString(14));
            v.setNo_of_videos(rs.getInt(15));
            allVideos.add(v);
        }
        db.close();
        return allVideos;
    }

    @Override
        public List<Video> getVideoById(int id) throws ClassNotFoundException, SQLException {
         List<Video> allVideos = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_VIDEO_BY_NO, new String[]{"VIDEO_NO"});
        pstm.setInt(1, id);
        rs = db.retrieve();
        while (rs.next()) {
            Video v = new Video();
            CategoryDAO ctDAO = new CategoryDAOImpl();
            CatalogDAO cDAO = new CatalogDAOImpl();
            v.setVideo_no(rs.getInt(1));
            v.setBranch_no(rs.getInt(2));
            v.setCatalog_no(rs.getInt(3));
            v.setTitle(rs.getString(4));
            v.setCategory_no_1(rs.getInt(5));
            v.setCategory_no_2(rs.getInt(6));
            v.setCategory_no_3(rs.getInt(7));
            v.setDaily_rental_cost(rs.getInt(8));
            v.setCost(rs.getInt(9));
            v.setMain_actor_1(rs.getString(10));
            v.setMain_actor_2(rs.getString(11));
            v.setMain_actor_3(rs.getString(12));
            v.setMain_director_1(rs.getString(13));
            v.setMain_director_2(rs.getString(14));
            v.setNo_of_videos(rs.getInt(15));
            allVideos.add(v);
        }
        db.close();
        return allVideos;
    }

}
