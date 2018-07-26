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
public class VideoCopies {

    private int copy_no, video_no;
    private boolean status;

    public VideoCopies() {

    }

    public VideoCopies(int copy_no, int video_no, boolean status) {
        this.copy_no = copy_no;
        this.video_no = video_no;
        this.status = status;
    }

    public int getCopy_no() {
        return copy_no;
    }

    public void setCopy_no(int copy_no) {
        this.copy_no = copy_no;
    }

    public int getVideo_no() {
        return video_no;
    }

    public void setVideo_no(int video_no) {
        this.video_no = video_no;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
