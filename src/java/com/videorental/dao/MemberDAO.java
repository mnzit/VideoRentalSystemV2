/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.dao;

import com.videorental.model.Member;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface MemberDAO {

    int createMember(Member m) throws ClassNotFoundException, SQLException;

    int updateMember(Member m) throws ClassNotFoundException, SQLException;

    int deleteMember(Member m) throws ClassNotFoundException, SQLException;

    List<Member> allMember() throws ClassNotFoundException, SQLException;

    List<Member> getMemberById(int id) throws ClassNotFoundException, SQLException;
}
