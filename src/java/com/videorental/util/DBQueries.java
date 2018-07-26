/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.util;

/**
 *
 * @author Dell
 */
public class DBQueries {
//   <---------------------------------------------------INSERT QUERIES---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

    public static final String INSERT_STAFF = "INSERT INTO " + DBTables.STAFF_TABLE + " (branch_no,name,salary,position) VALUES(?,?,?,?)";
    public static final String INSERT_MEMBER = "INSERT INTO " + DBTables.MEMBER_TABLE + " (branch_no,fname,lname,address,registration_date) VALUES(?,?,?,?,?)";
    public static final String INSERT_BRANCH = "INSERT INTO " + DBTables.BRANCH_TABLE + " (street,city,state,zip_code) VALUES(?,?,?,?)";
    public static final String INSERT_VIDEO = "INSERT INTO " + DBTables.VIDEO_TABLE + " (branch_no,catalog_no,title,category_no_1,category_no_2,category_no_3,daily_rental_cost,cost,main_actor_1,main_actor_2,main_actor_3,main_director_1,main_director_2,no_of_videos) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String INSERT_CATALOG = "INSERT INTO " + DBTables.CATALOG_TABLE + " (branch_no,catalog_name) VALUES (?,?)";
    public static final String INSERT_VIDEO_COPIES = "INSERT INTO " + DBTables.VIDEO_COPIES_TABLE + " (video_no,status) VALUES (?,?)";
    public static final String INSERT_RENTALVIDEOS = "INSERT INTO " + DBTables.RENTAL_TABLE + " (copy_no,member_no,date_rented,date_returned) VALUES(?,?,?,?)";
//   <---------------------------------------------------SELECT QUERIES---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
    public static final String GET_STAFF = "SELECT * FROM " + DBTables.STAFF_TABLE + " ORDER BY staff_no DESC";
    public static final String GET_MEMBER = "SELECT * FROM " + DBTables.MEMBER_TABLE + " ORDER BY member_no DESC";
    public static final String GET_BRANCH = "SELECT * FROM " + DBTables.BRANCH_TABLE + " ORDER BY branch_no ASC";
    public static final String GET_VIDEO = "SELECT * FROM " + DBTables.VIDEO_TABLE + " ORDER BY video_no DESC";
    public static final String GET_CATALOG = "SELECT * FROM " + DBTables.CATALOG_TABLE;
    public static final String GET_VIDEO_COPIES = "SELECT * FROM " + DBTables.VIDEO_COPIES_TABLE;
    public static final String GET_CATEGORIES = "SELECT * FROM " + DBTables.CATEGORY_TABLE + " ORDER BY category_no DESC";
    public static final String GET_CATEGORIES_NAME_BY_ID = "SELECT category_name FROM " + DBTables.CATEGORY_TABLE + " WHERE category_no=?";
    public static final String GET_CATALOG_NAME_BY_ID = "SELECT catalog_name FROM " + DBTables.CATALOG_TABLE + " WHERE catalog_no=?";

//   <---------------------------------------------------UPDATE QUERIES---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
    public static final String UPDATE_STAFF = "UPDATE " + DBTables.STAFF_TABLE + " SET branch_no=?,name=?,position=?,salary=? WHERE staff_no=?";
    public static final String UPDATE_MEMBER = "UPDATE " + DBTables.MEMBER_TABLE + " SET branch_no=?,fname=?,lname=?,address=?,registration_date=? WHERE member_no=?";
    public static final String UPDATE_BRANCH = "UPDATE " + DBTables.BRANCH_TABLE + " SET street=?,city=?,state=?,zip_code=? WHERE branch_no=?";
    public static final String UPDATE_VIDEO = "UPDATE " + DBTables.VIDEO_TABLE + " SET branch_no=?,catalog_no=?,title=?,category_no_1=?,category_no_2=?,category_no_3=?,daily_rental_cost=?,cost=?,main_actor_1=?,main_actor_2=?,main_actor_3=?,main_director_1=?,main_director_2=?,no_of_videos=? WHERE video_no=?";
    public static final String UPDATE_CATALOG = "UPDATE " + DBTables.CATALOG_TABLE + " SET branch_no=?,catalog_name=? WHERE catalog_no=?";
    public static final String UPDATE_VIDEO_COPIES = "UPDATE " + DBTables.VIDEO_COPIES_TABLE + " SET video_no=?,status=? WHERE copy_no=?";

//   <---------------------------------------------------DELETE QUERIES---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
    public static final String DELETE_STAFF = "DELETE FROM " + DBTables.STAFF_TABLE + " WHERE staff_no=?";
    public static final String DELETE_MEMBER = "DELETE FROM " + DBTables.MEMBER_TABLE + " WHERE member_no=?";
    public static final String DELETE_BRANCH = "DELETE FROM " + DBTables.BRANCH_TABLE + " WHERE branch_no=?";
    public static final String DELETE_VIDEO = "DELETE FROM " + DBTables.VIDEO_TABLE + " WHERE video_no=?";
    public static final String DELETE_CATALOG = "DELETE FROM " + DBTables.CATALOG_TABLE + " WHERE catalog_no=?";
    public static final String DELETE_VIDEO_COPIES = "DELETE FROM " + DBTables.VIDEO_COPIES_TABLE + " WHERE copy_no=?";
    public static final String DELETE_VIDEO_COPIES_BY_VIDEO_NO = "DELETE FROM " + DBTables.VIDEO_COPIES_TABLE + " WHERE video_no=?";

//   <---------------------------------------------------SELECT BY NO QUERIES---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
    public static final String GET_STAFF_BY_NO = "SELECT * FROM " + DBTables.STAFF_TABLE + " WHERE staff_no=?";
    public static final String GET_MEMBER_BY_NO = "SELECT * FROM " + DBTables.MEMBER_TABLE + " WHERE member_no=?";
    public static final String GET_BRANCH_BY_NO = "SELECT * FROM " + DBTables.BRANCH_TABLE + " WHERE branch_no=?";
    public static final String GET_VIDEO_BY_NO = "SELECT * FROM " + DBTables.VIDEO_TABLE + " WHERE video_no=?";
    public static final String GET_CATALOG_BY_NO = "SELECT * FROM " + DBTables.CATALOG_TABLE + " WHERE catalog_no=?";
    public static final String GET_VIDEO_COPIES_BY_VIDEO_NO = "SELECT * FROM " + DBTables.VIDEO_COPIES_TABLE + " WHERE video_no=?";

}
