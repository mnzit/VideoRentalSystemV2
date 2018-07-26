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
public class Staff {

    private int staff_no, branch_no,salary;
    private String name, position;

    public Staff() {

    }

    public Staff(int staff_no, int branch_no, int salary, String name, String position) {
        this.staff_no = staff_no;
        this.branch_no = branch_no;
        this.salary = salary;
        this.name = name;
        this.position = position;
    }

    public int getStaff_no() {
        return staff_no;
    }

    public void setStaff_no(int staff_no) {
        this.staff_no = staff_no;
    }

    public int getBranch_no() {
        return branch_no;
    }

    public void setBranch_no(int branch_no) {
        this.branch_no = branch_no;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

   
    

}
