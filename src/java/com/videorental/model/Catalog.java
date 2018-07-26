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
public class Catalog {

    private int catalog_no, branch_no;
    private String catalog_name;

    public Catalog() {

    }

    public Catalog(int catalog_no, int branch_no, String catalog_name) {
        this.catalog_no = catalog_no;
        this.branch_no = branch_no;
        this.catalog_name = catalog_name;
    }

    public int getCatalog_no() {
        return catalog_no;
    }

    public void setCatalog_no(int catalog_no) {
        this.catalog_no = catalog_no;
    }

    public int getBranch_no() {
        return branch_no;
    }

    public void setBranch_no(int branch_no) {
        this.branch_no = branch_no;
    }

    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

}
