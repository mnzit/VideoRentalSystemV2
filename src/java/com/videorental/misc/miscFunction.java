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

    public void sellRent(int member_no, int copy_no) throws SQLException, ClassNotFoundException {
       resultSetToArrayList();
    }

    public List<Map<String, Object>> resultSetToArrayList() throws SQLException, ClassNotFoundException {
        db.connect();
        String query="select v.branch_no,r.rental_no,r.member_no,m.fname,m.lname,r.copy_no,v.title,v.daily_rental_cost,r.date_rented,r.date_returned from rental_detail r inner join video_copies vc on r.copy_no = vc.copy_no inner join video v on v.video_no = vc.video_no inner join member m on m.member_no = r.member_no where vc.status = 0";
        pstm = db.preparedStm(query, new String[]{});
        rs = db.retrieve();
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> list = new ArrayList(50);
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }
}
