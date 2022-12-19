package com.example.indiannationalkennelclub;

public class ResponseModelNote {
    String sn, note_id,note_pet_id,note_user_id,note_message,note_created_on,year,month,day;

    public ResponseModelNote() {
    }

    public ResponseModelNote(String sn, String note_id, String note_pet_id, String note_user_id, String note_message, String note_created_on, String year, String month, String day) {
        this.sn = sn;
        this.note_id = note_id;
        this.note_pet_id = note_pet_id;
        this.note_user_id = note_user_id;
        this.note_message = note_message;
        this.note_created_on = note_created_on;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getNote_id() {
        return note_id;
    }

    public void setNote_id(String note_id) {
        this.note_id = note_id;
    }

    public String getNote_pet_id() {
        return note_pet_id;
    }

    public void setNote_pet_id(String note_pet_id) {
        this.note_pet_id = note_pet_id;
    }

    public String getNote_user_id() {
        return note_user_id;
    }

    public void setNote_user_id(String note_user_id) {
        this.note_user_id = note_user_id;
    }

    public String getNote_message() {
        return note_message;
    }

    public void setNote_message(String note_message) {
        this.note_message = note_message;
    }

    public String getNote_created_on() {
        return note_created_on;
    }

    public void setNote_created_on(String note_created_on) {
        this.note_created_on = note_created_on;
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
