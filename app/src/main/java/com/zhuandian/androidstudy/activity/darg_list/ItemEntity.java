package com.zhuandian.androidstudy.activity.darg_list;

/**
 * @author xiedong
 * @desc
 * @date 2020-03-16.
 */
public class ItemEntity {

    private String username;
    private String time;
    private String message;
    private int img_id;

    public ItemEntity(String username, String time, String message) {
        this.username = username;
        this.time = time;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }
}
