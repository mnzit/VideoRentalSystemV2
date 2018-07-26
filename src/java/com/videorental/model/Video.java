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
public class Video {

    private int video_no, branch_no, catalog_no, category_no_1, category_no_2, category_no_3, daily_rental_cost, cost, no_of_videos;
    private String title, main_actor_1, main_actor_2, main_actor_3, main_director_1, main_director_2, catalog_name,category_1_name,category_2_name,category_3_name;

    public Video() {

    }

    public Video(int video_no, int branch_no, int catalog_no, int category_no_1, int category_no_2, int category_no_3, int daily_rental_cost, int cost, int no_of_videos, String title, String main_actor_1, String main_actor_2, String main_actor_3, String main_director_1, String main_director_2, String catalog_name, String category_1_name, String category_2_name, String category_3_name) {
        this.video_no = video_no;
        this.branch_no = branch_no;
        this.catalog_no = catalog_no;
        this.category_no_1 = category_no_1;
        this.category_no_2 = category_no_2;
        this.category_no_3 = category_no_3;
        this.daily_rental_cost = daily_rental_cost;
        this.cost = cost;
        this.no_of_videos = no_of_videos;
        this.title = title;
        this.main_actor_1 = main_actor_1;
        this.main_actor_2 = main_actor_2;
        this.main_actor_3 = main_actor_3;
        this.main_director_1 = main_director_1;
        this.main_director_2 = main_director_2;
        this.catalog_name = catalog_name;
        this.category_1_name = category_1_name;
        this.category_2_name = category_2_name;
        this.category_3_name = category_3_name;
    }

    public int getVideo_no() {
        return video_no;
    }

    public void setVideo_no(int video_no) {
        this.video_no = video_no;
    }

    public int getBranch_no() {
        return branch_no;
    }

    public void setBranch_no(int branch_no) {
        this.branch_no = branch_no;
    }

    public int getCatalog_no() {
        return catalog_no;
    }

    public void setCatalog_no(int catalog_no) {
        this.catalog_no = catalog_no;
    }

    public int getCategory_no_1() {
        return category_no_1;
    }

    public void setCategory_no_1(int category_no_1) {
        this.category_no_1 = category_no_1;
    }

    public int getCategory_no_2() {
        return category_no_2;
    }

    public void setCategory_no_2(int category_no_2) {
        this.category_no_2 = category_no_2;
    }

    public int getCategory_no_3() {
        return category_no_3;
    }

    public void setCategory_no_3(int category_no_3) {
        this.category_no_3 = category_no_3;
    }

    public int getDaily_rental_cost() {
        return daily_rental_cost;
    }

    public void setDaily_rental_cost(int daily_rental_cost) {
        this.daily_rental_cost = daily_rental_cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNo_of_videos() {
        return no_of_videos;
    }

    public void setNo_of_videos(int no_of_videos) {
        this.no_of_videos = no_of_videos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMain_actor_1() {
        return main_actor_1;
    }

    public void setMain_actor_1(String main_actor_1) {
        this.main_actor_1 = main_actor_1;
    }

    public String getMain_actor_2() {
        return main_actor_2;
    }

    public void setMain_actor_2(String main_actor_2) {
        this.main_actor_2 = main_actor_2;
    }

    public String getMain_actor_3() {
        return main_actor_3;
    }

    public void setMain_actor_3(String main_actor_3) {
        this.main_actor_3 = main_actor_3;
    }

    public String getMain_director_1() {
        return main_director_1;
    }

    public void setMain_director_1(String main_director_1) {
        this.main_director_1 = main_director_1;
    }

    public String getMain_director_2() {
        return main_director_2;
    }

    public void setMain_director_2(String main_director_2) {
        this.main_director_2 = main_director_2;
    }

    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

    public String getCategory_1_name() {
        return category_1_name;
    }

    public void setCategory_1_name(String category_1_name) {
        this.category_1_name = category_1_name;
    }

    public String getCategory_2_name() {
        return category_2_name;
    }

    public void setCategory_2_name(String category_2_name) {
        this.category_2_name = category_2_name;
    }

    public String getCategory_3_name() {
        return category_3_name;
    }

    public void setCategory_3_name(String category_3_name) {
        this.category_3_name = category_3_name;
    }

}
