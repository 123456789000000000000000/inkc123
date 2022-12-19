package com.example.indiannationalkennelclub.ResponseModel;

public class ResponseModelNotification {
    String noti_id,noti_user_id,url_created,noti_message,noti_status,noti_created_on,noti_updated_on,year,month,day;

    public ResponseModelNotification() {
    }

    public ResponseModelNotification(String noti_id, String noti_user_id, String url_created, String noti_message, String noti_status, String noti_created_on, String noti_updated_on, String year, String month, String day) {
        this.noti_id = noti_id;
        this.noti_user_id = noti_user_id;
        this.url_created = url_created;
        this.noti_message = noti_message;
        this.noti_status = noti_status;
        this.noti_created_on = noti_created_on;
        this.noti_updated_on = noti_updated_on;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getNoti_id() {
        return noti_id;
    }

    public void setNoti_id(String noti_id) {
        this.noti_id = noti_id;
    }

    public String getNoti_user_id() {
        return noti_user_id;
    }

    public void setNoti_user_id(String noti_user_id) {
        this.noti_user_id = noti_user_id;
    }

    public String getUrl_created() {
        return url_created;
    }

    public void setUrl_created(String url_created) {
        this.url_created = url_created;
    }

    public String getNoti_message() {
        return noti_message;
    }

    public void setNoti_message(String noti_message) {
        this.noti_message = noti_message;
    }

    public String getNoti_status() {
        return noti_status;
    }

    public void setNoti_status(String noti_status) {
        this.noti_status = noti_status;
    }

    public String getNoti_created_on() {
        return noti_created_on;
    }

    public void setNoti_created_on(String noti_created_on) {
        this.noti_created_on = noti_created_on;
    }

    public String getNoti_updated_on() {
        return noti_updated_on;
    }

    public void setNoti_updated_on(String noti_updated_on) {
        this.noti_updated_on = noti_updated_on;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
