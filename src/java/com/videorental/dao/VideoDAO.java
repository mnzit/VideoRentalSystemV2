/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao;

import com.videorental.model.Video;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface VideoDAO {

    int createVideo(Video v) throws ClassNotFoundException, SQLException;

    int updateVideo(Video v) throws ClassNotFoundException, SQLException;

    int deleteVideo(Video v) throws ClassNotFoundException, SQLException;

    List<Video> allVideo() throws ClassNotFoundException, SQLException;

    List<Video> getVideoById(int id) throws ClassNotFoundException, SQLException;
}
