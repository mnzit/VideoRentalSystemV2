/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.model;

/**
 *
 * @author Dell
 */
public class Member {

    private int member_no, branch_no;
    private String fname, lname, address, registration_date;

    public Member() {

    }

    public Member(int member_no, int branch_no, String fname, String lname, String address, String registration_date) {
        this.member_no = member_no;
        this.branch_no = branch_no;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.registration_date = registration_date;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public int getBranch_no() {
        return branch_no;
    }

    public void setBranch_no(int branch_no) {
        this.branch_no = branch_no;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

}
