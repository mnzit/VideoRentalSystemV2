/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class DBFunction {

    private Connection con = null;
    private PreparedStatement pstm = null;
    private final DBConstants dbConst = new DBConstants();

    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName(dbConst.DRIVER_NAME);
        con = DriverManager.getConnection(dbConst.DB_URL, dbConst.DB_USERNAME, dbConst.DB_PASSWORD);
        if (!con.isClosed() || con != null) {
            System.out.println("Connected to the database");
        }
    }

    public void close() throws ClassNotFoundException, SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
        con = null;
        pstm = null;
    }

    public PreparedStatement preparedStm(String query, String[] incre) throws SQLException {
        pstm = con.prepareStatement(query, incre);
        return pstm;
    }

    public int update() throws SQLException {
        return pstm.executeUpdate();
    }

    public ResultSet retrieve() throws SQLException {
        return pstm.executeQuery();
    }

    public int insertedUid() throws SQLException {
        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            int key = rs.getInt(1);
            return key;
        }
        return -1;
    }
}
