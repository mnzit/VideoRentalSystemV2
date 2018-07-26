/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao.daoImpl;

import com.videorental.dao.MemberDAO;
import com.videorental.model.Member;
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
public class MemberDAOImpl implements MemberDAO {

    private DBFunction db = new DBFunction();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createMember(Member m) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.INSERT_MEMBER, new String[]{"MEMBER_NO"});
        pstm.setInt(1, m.getBranch_no());
        pstm.setString(2, m.getFname());
        pstm.setString(3, m.getLname());
        pstm.setString(4, m.getAddress());
        pstm.setString(5, m.getRegistration_date());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int updateMember(Member m) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.UPDATE_MEMBER, new String[]{"MEMBER_NO"});
        pstm.setInt(1, m.getBranch_no());
        pstm.setString(2, m.getFname());
        pstm.setString(3, m.getLname());
        pstm.setString(4, m.getAddress());
        pstm.setString(5, m.getRegistration_date());
        pstm.setInt(6, m.getMember_no());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public int deleteMember(Member m) throws ClassNotFoundException, SQLException {
        db.connect();
        pstm = db.preparedStm(DBQueries.DELETE_MEMBER, new String[]{"MEMBER_NO"});
        pstm.setInt(1, m.getMember_no());
        if (db.update() == 1) {
            return 1;
        }
        db.close();
        return 0;
    }

    @Override
    public List<Member> allMember() throws ClassNotFoundException, SQLException {
        List<Member> allMembers = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_MEMBER, new String[]{"MEMBER_NO"});
        rs = db.retrieve();
        while (rs.next()) {
            Member m = new Member();
            m.setMember_no(rs.getInt(1));
            m.setBranch_no(rs.getInt(2));
            m.setFname(rs.getString(3));
            m.setLname(rs.getString(4));
            m.setAddress(rs.getString(5));
            m.setRegistration_date(rs.getString(6));
            allMembers.add(m);
        }
        db.close();
        return allMembers;
    }

    @Override
    public List<Member> getMemberById(int id) throws ClassNotFoundException, SQLException {
        List<Member> allMembers = new ArrayList<>();
        db.connect();
        pstm = db.preparedStm(DBQueries.GET_MEMBER_BY_NO, new String[]{"MEMBER_NO"});
        pstm.setInt(1, id);
        rs = db.retrieve();
        while (rs.next()) {
            Member m = new Member();
            m.setMember_no(rs.getInt(1));
            m.setBranch_no(rs.getInt(2));
            m.setFname(rs.getString(3));
            m.setLname(rs.getString(4));
            m.setAddress(rs.getString(5));
            m.setRegistration_date(rs.getString(6));
            allMembers.add(m);
        }
        db.close();
        return allMembers;
    }

}
