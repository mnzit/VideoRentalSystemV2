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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        String dater = date();
        String stillpending = "NOT RETURNED YET";
        db.connect();
        pstm = db.preparedStm(DBQueries.INSERT_RENTALVIDEOS, new String[]{"RENTAL_NO"});
        pstm.setInt(1, member_no);
        pstm.setInt(2, copy_no);
        pstm.setString(3, dater);
        pstm.setString(4, stillpending);
        if (db.update() == 1) {
            
            return 1;
        }
        db.close();
        return 0;
    }
}
