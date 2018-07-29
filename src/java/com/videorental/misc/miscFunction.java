/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.misc;

import com.videorental.util.DBFunction;
import com.videorental.util.DBQueries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dell
 */
public class miscFunction {

    private DBFunction db = new DBFunction();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    public String date() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public int sellRent(int member_no, int copy_no) throws SQLException, ClassNotFoundException {
        db.connect();
        pstm = db.preparedStm(DBQueries.INSERT_RENTALVIDEOS, new String[]{});
        pstm.setInt(1, member_no);
        pstm.setInt(2, copy_no);
        pstm.setString(3, date());
        pstm.setString(4, "NOT RETURNED YET");
        if (db.update() == 1) {
            pstm = db.preparedStm(DBQueries.UPDATE_VIDEO_COPIES, new String[]{});
            pstm.setBoolean(1, false);
            pstm.setInt(2, copy_no);
            db.update();
            return 1;
        }
        db.close();
        return 0;

    }

    public List<Map<String, Object>> resultSetToArrayList() throws SQLException, ClassNotFoundException {
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_RENTAL_DETAILS, new String[]{});
        rs = db.retrieve();
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> list = new ArrayList<>();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }
}
